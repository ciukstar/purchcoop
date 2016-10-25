package domain {

  class Role(val id: Long, val name: String, val roleType: RoleType.Value) {
    def this(name: String, roleType: RoleType.Value) = this(-1, name, roleType)
    def this(name: String) = this(-1, name, RoleType.Customer)
  }

  object RoleType extends Enumeration {
    val Admin, Organizer, Customer = Value
  }
}
