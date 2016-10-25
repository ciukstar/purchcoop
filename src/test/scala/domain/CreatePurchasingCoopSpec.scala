package domain {

  import org.scalatest._

  class CreatePurchansingCoopSpec extends FlatSpec
      with Matchers with OneInstancePerTest with BeforeAndAfterAll with BeforeAndAfterEach {

    "foo" should "bar" in {

      val administrator = new Role("Administrator")
      val admin = new User("Admin", "Admin", "Adminovich", administrator, "916834567", "admin@coop.com", None)
    }
  }
}
