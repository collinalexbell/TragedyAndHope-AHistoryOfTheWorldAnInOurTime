package civilization

import java.{util => ju}

object timeline {
  type Timeline = Map[ju.Date, PeriodOfLife]
}
