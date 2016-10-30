package edu.ciukstar.cooper.domain {

  class Vender(val id: Long, name: String) {
    def this(name: String) = this(-1, name)
    def this() = this(-1, "")
  }
}
