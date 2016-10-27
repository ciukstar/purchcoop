package domain {

  import Database._
  import org.scalatest._
  import DomainSchema._

  class UserSpec extends FlatSpec
    with Matchers with OneInstancePerTest with BeforeAndAfterAll with BeforeAndAfterEach {

    "users.insert" should "create a new User" in {
      val firstName = "S"
      val lastName = "N"
      val patronymic = "P"
      val phn = "9140980980"
      val email = "somebody@somewhere.com"

      inTransaction ({
        val role = roles.insert(new Role("Admin", RoleType.Admin))
        users.insert(new User(FullName(firstName, lastName, patronymic), role, phn, email))
      })

      inTransaction ({
        val res = from(users)(u => select(u)).single

        res shouldNot have ('id (-1))
        res should have ('fullName (FullName(firstName, lastName, patronymic)))
        res should have ('phone (phn))
        res should have ('email (email))
      })
    }

    override def beforeAll(): Unit = {
      Database.init
      inTransaction { DomainSchema.create }
    }

    override def beforeEach(): Unit = {
      inTransaction {
        users.deleteWhere(_ => 1 === 1)
      }
    }

    override def afterAll(): Unit =
      Database.teardown
  }
}
