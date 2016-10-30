package edu.ciukstar.cooper.domain {

  import org.scalatest._
  import DomainSchema._
  import org.squeryl.customtypes.CustomTypesMode._

  class CategorySpec extends FlatSpec with Database
    with Matchers with OneInstancePerTest with BeforeAndAfterAll with BeforeAndAfterEach {

    "categories.insert(new Category(\"clothing\"))" should "create a new Category" in {

      val categoryName = "Clothing"

      inTransaction {
        val clothing = categories.insert(new Category(categoryName))
      }

      inTransaction {
        val res = from(categories)(c => select(c)).single
        res shouldNot have ('id (-1))
        res should have ('name (categoryName))
      }
    }

    override def beforeAll(): Unit = {
      initDatasource
      inTransaction { DomainSchema.create }
    }

    override def beforeEach(): Unit = {
      inTransaction { categories.deleteWhere(_ => 1 === 1) }
    }

    override def afterAll(): Unit =
      teardownDatasource
  }
}
