package civilization

import civilization.instances.WesternCivilization

class PeriodOfLife(val growthRate: Double) {}
case class Born() extends PeriodOfLife(Double.PositiveInfinity)
case class Expansion(
    populationGrowth: Double = 3,
    geographicGrowth: Double = 1.5,
    productionGrowth: Double = 10,
    knowledgeGrowth: Double = 15
) extends PeriodOfLife(10)
case class GrowthCrisis() extends PeriodOfLife(5)
case class GoldenAge() extends PeriodOfLife(0)
case class DeathCrisis() extends PeriodOfLife(-5)
case class Dead() extends PeriodOfLife(Double.NegativeInfinity)

object CivilizationLifecycle {
  def next(civ: Civilization): PeriodOfLife = {
    civ.periodOfLife match {
      case Born()                                       => Expansion()
      case Expansion(_, _, _, _)                        => GrowthCrisis()
      case GrowthCrisis() if civ == WesternCivilization => Expansion()
      case GrowthCrisis()                               => GoldenAge()
      case GoldenAge()                                  => DeathCrisis()
      case DeathCrisis()                                => Dead()
    }
  }
}
