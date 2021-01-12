import scala.collection.mutable.ListBuffer

object NBD_02 extends App {

  println("Ex. 1")

  def func1(s: String): String = {
    s match {
      case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek" => "Praca"
      case "sobota" | "niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia."
    }
  }

  println(func1("poniedzialek"))
  println(func1("niedziela"))
  println(func1("NBD"))

  println("Ex. 2")

  class KontoBankowe(var stanKonta: Int) {

    def this() {
      this(0)
    }



    def wplata(x: Int) = {

      this.stanKonta += x

    }
    def wyplata(x: Int) = {
      this.stanKonta -= x
    }

  }

  val k1 = new KontoBankowe()
  val k2 = new KontoBankowe(100)
  println(k1.stanKonta)
  println(k2.stanKonta)
  k1.wplata(5)
  k2.wyplata(5)
  println(k1.stanKonta)
  println(k2.stanKonta)

  println("Ex. 3")

  case class OsobaEx3(var imie: String, var nazwisko: String) {


  }

  def func3(o: OsobaEx3): String = {
    o match {
      case OsobaEx3(_, "Kowalski")   => "Hello Kowalski"
      case OsobaEx3(_, "Nowak")   => "Hello Nowak"
      case OsobaEx3(_, "Smith") => "Hello Smith"
      case _               => "Hello"
    }
  }

  val o1 = new OsobaEx3("Jan", "Kowalski")
  val o2 = new OsobaEx3("Jan", "Nowak")
  val o3 = new OsobaEx3("Jan", "Smith")
  println(func3(o1))
  println(func3(o2))
  println(func3(o3))
  println(func3(new OsobaEx3("Jan", "Nobody")))

  println("Ex. 4")

  def func4(x: Int, f: (Int) => Int): Int = {
    f(f(f(x)))
  }

  println(func4(1, e => e + 1));

  println("Ex. 5")

  class Osoba(val imie: String, val nazwisko: String, val podatek: Int) {


    def getPodatek(): Int =
    {
      return podatek
    }


  }

  trait Student extends Osoba {
    override def getPodatek(): Int =
    {
      return 0
    }


  }

  trait Pracownik extends Osoba{
    var pensja: Int = _

    def setPensja(x: Int): Unit = {
      pensja  = x
    }

    def getPensja(): Int = {
      pensja
    }

    override def getPodatek(): Int =
    {
      (pensja * 0.2).toInt
    }

  }


  trait Nauczyciel extends Pracownik {
    override def getPodatek(): Int =
    {
      (pensja * 0.1).toInt
    }
  }


  val o51 = new Osoba("Jan", "Nowak", 100) with Student
  println(o51.getPodatek())

  val o52 = new Osoba("Jan", "Kowalski", 152) with Nauczyciel
  o52.setPensja(1500)
  println(o52.getPodatek())

  val o53 = new Osoba("Jan", "Smith", 2154) with Pracownik
  o53.setPensja(1500)
  println(o53.getPodatek())
  
}

