from datetime import date
from lib2to3.pytree import Base
import random
from urllib.request import urlopen
from peewee import *
import json

from models.modelos import Autor, Autor_Exposicion, Exposicion, Libro, Libro_Exposicion

db = SqliteDatabase("Base de Datos")
db.connect()


def save(dato):
    try:        
        dato.save(force_insert=True)
    except Exception as e:
        print(e)
        
    
def volcarDatosAutor():
    with open("autor.json") as file:
        data = json.load(file)
        
        for autor in data:
            objectAuthor= Autor(
                FechaNac=autor["fecha_de_nacimiento"],
                Nombre=autor["nombre_de_persona"],
                Sinopsis=autor["información_encontrada"]
            )
            #print(objectAuthor.Nombre)
            save(objectAuthor)
      
      
      
def volcarDatosLibros(): 
    with open("libros.json") as file:
        data2 = json.load(file)
        
        for libro in data2:
            
            objectBook= Libro(
                IdLibro=libro["id_BNE"],
                Titulo=libro["título"],
                FechaPublicacion=libro["fecha_publicacion"],
                Lenguaje=libro["lengua_publicacion"]
            )
            save(objectBook)
        
def volcarDatosExposiciones():        
#Abrir url para extraer datos JSON para la tabla exposiciones
    exposicion = urlopen("http://nexo.carm.es/nexo/archivos/recursos/opendata/json/SalasdeExposiciones.json")
    data = json.load(exposicion)

    inicio=date(2022,1,1) 
    final=date(2024,1,1)
    for exposiciones in data:
        try:
            descripcion=exposiciones["Descripción"]
        except:
            descripcion=""
        
        exposiciones=Exposicion(
            IdExp = exposiciones["Código"],
            Descripcion=descripcion,
            Fecha= inicio+(final-inicio)*random.random(),
            nombre=exposiciones["Nombre"],
            direccion=exposiciones["Dirección"],
            codigoPostal=exposiciones["C.P."],
            municipio=exposiciones["Municipio"]
        )
        save(exposiciones)
  
def volcarDatosLibExp():    
    IdLibros=Libro.select(Libro.IdLibro)
    IdExposicion=Exposicion.select(Exposicion.IdExp)

    global arrayLibros
    arrayLibros=[]

    for libroId in IdLibros:    
        arrayLibros.append(str(libroId))
        

    for exposicion in IdExposicion:
        randomLibro= random.sample(arrayLibros,1)    
        libro_exposicion=Libro_Exposicion(
            idLibro=randomLibro[0],
            idExp=exposicion
        )
        save(libro_exposicion)

def volcarDatosAutExp():
    IdAutor=Autor.select(Autor.Id)
    IdExposicion=Exposicion.select(Exposicion.IdExp)

    global arrayAutores
    arrayAutores=[]

    for autorId in IdAutor:    
        arrayAutores.append(str(autorId))
        

    for exposicion in IdExposicion:
        randomAutor= random.sample(arrayAutores,1)    
        autor_exposicion=Autor_Exposicion(
            idAutor=randomAutor[0],
            idExp=exposicion
        )
        save(autor_exposicion)
        
        
def insertarRegistro(arrayDatos,tipo):
    switcher={
        "autor":
            insertarAutor(arrayDatos)
            ,
        "libro":
            insertarLibro(arrayDatos)
            ,
        "exposicion":
            insertarExposicion(arrayDatos)
            
    }.get(tipo)

def insertarAutor(datosAutor):
    autor=Autor(
        FechaNac=datosAutor["fecha_nac"],
        Nombre=datosAutor["nombre"],
        Sinopsis=datosAutor["sinopsis"]
    )
    
    save(autor)
    
def insertarLibro(datosLibro):
    libro=Libro(
        IdLibro=datosLibro["isbn"],
        Titulo=datosLibro["titulo"],
        FechaPublicacion=datosLibro["fecha_publicacion"],
        Lenguaje=datosLibro["lenguaje"]
        
    )
    save(libro)
 
def insertarExposicion(datosExpo):
    expo=Exposicion(
        IdExp=datosExpo["id"],
        Descripcion=datosExpo["descripcion"],
        Fecha=datosExpo["fecha"],
        nombre=datosExpo["nombre"],
        direccion=datosExpo["direccion"],
        codigoPostal=datosExpo["cp"],
        municipio=datosExpo["municipio"]
    )
    save(expo)

def comprobarExistencia(id,tipo):
    switcher={
        "exposicion":
            Exposicion.select(Exposicion.IdExp).where(Exposicion.IdExp==id)
            ,
        "libro":
        
    }