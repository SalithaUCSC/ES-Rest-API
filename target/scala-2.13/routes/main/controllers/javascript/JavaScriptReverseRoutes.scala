// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pool/Desktop/es-rest-api/conf/routes
// @DATE:Sat Apr 11 10:54:39 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers.javascript {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseAccountController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def searchOneAccountByAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.searchOneAccountByAccount",
      """
        function(accountNumber0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/search/by_account/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("accountNumber", accountNumber0))})
        }
      """
    )
  
    // @LINE:12
    def deleteIndex: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.deleteIndex",
      """
        function(name0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "index/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
    // @LINE:5
    def searchAccountsByAgeRange: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.searchAccountsByAgeRange",
      """
        function(age0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/search/by_age/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("age", age0))})
        }
      """
    )
  
    // @LINE:4
    def searchAccountsByName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.searchAccountsByName",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/search/by_name/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("name", name0))})
        }
      """
    )
  
    // @LINE:11
    def createNewIndex: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.createNewIndex",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "index/create"})
        }
      """
    )
  
    // @LINE:6
    def searchAggregationByAgeAndGender: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.searchAggregationByAgeAndGender",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/search/aggregation"})
        }
      """
    )
  
    // @LINE:2
    def searchAllAccounts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.searchAllAccounts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "account/search"})
        }
      """
    )
  
    // @LINE:9
    def deleteAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.deleteAccount",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "account/delete/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:8
    def createNewAccount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AccountController.createNewAccount",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "account/create"})
        }
      """
    )
  
  }


}
