package domain {

  import org.squeryl.KeyedEntity

  class User(
    val fullName: FullName,
    val roleId: Long,
    val phone: String,
    val email: String,
    val invitedById: Option[Long]
  ) extends KeyedEntity[Long] {

    val id: Long = -1

    def this(fullName: FullName, role: Role, mobile: String, email: String, invitedBy: Option[User]) =
      this(fullName, role.id, mobile, email, invitedBy.map(_.id))

    def this() = this(new FullName("", "", ""), -1, "", "", None)
  }
}
