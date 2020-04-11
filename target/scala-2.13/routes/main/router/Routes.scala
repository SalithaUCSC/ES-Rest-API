// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pool/Desktop/es-rest-api/conf/routes
// @DATE:Sat Apr 11 10:54:39 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  AccountController_0: controllers.AccountController,
  // @LINE:15
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    AccountController_0: controllers.AccountController,
    // @LINE:15
    Assets_1: controllers.Assets
  ) = this(errorHandler, AccountController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, AccountController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/search""", """controllers.AccountController.searchAllAccounts()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/search/by_account/""" + "$" + """accountNumber<[^/]+>""", """controllers.AccountController.searchOneAccountByAccount(accountNumber:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/search/by_name/""" + "$" + """name<[^/]+>""", """controllers.AccountController.searchAccountsByName(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/search/by_age/""" + "$" + """age<[^/]+>""", """controllers.AccountController.searchAccountsByAgeRange(age:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/search/aggregation""", """controllers.AccountController.searchAggregationByAgeAndGender()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/create""", """controllers.AccountController.createNewAccount(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/delete/""" + "$" + """id<[^/]+>""", """controllers.AccountController.deleteAccount(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index/create""", """controllers.AccountController.createNewIndex(request:Request)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index/delete/""" + "$" + """name<[^/]+>""", """controllers.AccountController.deleteIndex(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_AccountController_searchAllAccounts0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/search")))
  )
  private[this] lazy val controllers_AccountController_searchAllAccounts0_invoker = createInvoker(
    AccountController_0.searchAllAccounts(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "searchAllAccounts",
      Nil,
      "GET",
      this.prefix + """account/search""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_AccountController_searchOneAccountByAccount1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/search/by_account/"), DynamicPart("accountNumber", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_searchOneAccountByAccount1_invoker = createInvoker(
    AccountController_0.searchOneAccountByAccount(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "searchOneAccountByAccount",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/search/by_account/""" + "$" + """accountNumber<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_AccountController_searchAccountsByName2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/search/by_name/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_searchAccountsByName2_invoker = createInvoker(
    AccountController_0.searchAccountsByName(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "searchAccountsByName",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/search/by_name/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_AccountController_searchAccountsByAgeRange3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/search/by_age/"), DynamicPart("age", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_searchAccountsByAgeRange3_invoker = createInvoker(
    AccountController_0.searchAccountsByAgeRange(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "searchAccountsByAgeRange",
      Seq(classOf[String]),
      "GET",
      this.prefix + """account/search/by_age/""" + "$" + """age<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_AccountController_searchAggregationByAgeAndGender4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/search/aggregation")))
  )
  private[this] lazy val controllers_AccountController_searchAggregationByAgeAndGender4_invoker = createInvoker(
    AccountController_0.searchAggregationByAgeAndGender(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "searchAggregationByAgeAndGender",
      Nil,
      "GET",
      this.prefix + """account/search/aggregation""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_AccountController_createNewAccount5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/create")))
  )
  private[this] lazy val controllers_AccountController_createNewAccount5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AccountController_0.createNewAccount(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "createNewAccount",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """account/create""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AccountController_deleteAccount6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_deleteAccount6_invoker = createInvoker(
    AccountController_0.deleteAccount(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "deleteAccount",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """account/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_AccountController_createNewIndex7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index/create")))
  )
  private[this] lazy val controllers_AccountController_createNewIndex7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AccountController_0.createNewIndex(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "createNewIndex",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """index/create""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_AccountController_deleteIndex8_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index/delete/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AccountController_deleteIndex8_invoker = createInvoker(
    AccountController_0.deleteIndex(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AccountController",
      "deleteIndex",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """index/delete/""" + "$" + """name<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned9_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_AccountController_searchAllAccounts0_route(params@_) =>
      call { 
        controllers_AccountController_searchAllAccounts0_invoker.call(AccountController_0.searchAllAccounts())
      }
  
    // @LINE:3
    case controllers_AccountController_searchOneAccountByAccount1_route(params@_) =>
      call(params.fromPath[String]("accountNumber", None)) { (accountNumber) =>
        controllers_AccountController_searchOneAccountByAccount1_invoker.call(AccountController_0.searchOneAccountByAccount(accountNumber))
      }
  
    // @LINE:4
    case controllers_AccountController_searchAccountsByName2_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_AccountController_searchAccountsByName2_invoker.call(AccountController_0.searchAccountsByName(name))
      }
  
    // @LINE:5
    case controllers_AccountController_searchAccountsByAgeRange3_route(params@_) =>
      call(params.fromPath[String]("age", None)) { (age) =>
        controllers_AccountController_searchAccountsByAgeRange3_invoker.call(AccountController_0.searchAccountsByAgeRange(age))
      }
  
    // @LINE:6
    case controllers_AccountController_searchAggregationByAgeAndGender4_route(params@_) =>
      call { 
        controllers_AccountController_searchAggregationByAgeAndGender4_invoker.call(AccountController_0.searchAggregationByAgeAndGender())
      }
  
    // @LINE:8
    case controllers_AccountController_createNewAccount5_route(params@_) =>
      call { 
        controllers_AccountController_createNewAccount5_invoker.call(
          req => AccountController_0.createNewAccount(req))
      }
  
    // @LINE:9
    case controllers_AccountController_deleteAccount6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_AccountController_deleteAccount6_invoker.call(AccountController_0.deleteAccount(id))
      }
  
    // @LINE:11
    case controllers_AccountController_createNewIndex7_route(params@_) =>
      call { 
        controllers_AccountController_createNewIndex7_invoker.call(
          req => AccountController_0.createNewIndex(req))
      }
  
    // @LINE:12
    case controllers_AccountController_deleteIndex8_route(params@_) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_AccountController_deleteIndex8_invoker.call(AccountController_0.deleteIndex(name))
      }
  
    // @LINE:15
    case controllers_Assets_versioned9_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned9_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
