package edu.ciukstar.cooper.domain {

  import org.squeryl.KeyedEntity

  class User(
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val roleId: Long,
    val phone: String,
    val email: String,
    val invitedById: Option[Long]
  ) extends KeyedEntity[Long] {

    val id: Long = -1

    def this(fullName: FullName, role: Role, mobile: String, email: String, invitedBy: Option[User]) =
      this(fullName.firstName, fullName.lastName, fullName.patronymic, role.id, mobile, email, invitedBy.map(_.id))

    def this(fullName: FullName, role: Role, mobile: String, email: String) =
      this(fullName, role, mobile, email, None)

    def this() =
      this("", "", "", -1, "", "", None)

    def fullName: FullName = FullName(firstName, lastName, patronymic)
  }
}
