package edu.ciukstar.cooper.domain {

  import org.scalatest._
  import DomainSchema._
  import org.squeryl.customtypes.CustomTypesMode._

  class CreatePurchaseSpec extends FlatSpec with Database
    with Matchers with OneInstancePerTest with BeforeAndAfterAll with BeforeAndAfterEach {

    "A Purchase" should "be created for an organizer user for a Product" in {

      inTransaction {
        val adminRole = roles.insert(new Role("Administrator", RoleType.Admin))
        val organiserRole = roles.insert(new Role("Organizer", RoleType.Organizer))
        val admin = users.insert(
          new User(new FullName("Surname", "Name", "Patr"), adminRole, "916834567", "admin@coop.com", None)
        )
        val organizer = users.insert(
          new User(new FullName("OtherSur", "OtherN", "OtherPat"), organiserRole, "819387192", "orga@coop.com", None)
        )

        val category = categories.insert( new Category("Cat1"))
        val vender = venders.insert(new Vender("V1"))

        val product = products.insert(new Product("Product1", category, vender, 87654543, "The description"))

        val productCoop = coops.insert(new Purchase(product, organizer))
      }

      inTransaction {
        from(coops)(c => select(c)).seq should not be empty
      }

    }

    override def beforeAll(): Unit = {
      initDatasource
      inTransaction { DomainSchema.create }
    }

    override def beforeEach(): Unit = {
      inTransaction {
        coops.deleteWhere(_ => 1 === 1)
        products.deleteWhere(_ => 1 === 1)
        venders.deleteWhere(_ => 1 === 1)
        categories.deleteWhere(_ => 1 === 1)
        users.deleteWhere(_ => 1 === 1)
        roles.deleteWhere(_ => 1 === 1)
      }
    }

    override def afterAll(): Unit =
      teardownDatasource
  }
}
