package civilization

import timeline.Timeline

import cats.instances.string._
import cats.syntax.semigroup._

trait Growable {
  def growth: Double
}

case class Area(name: String, growth: Double = Double.PositiveInfinity)
    extends PeriodableWithGrowable {}
case class Culture()

abstract class Civilization(
    name: String,
    culture: Culture
) extends Periodable {
  var core: List[Area] = List()
  var peripheral: List[Area] = List()
  var semiPeripheral: List[Area] = List()
  val questions: List[String] = List()
  val people: List[Person] = List()
  val periodOfLife: PeriodOfLife = Born()
  val timeline: Timeline = Map()

  def describe() = {
    println("---------------------------------------------------")
    println(s"The $name civilization")
    describeCore()
    describePeriphery()
    describeSemiPeripheral()
    describeCulture()
    println("---------------------------------------------------")
  }

  def describeCulture() = { println(s"The culture: $culture") }

  def describeCore() = println(
    "The core is " |+| core
      .map(_.name)
      .reduce((a, b) => a |+| ", " |+| b)
  )

  def describeSemiPeripheral() =
    if (!semiPeripheral.isEmpty)
      println(
        "The semiPeripheral is " |+| semiPeripheral
          .map(_.name)
          .reduce((a, b) => a |+| ", " |+| b)
      )

  def describePeriphery() =
    println(
      "The periphrial is " |+| peripheral
        .map(_.name)
        .reduce((a, b) => a |+| ", " |+| b)
    )

  def startExpansion() = {
    core = core.map(_.copy(growth = 2))
    semiPeripheral = semiPeripheral.map(_.copy(growth = 1.5))
    peripheral = peripheral.map(_.copy(growth = 1.3))
  }

  def midExpansion() = {
    core = core.map(_.copy(growth = 1.5))
    semiPeripheral = semiPeripheral.map(_.copy(growth = 1.6))
    peripheral = peripheral.map(_.copy(growth = 1.8))
  }
}

object Civilization {
  val metaQuestions: List[String] = List(
    "Do civilizaitons have a life cycle?"
  )
}
