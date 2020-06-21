package civilization.instances

import civilization._

object ClassicalCivilization extends Civilization("Classical", Culture()) {
  core = List(
    Area("Shores of Aegean Sea")
  )

  semiPeripheral = List(
    Area("Northern portion of eastern Mediterranean Sea")
  )

  peripheral = List(
    Area("Rest of Mediterranean"),
    Area("Spain"),
    Area("North Africa"),
    Area("Gaul")
  )
}
