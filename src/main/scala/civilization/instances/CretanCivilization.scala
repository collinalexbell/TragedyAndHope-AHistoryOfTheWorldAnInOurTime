package civilization.instances

import civilization._

object CretanCivilization extends Civilization(Culture()) {
  core = List(
    Area("Crete")
  )

  peripheral = List(
    Area("Aegean island"),
    Area("Balkan coasts")
  )
}
