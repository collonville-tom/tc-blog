#!flask/bin/python
from flask import Flask, jsonify, request
import json

from json_tk import convert_to_dict, dict_to_obj
from human import Men, Women

people = [
    Men(1, "Bob", 12),
    Women(2, "Alice", 10)
]

app = Flask(__name__)


@app.route('/humans', methods=['GET'])
def get_humans():
    return jsonify([convert_to_dict(human) for human in people])


@app.route('/humans/<int:human_id>', methods=['GET'])
def get_human(human_id):
    return jsonify([convert_to_dict(human) for human in people if human.id == human_id][0])


@app.route('/humans', methods=['POST'])
def post_human():
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    human = dict_to_obj(json_response)
    human.id = len(people)+1
    people.append(human)
    return jsonify(human.id)


def main():
    app.run(debug=True, port=5001, host='0.0.0.0')

if __name__ == '__main__':
    main()
