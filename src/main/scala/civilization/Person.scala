package civilization

class Person(name: String, centuryOfLife: Int) extends App {
  def hello =
    s"Hi. I'm $name from the $centuryOfLife${Person.ordinalAbbrev(centuryOfLife)}"
}

object Person {
  def apply(name: String, centuryOfLife: Int) = new Person(name, centuryOfLife)
  def ordinalAbbrev(n: Int) = {
    val ans = "th" //most of the time it should be "th"
    if (n % 100 / 10 == 1) ans //teens are all "th"
    else
      (n % 10) match {
        case 1 => "st"
        case 2 => "nd"
        case 3 => "rd"
        case _ => ans
      }
  }
}
