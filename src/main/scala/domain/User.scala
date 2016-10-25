package domain {

  class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val roleId: Long,
    val phone: String,
    val email: String,
    val invitedById: Option[Long]
  ) {
    def this(firstName: String, lastName: String, patronymic: String, role: Role, mobile: String, email: String, invitedBy: Option[User]) =
      this(-1, firstName, lastName, patronymic, role.id, mobile, email, invitedBy.map(_.id))
  }
}
