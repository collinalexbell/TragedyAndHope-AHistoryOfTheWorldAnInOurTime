package civilization.instances

import cats.instances.string._
import cats.syntax.semigroup._
import civilization._

object WesternCivilization extends Civilization(Culture()) {
  println("Hello " |+| "Western Civilization!")

  core = List(Area("Europe"))
  peripheral = List(Area("America"), Area("Austrailia"))

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
