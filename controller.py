from datetime import date
from lib2to3.pytree import Base
import random
from urllib.request import urlopen
from peewee import *
import json

from models.modelos import Autor, Exposicion, Libro

db = SqliteDatabase("Base de Datos")
db.connect()


def save(dato):
    try:        
        dato.save(force_insert=True)
    except Exception as e:
        print(e)
        
    
"""
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
      """
 
with open("libros.json") as file:
    data2 = json.load(file)
    
    for libro in data2:
        
        objectBook= Libro(
            IdLibro=libro["id_BNE"],
            Titulo=libro["título"],
            FechaNac=libro["fecha_publicacion"],
            Lenguaje=libro["lengua_publicacion"]
        )
        save(objectBook)
        
        
 #Abrir url para extraer datos JSON para la tabla exposiciones
exposicion = urlopen("http://nexo.carm.es/nexo/archivos/recursos/opendata/json/SalasdeExposiciones.json")
data = json.load(exposicion)

inicio=date(2022,1,1) 
final=date(2024,1,1)

#Ejecutar consulta para extraer id de libro y de autor para la tabla exposiciones
#idAutores=puntero.execute("Select Id from AUTORES")
#contadorAutores=idAutores.fetchall()
#longitudTupla=len(contadorAutores)


"""
idLibro=puntero.execute("Select idLibro from LIBROS")
idLibrosTupla=idLibro.fetchall()
idLibrosLength=len(idLibrosTupla)
"""

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
       