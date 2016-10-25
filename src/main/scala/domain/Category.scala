package domain {

  class Category(val id: Long, val name: String) {
    def this(name: String) = this(-1, name)
  }
}
