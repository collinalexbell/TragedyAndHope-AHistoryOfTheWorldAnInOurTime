package civilization.instances

import civilization._

object CannaniteCivilization extends Civilization("Cannanite", Culture()) {
  timeline + ((fmt.parse("01/01/-2200"), Born()))
  timeline + ((fmt.parse("01/01/-100"), Dead()))

  core = List(Area("Levant"))
  peripheral = List(
    Area("western Mediterranean at Tunis"),
    Area("western Sicily"),
    Area("eastern Spain")
  )
}
