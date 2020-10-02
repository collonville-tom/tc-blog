#!/bin/python

import time
from random import randrange
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

LIST_SIZE = 10

def main():
    testAll()
    # plot()


def plot():
    dataFrame=pd.read_pickle("python-sort.txt")
    print(dataFrame)

    resultDic={}
    for key in [ x for x in dataFrame.keys() if x != 'Unnamed: 0' ] :
        tmp=[]
        for serkey in [ x for x in dataFrame[key].keys() ] :
            tmp.append(np.mean(dataFrame[key][serkey]))
            serie=pd.Series(tmp)
            resultDic[key]=serie


    data=pd.DataFrame(resultDic)

    data.plot(figsize=(10,10))
    plt.show()



def testAll():
    func=[system_sort,quick_sort]
    # func=[bourrin,system_sort,selection,insertion,bulle,quick_sort]
    resulSet= {}
    for f in func:
        test_Sort(resulSet,f)
    dataFrame=pd.DataFrame(resulSet)
    dataFrame.to_pickle("python-sort.txt")




def test_Sort(resulSet,func):
    resulSet[func.__name__]={}
    for (index, size) in enumerate(np.logspace(start=1, stop=6, dtype=np.int64)):
        resulSet[func.__name__][size]=[]
        for serie in range(1, 40):
            print("{}:Echantillon {},{} serie {}".format(func.__name__,index,size,serie))
            ma_liste = buildNewlist(size, (2+6)^10)
            datestart = time.time()
            func(ma_liste)
            dateend = time.time()
            resulSet[func.__name__][size].append(dateend - datestart)

def system_sort(liste):
    liste.sort()

def buildNewlist(size, rang):
    l = [randrange(rang) for x in range(size)]
    return l


def permutation(liste, first, second):
    var_first = liste[first]
    liste[first] = liste[second]
    liste[second] = var_first


def second_is_minus(liste, first, second):
    if liste[first] > liste[second]:
        return True
    return False


def bourrin(ma_liste):
    for i in range(len(ma_liste)):
        for i in range(len(ma_liste)):
            if i < len(ma_liste) - 1:
                if second_is_minus(ma_liste, i, i + 1):
                    permutation(ma_liste, i, i + 1)
    return ma_liste


def selection(ma_liste):
    for i in range(len(ma_liste)):
        min = i
        for y in range(i, len(ma_liste)):
            if second_is_minus(ma_liste, min, y):
                min = y
        permutation(ma_liste, i, min)
    return ma_liste


def bulle(ma_liste):
    for i in range(len(ma_liste)):
        for j in range(len(ma_liste) - i):
            if j < len(ma_liste) - 1:
                if second_is_minus(ma_liste, j, j + 1):
                    permutation(ma_liste, j, j + 1)
    return ma_liste


def insertion(ma_liste):
    for i in range(len(ma_liste)):
        for y in range(i):
            if second_is_minus(ma_liste, i - y - 1, i - y):
                permutation(ma_liste, i - y - 1, i - y)
    return ma_liste


def quick_sort(l):
    if not l:
        return []
    else:
        axeIndex = randrange(len(l))
        axe = l[axeIndex]
        minus = [x for x in l if x < axe]
        magnus = [x for x in l if x > axe]
        return quick_sort(minus) + [axe] + quick_sort(magnus)


main()
