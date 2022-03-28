from email import charset
from lib2to3.pytree import Base
from peewee import *

db = SqliteDatabase("Base de Datos", pragmas={'foreign_keys': 1})

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
    
    def __dict__(self):
        return {
            "id": self.Id,
            "FechaNac": self.FechaNac,
            "Nombre" : self.Nombre,
            "Sinopsis" : self.Sinopsis
        }
    
    class Meta:
            database = db
            
    
    
class Libro(Model):
    IdLibro = CharField(primary_key=True)
    Titulo = CharField()
    FechaPublicacion = CharField() 
    Lenguaje = CharField()
    
    def __dict__(self):
        return {
            "id": self.IdLibro,
            "Titulo": self.Titulo,
            "FechaPublicacion" : self.FechaPublicacion,
            "Lenguaje" : self.Lenguaje
        }
    
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
    
    def __dict__(self):
        return {
            "Id": self.IdExp,
            "Descripcion": self.Descripcion,
            "Fecha" : self.Fecha,
            "Nombre" : self.nombre,
            "Direccion": self.direccion,
            "Descripcion": self.Descripcion,
            "Municipio" : self.municipio
        }
    
    class Meta:
            database = db
    
class Autor_Exposicion(Model):
    idAutor=CharField()
    idExp=CharField()
    
    class Meta:
            database = db 
            constraints=[SQL('FOREIGN KEY(idAutor) REFERENCES Autor(Id) ON DELETE CASCADE'),SQL('FOREIGN KEY(idExp) REFERENCES Exposicion(IdExp) ON DELETE CASCADE')]
            primary_key=CompositeKey('idAutor','idExp')         
            recursive=True
    
    
class Libro_Exposicion(Model):
    idLibro=CharField()
    idExp=CharField()
    
    class Meta:
            database = db
            constraints=[SQL('FOREIGN KEY(idLibro) REFERENCES Libro(IdLibro) ON DELETE CASCADE'),SQL('FOREIGN KEY(idExp) REFERENCES Exposicion(IdExp) ON DELETE CASCADE')]
            primary_key=CompositeKey('idLibro','idExp')
            
            
     
   

db.connect()
db.create_tables([Autor,Libro,Exposicion,Autor_Exposicion,Libro_Exposicion])
