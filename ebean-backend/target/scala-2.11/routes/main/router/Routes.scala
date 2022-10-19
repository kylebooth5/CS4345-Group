
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/katebouis/Desktop/cs/cs4345/CS4345-Group-3/ebean-backend/conf/routes
// @DATE:Tue Oct 18 20:22:37 CDT 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:9
  UserController_1: controllers.UserController,
  // @LINE:17
  PositionController_2: controllers.PositionController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:9
    UserController_1: controllers.UserController,
    // @LINE:17
    PositionController_2: controllers.PositionController
  ) = this(errorHandler, HomeController_0, UserController_1, PositionController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, UserController_1, PositionController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.UserController.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.UserController.registerNew()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createPosition""", """controllers.PositionController.createPosition()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_authenticate1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UserController_authenticate1_invoker = createInvoker(
    UserController_1.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "authenticate",
      Nil,
      "POST",
      """Login""",
      this.prefix + """login"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_registerNew2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_UserController_registerNew2_invoker = createInvoker(
    UserController_1.registerNew(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "registerNew",
      Nil,
      "POST",
      """ Add User  {"name":name, "password":password}""",
      this.prefix + """signup"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_PositionController_createPosition3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createPosition")))
  )
  private[this] lazy val controllers_PositionController_createPosition3_invoker = createInvoker(
    PositionController_2.createPosition(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PositionController",
      "createPosition",
      Nil,
      "POST",
      """""",
      this.prefix + """createPosition"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:9
    case controllers_UserController_authenticate1_route(params) =>
      call { 
        controllers_UserController_authenticate1_invoker.call(UserController_1.authenticate())
      }
  
    // @LINE:13
    case controllers_UserController_registerNew2_route(params) =>
      call { 
        controllers_UserController_registerNew2_invoker.call(UserController_1.registerNew())
      }
  
    // @LINE:17
    case controllers_PositionController_createPosition3_route(params) =>
      call { 
        controllers_PositionController_createPosition3_invoker.call(PositionController_2.createPosition())
      }
  }
}
