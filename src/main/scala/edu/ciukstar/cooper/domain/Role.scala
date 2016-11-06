package edu.ciukstar.cooper.domain {

  import org.squeryl.KeyedEntity

  object RoleType extends Enumeration {
    val Admin = Value(1, "Admin")
    val Organizer = Value(2, "Organizer")
    val Customer = Value(3, "Customer")
  }

  class Role(
    val name: String,
    val roleType: RoleType.Value,
    val description: String
  ) extends KeyedEntity[Long] {
    val id: Long = -1

    def this(name: String) = this(name, RoleType.Customer, "")
  }

}
