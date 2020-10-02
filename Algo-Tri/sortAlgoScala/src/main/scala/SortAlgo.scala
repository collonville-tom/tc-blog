
import scala.collection.mutable.ArrayBuffer
import scala.math._


object sortAlgo {

  def main(array: Array[String]): Unit = {
    val maListe = buildNewArray(25)
    println(maListe)
    this.bulle(maListe)
    println(maListe)
  }
  //this.bourrin(maListe)
  //this.selection(maListe)
  //this.bulle(maListe)
  //this.insertion(maListe)
  //val newList = this.quickSort(maListe)

  def buildNewArray(size: Int = 10, space: Int = 100): ArrayBuffer[Int] = {
    val array = new ArrayBuffer[Int]()
    for (i <- 0 to size) array.+=(random().*(space).toInt)
    array
  }

  def permutation(list: ArrayBuffer[Int], first: Int, second: Int): Unit = {
    val tmp = list(first)
    list.update(first, list.apply(second))
    list.update(second, tmp)
  }

  def secondIsMinus(list: ArrayBuffer[Int], first: Int, second: Int): Boolean = {
    list(first) > list(second)
  }

  def bourrin(list: ArrayBuffer[Int]): Unit = {
    for (i <- 0 to list.size - 1; i <- 0 to list.size - 1)
      if (i < list.size - 1) if (secondIsMinus(list, i, i + 1)) this.permutation(list, i, i + 1)
  }

  def selection(list: ArrayBuffer[Int]): Unit = {
    for (i <- 0 to list.size - 1) {
      var min = i
      for (y <- i to list.size - 1)
        if (secondIsMinus(list, min, y)) min = y
      this.permutation(list, i, min)
    }
  }

  def bulle(list: ArrayBuffer[Int]): Unit = {
    for (i <- 0 to list.size - 1; j <- 0 to list.size - i)
      if (j < list.size - 1) if (secondIsMinus(list, j, j + 1)) this.permutation(list, j, j + 1)
  }

  def insertion(list: ArrayBuffer[Int]): Unit = {
    for (i <- 0 to list.size - 1; j <- 0 to i - 1)
      if (secondIsMinus(list, i - j - 1, i - j)) this.permutation(list, i - j - 1, i - j)
  }

  def quickSort(list: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    if (list.isEmpty)
      new ArrayBuffer[Int]()
    else {
      val pivot = list.last
      val minus = list.filter(_ < pivot)
      val magnus = list.filter(_ > pivot)
      quickSort(minus).addOne(pivot).addAll(quickSort(magnus))
    }
  }


}
