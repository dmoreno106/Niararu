import json
import random
import sqlite3
from traceback import print_tb
from urllib.request import urlopen

conexion = sqlite3.connect("Base de Datos")

puntero = conexion.cursor()
#conexion.execute("DROP TABLE LIBROS")
#conexion.execute("CREATE TABLE AUTORES (Id INTEGER PRIMARY KEY, FechaNac DATE, Nombre VARCHAR(100), Sinopsis VARCHAR2(100))")
#conexion.execute("CREATE TABLE LIBROS (IdLibro INTEGER AUTO_INCREMENT PRIMARY KEY , IdAutor INTEGER, Titulo VARCHAR2(100), FechaNac DATE, Lenguaje VARCHAR2(100), FOREIGN KEY (IdAutor) REFERENCES AUTORES (Id))")

with open("autor.json") as file:
    data = json.load(file)
    
    """for autor in data:
        fecha = autor["fecha_de_nacimiento"]
        nombre = autor["nombre_de_persona"]
        sinopsis = autor["información_encontrada"]
        info_array = [fecha,nombre,sinopsis]
        puntero.execute("INSERT INTO AUTORES  (FechaNac, Nombre, Sinopsis)VALUES(?,?,?)", info_array)"""
      
    

with open("libros.json") as file:
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
        puntero.execute("INSERT INTO LIBROS VALUES(?,?,?,?,?)", info_array)
#print(datos.read())

conexion.commit()
"""puntero.execute("SELECT * FROM AUTORES")
a=puntero.fetchall()
for p in a:
    print("hola")
    """
puntero.close()
conexion.close()