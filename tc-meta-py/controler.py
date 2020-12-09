#!flask/bin/python
import json

from flask import Flask, jsonify, request
from flask_cors import CORS

from meta_fmk import MetaModel

app = Flask(__name__)
CORS(app)

root = [

]


################################################################################## M2
@app.route('/m2', methods=['GET'])  # OK
def get_m2():
    return jsonify([m2.toDict() for m2 in root])


@app.route('/m2/<string:m2Name>', methods=['GET'])  # OK
def get_m2_by_name(m2Name):
    return jsonify([m2.toDict() for m2 in root if m2.name == m2Name][0])


@app.route('/m2', methods=['POST'])  # OK
def post_m2_by_name():
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    meta = MetaModel(json_response["name"])
    root.append(meta)
    return jsonify(meta.id)


################################################################################## M2 PropertyType

@app.route('/m2/<string:m2Name>/entityType/<string:entityTypeName>/propertyType', methods=['GET'])  # OK
def get_propertyTypes(m2Name, entityTypeName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    entityType = [entityType for entityType in m2.entitiesType if entityType.name == entityTypeName][0]
    return jsonify([propertyType.toDict() for propertyType in entityType.propertiesType])


@app.route('/m2/<string:m2Name>/entityType/<string:entityTypeName>/propertyType', methods=['POST'])  # OK
def post_propertyTypes(m2Name, entityTypeName):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    entityType = [entityType for entityType in m2.entitiesType if entityType.name == entityTypeName][0]
    propertyType = entityType.buildPropertyType(json_response["name"], json_response["valueType"])
    return jsonify(propertyType.id)


################################################################################## M2 EntityType
@app.route('/m2/<string:m2Name>/entityType', methods=['GET'])  # OK
def get_entityType(m2Name):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    return jsonify([entityType.toDict() for entityType in m2.entitiesType])


@app.route('/m2/<string:m2Name>/entityType/<string:entityTypeName>', methods=['GET'])  # OK
def get_entityType_with_name(m2Name, entityTypeName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    return jsonify([entityType.toDict() for entityType in m2.entitiesType if entityType.name == entityTypeName][0])


@app.route('/m2/<string:m2Name>/entityType/<string:entityTypeName>/entity', methods=['GET'])  # OK
def get_entityType_instances_with_name(m2Name, entityTypeName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    entityType = [entityType for entityType in m2.entitiesType if entityType.name == entityTypeName][0]
    return jsonify([entity.toDict() for entity in entityType.instances])


@app.route('/m2/<string:m2Name>/entityType/<string:entityTypeName>/entity/<string:entityName>', methods=['GET'])  # OK
def get_entityType_instance_with_name(m2Name, entityTypeName, entityName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    entityType = [entityType for entityType in m2.entitiesType if entityType.name == entityTypeName][0]
    return jsonify([entity.toDict() for entity in entityType.instances if entity.name == entityName][0])


@app.route('/m2/<string:m2Name>/entityType', methods=['POST'])  # OK
def post_entityType_with_name(m2Name):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    meta = m2.buildEntityType(json_response["name"])
    return jsonify(meta.id)


################################################################################## M2 RelationType
@app.route('/m2/<string:m2Name>/relationType', methods=['GET'])  # OK
def get_relationType(m2Name):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    return jsonify([relationType.toDict() for relationType in m2.relationsType])


@app.route('/m2/<string:m2Name>/relationType/<string:relationTypeName>', methods=['GET'])  # OK
def get_relationType_with_name(m2Name, relationTypeName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    return jsonify(
        [relationType.toDict() for relationType in m2.relationsType if relationType.name == relationTypeName][0])


@app.route('/m2/<string:m2Name>/relationType/<string:relationTypeName>/relation', methods=['GET'])  # OK
def get_relationType_instances_with_name(m2Name, relationTypeName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    relationType = [relationType for relationType in m2.relationsType if relationType.name == relationTypeName][0]
    return jsonify([relation.toDict() for relation in relationType.instances])


@app.route('/m2/<string:m2Name>/relationType/<string:relationTypeName>/relation/<string:relationName>',
           methods=['GET'])  # OK
def get_relationType_instance_with_name(m2Name, relationTypeName, relationName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    relationType = [relationType for relationType in m2.relationsType if relationType.name == relationTypeName][0]
    return jsonify(
        [relation.toDict() for relation in relationType.instances if relation.name == relationName][0])


@app.route('/m2/<string:m2Name>/relationType', methods=['POST'])  # OK
def post_relationType_with_name(m2Name):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    srcEntityType = [srcEntityType for srcEntityType in m2.entitiesType if
                     srcEntityType.name in json_response["srcEntityType"]]
    dstEntityType = [dstEntityType for dstEntityType in m2.entitiesType if
                     dstEntityType.name in json_response["dstEntityType"]]

    meta = m2.buildRelationType(json_response["name"], srcEntityType, dstEntityType)
    return jsonify(meta.id)


################################################################################## M


@app.route('/m2/<string:m2Name>/m', methods=['GET'])  # OK
def get_m2_instance(m2Name):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    return jsonify([model.toDict() for model in m2.instances])


@app.route('/m2/<string:m2Name>/m/<string:mName>', methods=['GET'])  # OK
def get_m2_instance_with_name(m2Name, mName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    return jsonify(model.toDict())


@app.route('/m2/<string:m2Name>/m', methods=['POST'])  # OK
def post_m_instance_with_name(m2Name):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = m2.buildInstance(json_response["name"])
    return jsonify(model.id)


################################################################################## M Entity


@app.route('/m2/<string:m2Name>/m/<string:mName>/entity', methods=['GET'])  # OK
def get_entities(m2Name, mName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    return jsonify([entity.toDict() for entity in model.entities])


@app.route('/m2/<string:m2Name>/m/<string:mName>/entity/<string:entityName>', methods=['GET'])  # OK
def get_entity_with_name(m2Name, mName, entityName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    entity = [entity for entity in model.entities if entity.name == entityName][0]
    return jsonify(entity.toDict())


@app.route('/m2/<string:m2Name>/m/<string:mName>/entityType/<string:entityTypeName>/entity', methods=['POST'])  # OK
def post_entity_with_name(m2Name, mName, entityTypeName):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    entityType = [entityType for entityType in m2.entitiesType if entityType.name == entityTypeName][0]
    entity = entityType.buildInstance(json_response["name"])
    model.entities.append(entity)
    return jsonify(entity.id)


################################################################################## M Property


@app.route('/m2/<string:m2Name>/m/<string:mName>/entity/<string:entityName>/property', methods=['GET'])  # OK
def get_properties(m2Name, mName, entityName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    entity = [entity for entity in model.entities if entity.name == entityName][0]
    return jsonify([property.toDict() for property in entity.properties])


@app.route(
    '/m2/<string:m2Name>/m/<string:mName>/entity/<string:entityName>/propertyType/<string:propertyTypeName>/property',
    methods=['POST'])  # OK
def post_property(m2Name, mName, entityName, propertyTypeName):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    entity = [entity for entity in model.entities if entity.name == entityName][0]
    propertyType = [propertyType for propertyType in entity.mm.propertiesType if propertyType.name == propertyTypeName][0]
    property = propertyType.buildInstance(json_response["name"], json_response["value"])
    entity.properties.append(property)
    return jsonify(property.id)


################################################################################## M Relation


@app.route('/m2/<string:m2Name>/m/<string:mName>/relation', methods=['GET'])  # OK
def get_relations(m2Name, mName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    return jsonify([relation.toDict() for relation in model.relations])


@app.route('/m2/<string:m2Name>/m/<string:mName>/relation/<string:relationName>', methods=['GET'])  # OK
def get_relation_with_name(m2Name, mName, relationName):
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    relation = [relation for relation in model.relations if relation.name == relationName][0]
    return jsonify(relation.toDict())


@app.route('/m2/<string:m2Name>/m/<string:mName>/relationType/<string:relationTypeName>/relation',
           methods=['POST'])  # OK
def post_relation_with_name(m2Name, mName, relationTypeName):
    print("REQUEST:" + str(request.data))
    json_response = json.loads(request.data)
    m2 = [m2 for m2 in root if m2.name == m2Name][0]
    model = [model for model in m2.instances if model.name == mName][0]
    relationType = [relationType for relationType in m2.relationsType if relationType.name == relationTypeName][0]
    relation = relationType.buildInstance(json_response["name"], json_response["srcType"], json_response["src"],
                                          json_response["dstType"], json_response["dst"])
    model.relations.append(relation)
    return jsonify(relation.id)


def main():
    app.run(debug=True, port=5001, host='0.0.0.0')


if __name__ == '__main__':
    main()
