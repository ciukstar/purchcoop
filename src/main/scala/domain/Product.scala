package domain {

  class Product(
    val id: Long,
    val name: String,
    val categoryId: Long,
    val venderId: Long,
    val price: Long,
    val link: String,
    val description: String,
    val image: Array[Byte]
  ) {

    def this(name: String, category: ProductCategory, vender: Vender, price: Long, link: String, description: String, image: Array[Byte]) =
      this(-1, name, category.id, vender.id, price, link, description, image)
  }
}
