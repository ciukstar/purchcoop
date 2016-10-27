package domain {

  import com.mchange.v2.c3p0.ComboPooledDataSource
  import org.squeryl.adapters.H2Adapter
  import org.squeryl.{PrimitiveTypeMode, Session, SessionFactory}

  object Database extends PrimitiveTypeMode {

    def init: Unit = {
      val ds = new ComboPooledDataSource
      ds.setDriverClass("org.h2.Driver")
      ds.setJdbcUrl("jdbc:h2:mem:cooper")
      ds.setUser("root")
      ds.setPassword("")
      ds.setMinPoolSize(1)
      ds.setAcquireIncrement(1)
      ds.setMaxPoolSize(50)

      SessionFactory.concreteFactory =
        Some(() => Session.create(ds.getConnection, new H2Adapter))
    }

    def teardown: Unit = {
      
    }
  }

}
