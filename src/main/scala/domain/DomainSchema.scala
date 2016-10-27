package domain {

  import org.squeryl.{Schema}
  import Database._

  object DomainSchema extends Schema {

    val roles = table[Role]
    val users = table[User]
    val venders = table[Vender]
    val categories = table[Category]
    val products = table[Product]
    val dispensers = table[Dispenser]
    val coops = table[Purchase]

  }

}
