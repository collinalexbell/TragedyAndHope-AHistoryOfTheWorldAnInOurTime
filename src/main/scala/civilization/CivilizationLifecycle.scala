package civilization

import civilization.instances.WesternCivilization

class PeriodOfLife(val growthRate: Double) {}
case class Born() extends PeriodOfLife(Double.PositiveInfinity)
case class Expansion(
    populationGrowth: Double = 2,
    geographicGrowth: Double = 2,
    productionGrowth: Double = 2,
    knowledgeGrowth: Double = 2
) extends PeriodOfLife(2)
case class AgeOfConflict(
    classConflictGrowth: Double = 1.5,
    violentImperialWarGrowth: Double = 1.5,
    irrationalityGrowth: Double = 1.5,
    pessimismGrowth: Double = 1.5,
    superstitionGrowth: Double = 1.5,
    otherworldlienessGrowth: Double = 1.5
) extends PeriodOfLife(1.5)
case class GoldenAge() extends PeriodOfLife(1)
case class DeathCrisis() extends PeriodOfLife(0.5)
case class Dead() extends PeriodOfLife(Double.NegativeInfinity)

trait Periodable {
  def periodOfLife: PeriodOfLife
}

trait PeriodableWithGrowable extends Periodable with Growable {
  def periodOfLife: PeriodOfLife = {
    if (growth == 1) {
      GoldenAge()
    } else if (growth < 1) {
      DeathCrisis()
    } else if (growth > 1 && growth <= 1.8) {
      AgeOfConflict()
    } else if (growth > 1.8) {
      Expansion()
    } else {
      Dead()
    }
  }
}

object Periodable {
  def nextPeriod(p: Periodable): PeriodOfLife = {
    p.periodOfLife match {
      case Born()                => Expansion()
      case Expansion(_, _, _, _) => AgeOfConflict()
      case AgeOfConflict(_, _, _, _, _, _) if p == WesternCivilization =>
        Expansion()
      case AgeOfConflict(_, _, _, _, _, _) => GoldenAge()
      case GoldenAge()                     => DeathCrisis()
      case DeathCrisis()                   => Dead()
    }
  }
}
