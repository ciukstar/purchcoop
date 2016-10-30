package bootstrap.liftweb

import edu.ciukstar.cooper.domain.{Database, DomainSchema}
import edu.ciukstar.cooper.lib.CategoryService
import net.liftweb.http.{Html5Properties, LiftRules, Req}
import org.squeryl.customtypes.CustomTypesMode._

class Boot extends Database {

  def boot: Unit = {
    LiftRules.addToPackages("edu.ciukstar.cooper.app")
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))

    CategoryService.init()

    initDatasource
    inTransaction { DomainSchema.create }
    LiftRules.unloadHooks.append(() => teardownDatasource)
  }
}
