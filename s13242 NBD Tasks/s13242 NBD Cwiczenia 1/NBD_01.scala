import scala.collection.mutable.ListBuffer

object NBD_01 extends App {


  println("Ex. 1")

  val weekDays: List[String] = List("poniedzialek", "wtorek", "sroda", "czwartek", "piatek", "sobota", "niedziela")

  println("a)")

  var stringA = ""

  for( day <- weekDays) {
    stringA = stringA.concat(day + ", ")
  }

  stringA = stringA.dropRight(2)
  println(stringA)

  println("b)")
    var stringB = ""

    var filteredDays = weekDays.filter(s =>  s.substring(0, 1) == "p" )

  for( day <- filteredDays) {
    stringB = stringB.concat(day + ", ")
  }

  stringB = stringB.dropRight(2)
    println(stringB)

  println("c)")

    var stringC = ""
    var k = 0
    var listLength = weekDays.size

    while (k < listLength) {

      stringC = stringC.concat(weekDays(k) + ", ")

      k += 1
    }

  stringC = stringC.dropRight(2)
  println(stringC)


  println("Ex. 2")

  def func2(x: List[String]): String = {
    if (x.size > 0) {
      return x.head.concat(" ").concat(func2(x.tail))
    }
    else
      ""
  }

  println(func2(weekDays))

  def func2reverse(x: List[String]): String = {
    if (x.size > 0) {
      return func2reverse(x.tail).concat(" ").concat(x.head)
    }
    else
      ""
  }

  println(func2reverse(weekDays))


  println("Ex. 3")

  def func3(list: List[String]): String = {

    def tail(index: Int, result: String, myListParam: List[String]): String = {
      if (index < myListParam.length - 1) {
        return tail(index + 1, result.concat(myListParam(index)).concat(", "), myListParam)
      } else if (index == myListParam.length - 1) {
        return tail(index + 1, result.concat(myListParam(index)), myListParam)
      }
      result
    }

    tail(0, "", list)
  }

  println(func3(weekDays))

  println("Ex. 4")

  def func4a(args: List[String]): String = {
    var string: String = args.foldLeft("")(_ + _ + ",")
    string
  }

  def func4b(args: List[String]): String = {
    var string: String = args.foldRight("")(_ + "," + _)
    string
  }

  def func4c(args: List[String]): String = {

    var string: String = args.foldLeft("")(
      (a, b) => if (b.charAt(0) == "p") {
        a + b + ","
      }
      else a
    )
    string
  }

  println(func4a(weekDays))
  println(func4b(weekDays))
  println(func4c(weekDays))


  println("Ex. 5")

  val products: Map[String, Double] = Map("A" -> 125.4, "B" -> 123.12, "C" -> 53.1, "D" -> 12.5)

  def func5(args: Map[String, Double]): Map[String, Double] = {
    def func5aux(price: Double): Double = {
      price *  0.9
    }
    val discountedProducts: Map[String, Double] = args.map(element => (element._1, func5aux(element._2)))
    discountedProducts
  }

  println(func5(products))

  println("Ex. 6")

  def func6(params: (String, Int, Double)): Unit = {
    println(params._1)
    println(params._2)
    println(params._3)
  }

  func6(Tuple3("string", 123, 12.34))


  println("Ex. 7")

  println(products.get("A"))


  println("Ex. 8")

  val listWithZeros: List[Int] = List(0, 1, 5, 6, 9, 0, 9)

  def func8(args: List[Int]): List[Int] = {
    val listWithoutZero = ListBuffer[Int]()

    def func8aux(list: List[Int], index: Int, result: ListBuffer[Int]): List[Int] = {
      if (index == args.length) {
        result.toList
      }
      else {
        if (list(index) == 0) {
          func8aux(list, index + 1, result)
        }
        else {
          val something = list(index)
          result += something
          func8aux(list, index + 1, result)
        }
      }
    }

    func8aux(args, 0, listWithoutZero)
  }

  println(func8(listWithZeros))



  println("Ex. 9")

  def incrementByOne(list:List[Int] ): List[Int] = {

    var returnList: List[Int] = List(1)

    for( num <- list) {
      returnList ::= (num+1)
    }
    println(returnList)
    return returnList
  }

  var initList: List[Int] = List(1, -124, 534)


  println("Init list: " + initList)
  println("Result list: " + incrementByOne(initList))

  println("Ex. 10")
  val realNumbers: List[Double] = List(1.1, 4.3, 11.4, 15.6, 5.4, -4.5, -7.3)

  def func10(list:List[Double] ) : List[Int] = {

    val resultList: List[Int] = list map (_.toInt)
    list.filter(_ < 12.0)

    return resultList.filter( x=> (x < 12 && x > -5))
  }

  println(func10(realNumbers))

}
