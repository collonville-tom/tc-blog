class IndexedObject:
    objectId = 0

    def __init__(self, name):
        IndexedObject.objectId += 1
        self.id = IndexedObject.objectId
        self.name = name

    def __getitem__(self, name):
        return self.__getattribute__(name)

    def __setitem__(self, name, valeur):
        return self.__setattr__(name, valeur)

    def __delitem__(self):
        return ","

    def toDict(self):
        obj_dict = {
            "__class__": self.__class__.__name__,
            "__module__": self.__module__
        }
        obj_dict.update(self.__dict__)
        return obj_dict


class Type(IndexedObject):

    def __init__(self, name):
        IndexedObject.__init__(self, name)
        self.instances = []

    def buildInstance(self, name):
        pass

    def toDict(self):
        obj_dict = IndexedObject.toDict(self)

        obj_dict.update({
            "instances": [object.toDict() for object in self.instances]
        })
        return obj_dict


class MetaModel(Type):

    def __init__(self, name):
        Type.__init__(self, name)
        self.entitiesType = []
        self.relationsType = []

    def buildInstance(self, name):
        system = Model(name, self)
        self.instances.append(system)
        return system

    def buildEntityType(self, name):
        entityType = EntityType(name)
        self.entitiesType.append(entityType)
        return entityType

    def buildRelationType(self, name, src, dst):
        relationType = RelationType(name, src, dst)
        self.relationsType.append(relationType)
        return relationType

    def toDict(self):
        obj_dict = Type.toDict(self)

        obj_dict.update({
            "entitiesType": [object.toDict() for object in self.entitiesType],
            "relationsType": [object.toDict() for object in self.relationsType]
        })
        return obj_dict


class EntityType(Type):

    def __init__(self, name):
        Type.__init__(self, name)
        self.propertiesType = []

    def buildPropertyType(self, name, valueType):
        propertyType = PropertyType(name, valueType)
        self.propertiesType.append(propertyType)
        return propertyType

    def buildInstance(self, name):
        newInstance = Entity(name, self)
        self.instances.append(newInstance)
        return newInstance

    def toDict(self):
        obj_dict = Type.toDict(self)

        obj_dict.update({
            "propertiesType": [object.toDict() for object in self.propertiesType]
        })
        return obj_dict


class PropertyType(Type):

    def __init__(self, name, valueType):
        Type.__init__(self, name)
        self.valueType = valueType

    def buildInstance(self, name, value):
        newInstance = Property(name, self, value)
        self.instances.append(newInstance)
        return newInstance

    def toDict(self):
        obj_dict = Type.toDict(self)

        obj_dict.update({
            "valueType": self.valueType
        })
        return obj_dict


class RelationType(Type):

    def __init__(self, name, srcEntityType, dstEntityType):
        Type.__init__(self, name)
        self.srcEntityType = srcEntityType
        self.dstEntityType = dstEntityType

    def buildInstance(self, name, srcEntityTypeName, src, dstEntityTypeName, dst):
        srcType = [object for object in self.srcEntityType if object.name == srcEntityTypeName][0]
        dstType = [object for object in self.dstEntityType if object.name == dstEntityTypeName][0]

        srcInstance = [object for object in srcType.instances if object.name == src][0]
        dstInstance = [object for object in dstType.instances if object.name == dst][0]

        relation = Relation(name, srcInstance, dstInstance, self)
        self.instances.append(relation)
        return relation

    def toDict(self):
        obj_dict = Type.toDict(self)

        obj_dict.update({
            "srcEntityType": [object.toDict() for object in self.srcEntityType],
            "dstEntityType": [object.toDict() for object in self.dstEntityType]
        })
        return obj_dict


class Instance(IndexedObject):

    def __init__(self, name, mm):
        IndexedObject.__init__(self, name)
        self.mm = mm

    def toDict(self):
        obj_dict = IndexedObject.toDict(self)

        obj_dict.update({
            "mm": self.mm.name
        })
        return obj_dict


class Model(Instance):

    def __init__(self, name, mm):
        Instance.__init__(self, name, mm)
        self.entities = []
        self.relations = []

    def toDict(self):
        obj_dict = Instance.toDict(self)

        obj_dict.update({
            "entities": [object.toDict() for object in self.entities],
            "relations": [object.toDict() for object in self.relations]
        })
        return obj_dict


class Entity(Instance):

    def __init__(self, name, mm):
        Instance.__init__(self, name, mm)
        self.properties = []

    def toDict(self):
        obj_dict = Instance.toDict(self)

        obj_dict.update({
            "properties": [object.toDict() for object in self.properties]
        })
        return obj_dict

class Property(Instance):

    def __init__(self, name, mm, value):
        Instance.__init__(self, name, mm)
        self.value = value

    def toDict(self):
        obj_dict = Instance.toDict(self)
        obj_dict.update({
            "value": self.value
        })
        return obj_dict


class Relation(Instance):

    def __init__(self, name, src, dst, mm):
        Instance.__init__(self, name, mm)
        self.src = src
        self.dst = dst

    def toDict(self):
        obj_dict = Instance.toDict(self)
        obj_dict.update({
            "src": self.src.toDict(),
            "dst": self.dst.toDict()
        })
        return obj_dict
