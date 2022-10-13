// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/kyleb/Desktop/Lab-2-Ebean/Frontend/conf/routes
// @DATE:Wed Oct 12 16:54:12 CDT 2022


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
