#!/bin/bash

BASE_URL="http://localhost:5001"

addElement()
{
  curl --request POST "$BASE_URL/$1" -H "Content-Type: application/json" -H "Accept: application/json" -d "$2"
}

addElement m2 '{ "name" : "MyMM" }'
addElement m2/MyMM/entityType '{ "name" : "MyEntityType1" }'
addElement m2/MyMM/entityType '{ "name" : "MyEntityType2" }'
addElement m2/MyMM/entityType '{ "name" : "MyEntityType3" }'

addElement m2/MyMM/entityType/MyEntityType1/propertyType '{ "name" : "MyPropertyType1", "valueType" : "Integer" }'
#
addElement m2/MyMM/relationType '{ "name" : "MyrelationType1", "srcEntityType": [ "MyEntityType1", "MyEntityType3" ], "dstEntityType" : [ "MyEntityType2" ] }'
addElement m2/MyMM/relationType '{ "name" : "MyrelationType2" ,"srcEntityType": [ "MyEntityType2" ], "dstEntityType" : [ "MyEntityType1" ] }'
#
#
addElement m2/MyMM/m '{ "name" : "MyModel" }'
#
addElement m2/MyMM/m/MyModel/entityType/MyEntityType1/entity '{ "name" : "MyEntity1" }'
addElement m2/MyMM/m/MyModel/entityType/MyEntityType2/entity '{ "name" : "MyEntity2" }'
addElement m2/MyMM/m/MyModel/entityType/MyEntityType3/entity '{ "name" : "MyEntity3" }'
addElement m2/MyMM/m/MyModel/entityType/MyEntityType1/entity '{ "name" : "MyEntity4" }'
addElement m2/MyMM/m/MyModel/entityType/MyEntityType2/entity '{ "name" : "MyEntity5" }'
#

addElement m2/MyMM/m/MyModel/entity/MyEntity1/propertyType/MyPropertyType1/property '{ "name" : "MyProperty1", "value" : "1" }'
#
#
addElement m2/MyMM/m/MyModel/relationType/MyrelationType1/relation '{ "name" : "MyRelation1", "src": "MyEntity1", "srcType": "MyEntityType1", "dst" : "MyEntity2", "dstType" : "MyEntityType2"}'
addElement m2/MyMM/m/MyModel/relationType/MyrelationType1/relation '{ "name" : "MyRelation2", "src": "MyEntity3", "srcType": "MyEntityType3", "dst" : "MyEntity5", "dstType" : "MyEntityType2"}'
addElement m2/MyMM/m/MyModel/relationType/MyrelationType2/relation '{ "name" : "MyRelation3", "src": "MyEntity5", "srcType": "MyEntityType2", "dst" : "MyEntity4", "dstType" : "MyEntityType1"}'
addElement m2/MyMM/m/MyModel/relationType/MyrelationType1/relation '{ "name" : "MyRelation4", "src": "MyEntity3", "srcType": "MyEntityType3", "dst" : "MyEntity2", "dstType" : "MyEntityType2"}'