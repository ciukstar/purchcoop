package edu.ciukstar.cooper.lib {

  import net.liftweb.http.{ JsonResponse, LiftRules }
  import net.liftweb.http.rest.RestHelper
  import net.liftweb.json.JArray
  import org.squeryl.customtypes.CustomTypesMode._
  import edu.ciukstar.cooper.domain.DomainSchema._

  object CategoryService extends RestHelper {

    def init(): Unit = {
      LiftRules.statelessDispatch.append(CategoryService)
    }

    serve ("api" / "categories" prefix {
      case id :: Nil JsonGet req =>
        inTransaction {
          from(categories)(c => where(c.id === id.toLong) select(c)).singleOption.map(_.toJson)
        }
      case Nil JsonGet req =>
        inTransaction {
          JsonResponse(JArray(from(categories)(c => select(c)).seq.toList.map(_.toJson)))
        }
    })
  }
}
