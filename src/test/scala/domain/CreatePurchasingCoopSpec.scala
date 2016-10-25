package domain {

  import org.scalatest._
  import DomainPrimitiveTypeMode._
  import DomainSchema._

  class CreatePurchansingCoopSpec extends FlatSpec with DatabaseInit
      with Matchers with OneInstancePerTest with BeforeAndAfterAll with BeforeAndAfterEach {

    "foo" should "bar" in {

      val adminRole = new Role("Administrator", RoleType.Admin)
      val organiserRole = new Role("Organizer", RoleType.Organizer)
      val admin = new User("Admin", "Admin", "Adminovich", adminRole, "916834567", "admin@coop.com", None)
      val organizer = new User("Organizer", "Organizer", "Organizerovich", organiserRole, "819387192", "orga@coop.com", None)

      val category = new Category("Cat1")
      val vender = new Vender("V1")

      val product = new Product("Product1", category, vender, 87654543, "The description")

      val productCoop = new PurchasingCoop(product, organizer)

    }

    override def beforeAll(): Unit = {
      configureDb()
      inTransaction { DomainSchema.create }
    }

    override def beforeEach(): Unit = {
      inTransaction {
        coops.deleteWhere( _ => 1 === 1)
        products.deleteWhere( _ => 1 === 1)
        venders.deleteWhere( _ => 1 === 1)
        categories.deleteWhere(_ => 1 === 1)
        users.deleteWhere( _ => 1 === 1)
        roles.deleteWhere( _ => 1 === 1)
      }
    }

    override def afterAll(): Unit = closeDbConnections()
  }
}
