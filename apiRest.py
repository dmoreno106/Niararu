# import main Flask class and request object
from crypt import methods
import mimetypes
import controller
import json
from flask import *

# create the Flask app
app = Flask(__name__)


#Ruta que realiza una consulta y muestra todos los datos
#de un tipo en formato JSON

@app.route('/mostrarDatos',methods=['GET'])
def sacarDatos():
    tipo=request.args.get('tipo')
    datos=controller.mostrarDatos(tipo)
    datos1=json.JSONEncoder().encode(datos) 
    
    return Response(datos1,mimetype='application/json')

#Ruta que realiza la consulta y muestra los datos
#del tipo escogido filtrando por el nombre en el caso de autor y exposicion
#y título en el caso de libro

@app.route('/buscarRegistro',methods=['POST'])
def buscarRegistro():
    tipo=request.form.get('tipo')
    nombre=request.form.get('nombre')
    datos=controller.mostrarRegistro(tipo,nombre)
    datos1=json.JSONEncoder().encode(datos) 
    
    return Response(datos1,mimetype='application/json')



#Ruta que realiza la consulta y borra un registro
#del tipo que se haya seleccionado por su id

@app.route('/borrarRegistro',methods=['GET'])
def borrarRegistro():
    tipo=request.args.get('tipo')
    id=request.args.get('id')
    controller.borrarRegistros(id,tipo)
    if controller.comprobarExistencia(tipo,id)==0 :
        return "Borrado con éxito"
    else:
        return "Error de borrado"

#Ruta que realiza la consulta y edita un registro

@app.route('/editarRegistro',methods=['GET','POST'])
def editarRegistro():
    
     if request.method == 'POST':
        tipo=request.args.get('tipo')
        if(tipo=="autor"):
             
         
            id=request.args.get('id')
            fechaNac = request.form.get('fNac')
            nombre = request.form.get('nombre')
            sinopsis = request.form.get('sinopsis')
        
            datosArray={
                    "id":id,
                    "fecha_nac":fechaNac,
                    "nombre":nombre,
                    "sinopsis":sinopsis
                    }
        elif(tipo=="libro"):
            IdLibro = request.args.get('id')
            Titulo = request.form.get('titulo')
            FechaPublicacion = request.form.get('fecha_publicacion')
            Lenguaje = request.form.get('lenguaje')
            
            datosArray={
                    "isbn":IdLibro,
                    "titulo":Titulo,
                    "fecha_publicacion":FechaPublicacion,
                    "lenguaje":Lenguaje
                    }
        else:
            IdExp = request.args.get('id')
            Descripcion=request.form.get('descripcion')
            Fecha=request.form.get('fecha')
            nombreExp=request.form.get('nombre')
            direccion=request.form.get('direccion')
            codigoPostal=request.form.get('cp')
            municipio=request.form.get('municipio')
            
            datosArray={
                    "id":IdExp,
                    "descripcion":Descripcion,
                    "fecha":Fecha,
                    "nombre":nombreExp,
                    "direccion":direccion,
                    "cp":codigoPostal,
                    "municipio":municipio
                    }
                
        controller.actualizaRegistro(datosArray,tipo)

        # otherwise handle the GET request
     return '''
                Editado con exito
            '''

#Ruta que realiza la consulta e inserta un registro
@app.route('/insertarRegistro',methods=['GET','POST'])
def insertaRegistro():
    tipo=request.args.get('tipo')
    if request.method == 'POST':
        
        if(tipo=="autor"):
             
         
            
            fechaNac = request.form.get('fNac')
            nombre = request.form.get('nombre')
            sinopsis = request.form.get('sinopsis')
        
            datosArray={
                    "fecha_nac":fechaNac,
                    "nombre":nombre,
                    "sinopsis":sinopsis
                    }
        elif(tipo=="libro"):
            IdLibro = request.args.get('id')
            Titulo = request.form.get('titulo')
            FechaPublicacion = request.form.get('fecha_publicacion')
            Lenguaje = request.form.get('lenguaje')
            
            datosArray={
                    "isbn":IdLibro,
                    "titulo":Titulo,
                    "fecha_publicacion":FechaPublicacion,
                    "lenguaje":Lenguaje
                    }
        else:
            IdExp = request.form.get('id')
            Descripcion=request.form.get('descripcion')
            Fecha=request.form.get('fecha')
            nombreExp=request.form.get('nombre')
            direccion=request.form.get('direccion')
            codigoPostal=request.form.get('cp')
            municipio=request.form.get('municipio')
            
            datosArray={
                    "id":IdExp,
                    "descripcion":Descripcion,
                    "fecha":Fecha,
                    "nombre":nombreExp,
                    "direccion":direccion,
                    "cp":codigoPostal,
                    "municipio":municipio
                    }

        if (tipo=="autor") :
        
            controller.insertarRegistro(datosArray,tipo)
        else:
            if controller.comprobarExistencia(tipo,datosArray['id'])==0:
                controller.insertarRegistro(datosArray,tipo)

    return '''
                Insertado con exito
            '''
    
@app.route('/insertarExposicionOrganizada',methods=['GET','POST'])
def insertarRelacion():

        idAutor=request.form.get('idAutor')
        idExpo=request.form.get('IdExpo')
        idLibro=request.form.get('idLibro')

        datosArray={
                "idLibro":idLibro,
                "idAutor":idAutor,
                "idExpo":idExpo                   
        }
        
        controller.insertarRelacion(datosArray)
        return "datos añadidos"

@app.route('/organizar',methods=['GET','POST'])
def organizar():
    nuevasOrganizaciones=controller.nuevasOrganizaciones()
    
        
    datosJson=json.JSONEncoder().encode(nuevasOrganizaciones)
     
    return datosJson

if __name__ == '__main__':
    # run app in debug mode on port 5001
    app.run(debug=True, port=5001)
    