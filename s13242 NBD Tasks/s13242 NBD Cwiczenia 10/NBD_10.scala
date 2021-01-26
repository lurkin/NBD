object NBD_10 {
  def test: Iterator[(Int, Int)] = for {
    i <- Iterator.from(1)
    divisor <- 1 until i + 1 if i % divisor == 0
  } yield (i, divisor)

  def main(args: Array[String]): Unit = {
    println((test take 20).toList)


    val x = test.buffered

    val l2 = List(
      x.next(),
      x.next(),
      x.next(),
      x.next()
    )

    println(l2)

    var l3 = List[(Int, Int)]()
    val x3 = test.buffered

    for ( i <- 0 until 20) {
      l3 = l3 ::: List(x3.next())
    }

    println(l3)
  }
}


