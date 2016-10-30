package edu.ciukstar.cooper.domain {

  import org.squeryl.KeyedEntity
  import net.liftweb.json._
  import net.liftweb.json.JsonDSL._

  class Category(val name: String) extends KeyedEntity[Long] {
    val id: Long = -1

    def toJson: JObject =
      ("id" -> id) ~ ("name" -> name)
  }
}
