package civilization.instances

import cats.instances.string._
import cats.syntax.semigroup._
import civilization._

object WesternCivilization extends Civilization(Culture()) {
  println("Hello " |+| "Western Civilization!")

  timeline + (fmt.parse("01/01/400") -> Born())

  core = List(
    Area("northern half of Italy"),
    Area("France"),
    Area("the extreme western part of Germany"),
    Area("England")
  )
  semiPeripheral = List(
    Area("central Europe"),
    Area("eastern Europe"),
    Area("southern Europe"),
    Area("Iberian peninsula")
  )
  peripheral = List(
    Area("North America"),
    Area("South America"),
    Area("Austrailia"),
    Area("New Zealand"),
    Area("South Africa")
  )

  override val questions: List[String] = List(
    "Where are we going?",
    "Can man survive?",
    "Can our way of life survive?",
    "Is our civilization doomed to vanish?"
  )
  override val people: List[Person] = List(
    Person("Geivanni Batista Vico", 18),
    Person("Oswald Spengler", 20),
    Person("Arnold J. Toynbee", 20)
  )

  override val periodOfLife: PeriodOfLife = DeathCrisis()
}
