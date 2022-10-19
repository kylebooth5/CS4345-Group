// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/katebouis/Desktop/cs/cs4345/CS4345-Group-3/Frontend/conf/routes
// @DATE:Tue Oct 18 20:25:24 CDT 2022


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
