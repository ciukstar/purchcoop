package edu.ciukstar.cooper.domain {

  class Product(
    val id: Long,
    val name: String,
    val categoryId: Long,
    val venderId: Long,
    val price: Long,
    val description: String,
    val link: Option[String],
    val image: Option[Array[Byte]]
  ) {

    def this() =
      this(id = -1, name = "", categoryId = -1, venderId = -1, price = 0, description = "", link = None, image = None)

    def this(name: String, category: Category, vender: Vender, price: Long, description: String) =
      this(-1, name, category.id, vender.id, price, description, None, None)

    def this(name: String, category: Category, vender: Vender, price: Long, description: String, link: Option[String]) =
      this(-1, name, category.id, vender.id, price, description, link, None)

    def this(name: String, category: Category, vender: Vender, price: Long, description: String, link: Option[String], image: Option[Array[Byte]]) =
      this(-1, name, category.id, vender.id, price, description, link, image)
  }
}
