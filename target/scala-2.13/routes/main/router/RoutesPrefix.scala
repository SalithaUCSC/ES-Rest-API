// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pool/Desktop/es-rest-api/conf/routes
// @DATE:Sat Apr 11 10:54:39 IST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
