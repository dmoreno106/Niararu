from lib2to3.pytree import Base
from peewee import *

db = SqliteDatabase("Base de Datos")

"""
class BaseModel(Model):
    class Meta:
        db = db
        """

class Autor (Model):
    Id = AutoField(primary_key=True)
    FechaNac = DateField()
    Nombre = CharField()
    Sinopsis = CharField()
    
    class Meta:
            database = db
    
class Libro(Model):
    IdLibro = CharField(primary_key=True)
    Titulo = CharField()
    FechaNac = CharField() 
    Lenguaje = CharField()
    
    class Meta:
            database = db
      
            

class Exposicion(Model):
    IdExp =  CharField(primary_key=True) 
    Descripcion=CharField()
    Fecha=DateField()
    nombre=CharField()
    direccion=CharField()
    codigoPostal=IntegerField()
    municipio=CharField()
    
    class Meta:
            database = db
    
class Autor_Exposicion(Model):
    idAutor=ForeignKeyField(Autor,related_name="autor")
    idExp=ForeignKeyField(Exposicion,related_name="exposicion")   
    
    class Meta:
            database = db 
            primary_key=False
    
    
class Libro_Exposicion(Model):
    idLibro=ForeignKeyField(Libro,related_name="libro")
    idExp=ForeignKeyField(Exposicion,related_name="exposicion")
    
    class Meta:
            database = db
            primary_key=False
   

db.connect()
db.create_tables([Autor,Libro,Exposicion,Autor_Exposicion,Libro_Exposicion])   