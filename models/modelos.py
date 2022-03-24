from lib2to3.pytree import Base
from peewee import *

db = SqliteDatabase("Base de Datos")

"""
class BaseModel(Model):
    class Meta:
        db = db
        """

class Autor (Model):
    Id = AutoField()
    FechaNac = DateField()
    Nombre = CharField()
    Sinopsis = CharField()
    
    class Meta:
            database = db
    
class Libro(Model):
    IdLibro = CharField()
    IdAutor = ForeignKeyField(Autor, related_name="libros")
    Titulo = CharField()
    FechaNac = DateField() 
    Lenguaje = CharField()
    
    class Meta:
            database = db

class Exposicion(Model):
    IdExp =  IntegerField() 
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
    
    
class Libro_Exposicion(Model):
    idLibro=ForeignKeyField(Libro,related_name="libro")
    idExp=ForeignKeyField(Exposicion,related_name="exposicion")
    
    class Meta:
            database = db
   

db.connect()
db.create_tables([Autor,Libro,Exposicion,Autor_Exposicion,Libro_Exposicion])   