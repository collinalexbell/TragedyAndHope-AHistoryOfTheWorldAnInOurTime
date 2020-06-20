package civilization

import timeline.Timeline

import cats.instances.string._
import cats.syntax.semigroup._

case class Area(name: String)
case class Culture()

abstract class Civilization(
    culture: Culture
) {
  var core: List[Area] = List()
  var peripheral: List[Area] = List()
  var semiPeripheral: List[Area] = List()
  val questions: List[String] = List()
  val people: List[Person] = List()
  val periodOfLife: PeriodOfLife = Born()
  val timeline: Timeline = Map()

  def describe() = {
    describeCore()
    describePeriphery()
    describeCulture()
  }

  def describeCulture() = { println(s"The culture: $culture") }

  def describeCore() = println(
    "The core is " |+| core
      .map(_.name)
      .reduce((a, b) => a |+| ", " |+| b)
  )

  def describePeriphery() =
    println(
      "The periphrial is " |+| peripheral
        .map(_.name)
        .reduce((a, b) => a |+| ", " |+| b)
    )

}

object Civilization {
  val metaQuestions: List[String] = List(
    "Do civilizaitons have a life cycle?"
  )
}
