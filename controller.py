from ast import And
from datetime import date
from lib2to3.pytree import Base
import random
from urllib.request import urlopen
from paramiko import AutoAddPolicy
from peewee import *
import json

from models.modelos import Autor, Autor_Exposicion, Exposicion, Libro, Libro_Exposicion


db = SqliteDatabase("Base de Datos")
db.connect()

#Función para guardar datos en la base de datos
def save(dato):
    try:        
        dato.save(force_insert=True)
    except Exception as e:
        print("Error: ",e)

#Función para actualizar datos        
def update(dato):
    try:
               
        dato.save()
    except Exception as e:
        print("Error: ",e)
        
#Función para volcar los datos del json de autores
# en la base de datos    
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
      
      
#Función para volcar los datos del json de libros
# en la base de datos       
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

#Función para volcar los datos del json de exposiciones
# en la base de datos         
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

#Genera la asociación aleatoria de libros en exposiciones  
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
#Genera la asociación aleatoria de autores en exposiciones 
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
        
 #Función para insertar registro en función del tipo de registro       
def insertarRegistro(arrayDatos,tipo):
    
        if tipo=="autor":
            insertarAutor(arrayDatos)
            
        elif tipo=="libro":
            insertarLibro(arrayDatos)
            
        else:
            insertarExposicion(arrayDatos)
            
    
#Función que crea el objeto Autor con los datos recibidos y lo
#inserta en la base de datos
def insertarAutor(datosAutor):
    autor=Autor(
        FechaNac=datosAutor["fecha_nac"],
        Nombre=datosAutor["nombre"],
        Sinopsis=datosAutor["sinopsis"]
    )
    
    save(autor)
    
#Función que crea el objeto Libro con los datos recibidos y lo
#inserta en la base de datos    
def insertarLibro(datosLibro):
    if(comprobarExistencia("libro",datosLibro["id"])==0):
        libro=Libro(
            IdLibro=datosLibro["isbn"],
            Titulo=datosLibro["titulo"],
            FechaPublicacion=datosLibro["fecha_publicacion"],
            Lenguaje=datosLibro["lenguaje"]
            
        )
        save(libro)
 
#Función que crea el objeto Exposición con los datos recibidos y lo
#inserta en la base de datos 
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
    
#Función que con los datos recibidos inserta la organización
# de una exposición y lo inserta en la base de datos
def insertarRelacion(datosRelacion):
    
        #insert
        autor=Autor_Exposicion(
            idAutor=datosRelacion["idAutor"],
            idExp=datosRelacion["idExpo"]
        )

        libro=Libro_Exposicion(
            idLibro=datosRelacion["idLibro"],
            idExp=datosRelacion["idExpo"]
        )
        
        save(autor)
        save(libro)

#Función para comprobar la existencia de id antes de 
#insertar un nuevo registro
def comprobarExistencia(tipo,id,id2=0):

    switcher=0
    if tipo=="exposicion":
            switcher=Exposicion.select().where(Exposicion.IdExp==id).count()
    elif tipo=="autor":
            switcher=Autor.select().where(Autor.Id==id).count()
    elif tipo=="libro":
             switcher=Libro.select().where(Libro.IdLibro==id).count()
    elif tipo=="libro-expo":
             switcher=Libro_Exposicion.select().where((Libro_Exposicion.idLibro==id) & (Libro_Exposicion.idExp==id2)).count()
    elif tipo=="autor-expo":
            switcher=Autor_Exposicion.select().where((Autor_Exposicion.idAutor==id) & (Autor_Exposicion.idExp==id2)).count()

    
    return switcher          



#Función que realiza el borrado de registros
def borrarRegistros(id,tipo):
     
    if tipo=="exposicion":
            Exposicion.delete_by_id(id)
            Autor_Exposicion.delete().where(Autor_Exposicion.idExp==id)
            Libro_Exposicion.delete().where(Libro_Exposicion.idExp==id)
    elif tipo=="autor":
            Autor.delete_by_id(id)
            Autor_Exposicion.delete().where(Autor_Exposicion.idAutor==id)
    elif tipo=="libro":
            Libro.delete_by_id(id)
            Libro_Exposicion.delete().where(Libro_Exposicion.idLibro==id)


#Función que realiza la actualización de registros por tipo
def actualizaRegistro(arrayDatos,tipo):
    
    if(tipo=="autor"):
        updateAutor(arrayDatos)
    elif(tipo=="libro"):
        updateLibro(arrayDatos)
    elif(tipo=="exposicion"):
        updateExposicion(arrayDatos)
   
    
#Función que hace un update del objeto Autor con los datos recibidos y lo
#inserta en la base de datos
def updateAutor(datosAutor):
    autor=Autor(
        Id=datosAutor["id"],
        FechaNac=datosAutor["fecha_nac"],
        Nombre=datosAutor["nombre"],
        Sinopsis=datosAutor["sinopsis"]
    )
    update(autor)
    
#Función que hace un update del objeto Libro con los datos recibidos y lo
#inserta en la base de datos    
def updateLibro(datosLibro):
        libro=Libro(
            IdLibro=datosLibro["isbn"],
            Titulo=datosLibro["titulo"],
            FechaPublicacion=datosLibro["fecha_publicacion"],
            Lenguaje=datosLibro["lenguaje"] 
        )
        update(libro)

#Función que hace un update del objeto Exposicion con los datos recibidos y lo
#inserta en la base de datos        
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

#Función que se encarga de buscar registros
# filtrados por el nombre y el tipo      
def buscarRegistro(tipo,nombre):
    switcher={}
    if tipo=="autor":
            switcher=Autor.select().where(Autor.Nombre.contains(nombre))
    elif tipo=="libro":
             switcher=Libro.select().where(Libro.Titulo.contains(nombre))
    elif tipo=="exposicion":
            switcher=Exposicion.select().where(Exposicion.nombre.contains(nombre))
    
    type(switcher)
    return switcher


#Función que obtiene todos los datos de la tabla que
#seleccionemos
def buscarDatos(tipo):
    switcher={}
    if tipo=="autor":
            switcher=Autor.select()
    elif tipo=="libro":
             switcher=Libro.select()
    elif tipo=="exposicion":
            switcher=Exposicion.select()
    
    return switcher

#Función encargada de recoger en un array los datos que
#se van a mostrar en formato JSON del tipo seleccionado
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

#Función encargada de recoger en un array los datos que
#se van a mostrar en formato JSON del tipo seleccionado
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

def nuevasOrganizaciones():
    newOrg=Exposicion.select().where(Exposicion.IdExp.not_in(Autor_Exposicion.select(Autor_Exposicion.idExp)))

    exposiciones=[]
    for dato in newOrg:
        exposiciones.append(dato.__dict__())
        
    return exposiciones   

    

