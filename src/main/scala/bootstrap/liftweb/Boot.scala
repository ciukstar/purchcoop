package bootstrap.liftweb

import net.liftweb.http.{Html5Properties, LiftRules, Req}

class Boot {

  def boot: Unit = {
    LiftRules.addToPackages("edu.ciukstar.cooper.app")
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))
  }
}
