package civilization.instances

import civilization._

object MesopotamianCivilization
    extends Civilization("Mesopotamian", Culture()) {
  timeline + (fmt.parse("01/01/-6000") -> Born())
  timeline + (fmt.parse("01/01/-300") -> Dead())

  core = List(Area("lower valley of Mesopotamia"))
  semiPeripheral = List(
    Area("middle valley of Mesopotamia"),
    Area("upper valley of Mesopotamia")
  )
  peripheral = List(
    Area("highlands surrounding the valley"),
    Area("Iran"),
    Area("Syria"),
    Area("Anatolia")
  )
}
