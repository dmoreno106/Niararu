from cmath import exp
import json
import random
import sqlite3
from traceback import print_tb
from urllib.request import urlopen
from datetime import date

conexion = sqlite3.connect("Base de Datos")

puntero = conexion.cursor()



with open("autor.json") as file:
    data = json.load(file)
    
    for autor in data:
        fecha = autor["fecha_de_nacimiento"]
        nombre = autor["nombre_de_persona"]
        sinopsis = autor["información_encontrada"]
        info_array = [fecha,nombre,sinopsis]
        puntero.execute("INSERT INTO AUTORES  (FechaNac, Nombre, Sinopsis)VALUES(?,?,?)", info_array)
      
    

"""with open("libros.json") as file:
    librosData = json.load(file)
    contador=puntero.execute("Select * from AUTORES ")
   
    
    tupla=contador.fetchall()
    longitudTupla=len(tupla)
    for libro in librosData:
        i=random.randint(1,longitudTupla)
        id=libro['id_BNE']
        titulo=libro["título"]
        fechaPublicacion=libro["fecha_publicacion"]
        lenguaje=libro["lengua_publicacion"]
        idAutor=i
        info_array = [id,idAutor,titulo,fechaPublicacion,lenguaje]
        puntero.execute("INSERT INTO LIBROS VALUES(?,?,?,?,?)", info_array)"""


#Abrir url para extraer datos JSON para la tabla exposiciones
exposicion = urlopen("http://nexo.carm.es/nexo/archivos/recursos/opendata/json/SalasdeExposiciones.json")
jsonExpos = json.load(exposicion)

inicio=date(2022,1,1) 
final=date(2024,1,1)

#Ejecutar consulta para extraer id de libro y de autor para la tabla exposiciones
idAutores=puntero.execute("Select Id from AUTORES")
contadorAutores=idAutores.fetchall()
longitudTupla=len(contadorAutores)



idLibro=puntero.execute("Select idLibro from LIBROS")
idLibrosTupla=idLibro.fetchall()
idLibrosLength=len(idLibrosTupla)






"""for exposiciones in jsonExpos:
    idAutor=random.randint(1,longitudTupla)
    posicionIdLibroTupla=random.randint(1,idLibrosLength)
    idLibro=idLibrosTupla[posicionIdLibroTupla][0]
    id = exposiciones["Código"]
    nombre=exposiciones["Nombre"]
    direccion=exposiciones["Dirección"]
    codigoPostal=exposiciones["C.P."]
    municipio=exposiciones["Municipio"]
  
    
    fecha= inicio+(final-inicio)*random.random()
    try:
        descripcion=exposiciones["Descripción"]
    except:
        descripcion=""

    print(idLibro)
    print(descripcion)
    print(fecha)
    print(idAutor)"""

conexion.commit()
"""puntero.execute("SELECT * FROM AUTORES")
a=puntero.fetchall()
for p in a:
    print("hola")
    """
puntero.close()
conexion.close()