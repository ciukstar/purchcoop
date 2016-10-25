package domain {

  object RoleType extends Enumeration {
    val Admin = Value(1, "Admin")
    val Organizer = Value(2, "Organizer")
    val Customer = Value(3, "Customer")
  }

  class Role(val id: Long, val name: String, val roleType: RoleType.Value) {
    def this(name: String, roleType: RoleType.Value) = this(-1, name, roleType)
    def this(name: String) = this(-1, name, RoleType.Customer)
  }

}
