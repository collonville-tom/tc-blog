#!flask/bin/python

import json
from flask import Flask, jsonify
from python_http_client import Client

from response import str_http_response
from json_tk import dict_to_obj, convert_to_dict
from human import Moyenne

client = Client(host='http://rest-people:5001/humans')
app = Flask(__name__)


@app.route('/recall', methods=['GET'])
def get_recall():
    response = client.get()

    str_http_response(response)

    json_response = json.loads(response.body)
    humans = [dict_to_obj(human) for human in json_response]
    print("HUMANS" + str(humans))
    return jsonify([convert_to_dict(human) for human in humans])


@app.route('/moy', methods=['GET'])
def get_moy():
    response = client.get()
    str_http_response(response)

    json_response = json.loads(response.body)
    humans = [dict_to_obj(human) for human in json_response]
    print("HUMANS" + str(humans))

    moyenne = Moyenne([human.age for human in humans])
    print("MOYENNE:" + str(moyenne))
    return jsonify(moyenne.__dict__)


if __name__ == '__main__':
    app.run(debug=True, port=5002, host='0.0.0.0')
