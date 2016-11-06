package edu.ciukstar.cooper.lib {

  import edu.ciukstar.cooper.domain.Role
  import net.liftweb.http.{ JsonResponse, LiftRules }
  import net.liftweb.http.rest.RestHelper
  import net.liftweb.json.{ JObject }
  import org.squeryl.customtypes.CustomTypesMode._
  import edu.ciukstar.cooper.domain.DomainSchema._
  import net.liftweb.json.JsonDSL._


  object RoleService extends RestHelper {

    def init(): Unit = {
      LiftRules.statelessDispatch.append(RoleService)
    }

    serve("api" / "roles" prefix {
      case Nil JsonPost req => inTransaction {
        val r = roles.insert(req._1.asInstanceOf[JObject].extract[Role])
        val json = ("id" -> r.id) ~ ("name" -> r.name)
        JsonResponse(json, List(("Location", "/appi/roles/" + r.id)), Nil, 201)
      }
    })
  }
}
