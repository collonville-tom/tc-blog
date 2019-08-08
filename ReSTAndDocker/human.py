class Human:

    def __init__(self, id, name, age):
        self.id = id
        self.name = name
        self.age = age

    def __getitem__(self, name):
        return self.__getattribute__(name)

    def __setitem__(self, name, valeur):
        return self.__setattr__(name, valeur)

    def __delitem__(self):
        return ","


class Men(Human):

    def __init__(self, id, name, age):
        Human.__init__(self, id, name, age)


class Women(Human):

    def __init__(self, id, name, age):
        Human.__init__(self, id, name, age)

import functools

class Moyenne:

    def __init__(self, humanAges):
        self.moyenne = (functools.reduce(lambda x, y: x + y, humanAges)) / len(humanAges)

