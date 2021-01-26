object NBD_9 {
  class Container[A](private val content: A) {
    def getContent: A = content
    def applyFunction[R] (map: A => R): R = map(content)
  }

  trait Maybe[+A] {
    def map[R] (map: A => R): Maybe[R]
    def getOrElse[R >: A](otherwise: R): R
    def flatMap[R](mapper: A => Maybe[R]): Maybe[R]
  }

  def MaybeOf[A](a: A): Maybe[A] = if (a == null) No() else Yes(a)

  case class Yes[A](private val content: A) extends Maybe[A] {
    override def map[R](map: A => R): Maybe[R] = {
      val r = map(content)
      if (r != null) Yes(r) else No()
    }
    override def getOrElse[R >: A](otherwise: R): R = content
    override def flatMap[R](mapper: A => Maybe[R]): Maybe[R] = mapper(content)
  }

  case class No() extends Maybe[Nothing] {
    override def map[R](map: Nothing => R): Maybe[R] = No()
    override def getOrElse[R](otherwise: R): R = otherwise
    override def flatMap[R](mapper: Nothing => Maybe[R]): Maybe[R] = No()
  }


  def main(args: Array[String]): Unit = {
    val no = No()
    val yes = Yes("yes")

    println("no is instance of Maybe", no.isInstanceOf[Maybe[_]])
    println("yes is instance of Maybe", yes.isInstanceOf[Maybe[_]])

    val a = MaybeOf("Something")
    val n = MaybeOf("test").map(_ => null)

    def simpleTest[A](test: A): Unit = test match {
      case Yes(a) => println("Yeees", a)
      case No() => println("No")
    }

    def simpleTest2(test: Maybe[Int]): Unit = test
      .map(a => a + 1)
      .flatMap(a => MaybeOf(println(a)))


    simpleTest(a)
    simpleTest(n)
    println(simpleTest2(MaybeOf(10)))
  }
}
