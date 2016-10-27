package domain {

  import org.scalatest._
  import Database._
  import DomainSchema._

  class CategorySpec extends FlatSpec
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
      Database.init
      inTransaction { DomainSchema.create }
    }

    override def beforeEach(): Unit = {
      inTransaction { categories.deleteWhere(_ => 1 === 1) }
    }

    override def afterAll(): Unit = {
      Database.teardown
    }
  }
}
