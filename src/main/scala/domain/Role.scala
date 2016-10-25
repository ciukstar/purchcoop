package domain {

  class Role(val id: Long, val name: String) {
    def this(name: String) = this(-1, name)
  }
}
