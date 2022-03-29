from ast import And
from datetime import date
import random
from urllib.request import urlopen
from paramiko import AutoAddPolicy
from peewee import *
import json

from models.modelos import Autor, Autor_Exposicion, Exposicion, Libro, Libro_Exposicion


db = SqliteDatabase("Base de Datos")
db.connect()


def save(dato):
    try:        
        dato.save(force_insert=True)
    except Exception as e:
        print("Error: ",e)
        
def update(dato):
    try:      
        print("hola")  
        dato.save()
    except Exception as e:
        print("Error: ",e)
        
    
def volcarDatosAutor():
    with open("datosJson/autor.json") as file:
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
    with open("datosJson/libros.json") as file:
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
    
        if tipo=="autor":
            insertarAutor(arrayDatos)
            
        elif tipo=="libro":
            insertarLibro(arrayDatos)
            
        else:
            insertarExposicion(arrayDatos)
            
    

def insertarAutor(datosAutor):
    autor=Autor(
        FechaNac=datosAutor["fecha_nac"],
        Nombre=datosAutor["nombre"],
        Sinopsis=datosAutor["sinopsis"]
    )
    
    save(autor)
    
    
def insertarLibro(datosLibro):
    if(comprobarExistencia("libro",datosLibro["id"])==0):
        libro=Libro(
            IdLibro=datosLibro["isbn"],
            Titulo=datosLibro["titulo"],
            FechaPublicacion=datosLibro["fecha_publicacion"],
            Lenguaje=datosLibro["lenguaje"]
            
        )
        save(libro)
 
 
def insertarExposicion(datosExpo):
    if(comprobarExistencia("exposicion",datosExpo["id"])==0):
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

    else:
        print("Ya existe la Exposicion")
    

def insertarRelacion(datosRelacion):
    
    libEx=comprobarExistencia("libro-expo",datosRelacion["idLibro"],datosRelacion["idExpo"])
    autorEx=comprobarExistencia("autor-expo",datosRelacion["idAutor"],datosRelacion["idExpo"])
    
    print (libEx)
    print(autorEx)
    
    if(libEx and autorEx):
        #updates
        print("update libro y autor")
    elif(libEx and not autorEx):
        #update libEx
        print("update libro")
    elif(not libEx and autorEx):
        #update autorEx
        print("update autor")
    else:
        #insert
        print("insert libro y autor")

def comprobarExistencia(tipo,id,id2):
    print(id)
    print(id2)
    switcher={
        "exposicion":
            Exposicion.select().where(Exposicion.IdExp==id).count(),
            
        "autor":
            Autor.select().where(Autor.Id==id).count(),
        "libro":
             Libro.select().where(Libro.IdLibro==id).count(),
        "libro-expo":
            Libro_Exposicion.select().where(Libro_Exposicion.idLibro==id and Libro_Exposicion.idExp==id2).count(),
        "autor-expo":
            Autor_Exposicion.select().where(Autor_Exposicion.idAutor==id and Autor_Exposicion.idExp==id2).count(),
    }.get(tipo)
    
    return switcher          

"""datosRelacion={"idLibro":"duyjvhj","idAutor":"1","idExpo":"138"}
insertarRelacion(datosRelacion)"""

#Borrar datos
def borrarRegistros(id,tipo):
     
    if tipo=="exposicion":
            Exposicion.delete_by_id(id)
            print(Autor_Exposicion.select(Autor_Exposicion.idExp).where(Autor_Exposicion.idExp==id))
    elif tipo=="autor":
            Autor.delete_by_id(id)
            Autor_Exposicion.delete_by_id(id)
    elif tipo=="libro":
            Libro.delete_by_id(id)
            Libro_Exposicion.delete_by_id(id)



def actualizaRegistro(arrayDatos,tipo):
    
    if(tipo=="autor"):
        updateAutor(arrayDatos)
    elif(tipo=="libro"):
        updateLibro(arrayDatos)
    elif(tipo=="exposicion"):
        updateExposicion(arrayDatos)
    # switcher={
    #     "autor":
    #         #updateAutor(arrayDatos)
    #        updateAutor(arrayDatos)
    #         ,
    #     "libro":
    #         #updateLibro(arrayDatos)
    #         updateLibro(arrayDatos)
    #         ,
    #     "exposicion":
    #         updateExposicion(arrayDatos)
            
    # }.get(tipo)
    

def updateAutor(datosAutor):
    autor=Autor(
        Id=datosAutor["id"],
        FechaNac=datosAutor["fecha_nac"],
        Nombre=datosAutor["nombre"],
        Sinopsis=datosAutor["sinopsis"]
    )
    update(autor)
    
    
def updateLibro(datosLibro):
        libro=Libro(
            IdLibro=datosLibro["isbn"],
            Titulo=datosLibro["titulo"],
            FechaPublicacion=datosLibro["fecha_publicacion"],
            Lenguaje=datosLibro["lenguaje"] 
        )
        update(libro)
        
def updateExposicion(datosExpo):
    expo=Exposicion(
        IdExp=datosExpo["id"],
        Descripcion=datosExpo["descripcion"],
        Fecha=datosExpo["fecha"],
        nombre=datosExpo["nombre"],
        direccion=datosExpo["direccion"],
        codigoPostal=datosExpo["cp"],
        municipio=datosExpo["municipio"]
    )
    update(expo)
      
def buscarRegistro(tipo,nombre):
    switcher={
        "autor":
            Autor.select().where(Autor.Nombre.contains(nombre)),
        "libro":
             Libro.select().where(Libro.Titulo.contains(nombre)),
        "exposicion":
            Exposicion.select().where(Exposicion.nombre.contains(nombre))
    }.get(tipo)
    return switcher

#dato=buscarRegistro("autor","Abad")
#for a in dato:
#    print(a.Nombre)

def buscarDatos(tipo):
    switcher={
        "autor":
            Autor.select(),
        "libro":
             Libro.select(),
        "exposicion":
            Exposicion.select()
    }.get(tipo)
    return switcher

def mostrarDatos(tipo):
    datos=buscarDatos(tipo)
    if(tipo=="autor"):
        autores=[]
        for dato in datos:
            autores.append(dato.__dict__())
            
        return autores            
            
    elif(tipo=="libro"):
        libros=[]
        for dato in datos:
            libros.append(dato.__dict__())
            
        return libros  
    else:
        exposiciones=[]
        for dato in datos:
            exposiciones.append(dato.__dict__())
            
        return exposiciones  

def mostrarRegistro(tipo,nombre):
    datos=buscarRegistro(tipo,nombre)
    if(tipo=="autor"):
        autores=[]
        for dato in datos:
            autores.append(dato.__dict__())
        return autores
            
    elif(tipo=="libro"):
            libros=[]
            for dato in datos:
                libros.append(dato.__dict__())
            return libros  
    else:
        exposiciones=[]
        for dato in datos:
            exposiciones.append(dato.__dict__())
            
        return exposiciones 

#mostrarDatos("libro")
mostrarRegistro("autor","Abad")