# import main Flask class and request object
from crypt import methods
import mimetypes
import controller
import json
from flask import *

# create the Flask app
app = Flask(__name__)



@app.route('/mostrarDatos',methods=['GET','POST'])
def sacarDatos():
    tipo=request.args.get('tipo')
    datos=controller.mostrarDatos(tipo)
    datos1=json.JSONEncoder().encode(datos) 
    
    return Response(datos1,mimetype='application/json')

@app.route('/buscarRegistro',methods=['POST'])
def buscarRegistro():
    tipo=request.form.get('tipo')
    nombre=request.form.get('nombre')
    datos=controller.buscarRegistro(tipo,nombre)
    datos1=json.JSONEncoder().encode(datos) 
    
    return Response(datos1,mimetype='application/json')




@app.route('/borrarRegistro',methods=['GET','POST'])
def borrarRegistro():
    tipo=request.args.get('tipo')
    id=request.args.get('id')
    controller.borrarRegistros(id,tipo)
    if controller.comprobarExistencia()==0 :
        return "Borrado con éxito"
    else:
        return "Error de borrado"


@app.route('/editarRegistro',methods=['GET','POST'])
def editarRegistro():
    
     
    # controller.actualizaRegistro(id,tipo)
    # return "Editado con éxito"
    
     if request.method == 'POST':
        id=request.args.get('id')
        tipo=request.args.get('tipo')
        fechaNac = request.form.get('fNac')
        nombre = request.form.get('nombre')
        sinopsis = request.form.get('sinopsis')
        
        datosArray={
                    "id":id,
                    "fecha_nac":fechaNac,
                    "nombre":nombre,
                    "sinopsis":sinopsis
                    }
        controller.actualizaRegistro(datosArray,tipo)

        # otherwise handle the GET request
     return '''
            <form method="POST">
                <div><label>fecha: <input type="date" name="fNac"></label></div>
                <div><label>nombre: <input type="text" name="nombre"></label></div>
                <div><label>sinopsis: <input type="text" name="sinopsis"></label></div>
                
                <input type="submit" value="Submit">
            </form>'''


@app.route('/insertaRegistro',methods=['POST'])
def insertaRegistro():
    tipo=request.args.get('tipo')
    datos=request.args.get('datos')
    controller.insertarRegistro(datos,tipo)
    if controller.comprobarExistencia(datos['id'])==0 :
        return "Insertado con éxito"
    else:
        return "Error de inserción"

if __name__ == '__main__':
    # run app in debug mode on port 5000
    app.run(debug=True, port=5001)
    