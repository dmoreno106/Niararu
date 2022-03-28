# import main Flask class and request object
from crypt import methods
import controller
import json
from flask import Flask, request 

# create the Flask app
app = Flask(__name__)



@app.route('/mostrarDatos',methods=['GET','POST'])
def sacarDatos():
    tipo=request.args.get('tipo')
    datos=controller.mostrarDatos(tipo)
    json=json.JSONEncoder(datos)
    
    return json





if __name__ == '__main__':
    # run app in debug mode on port 5000
    app.run(debug=True, port=5002)
    