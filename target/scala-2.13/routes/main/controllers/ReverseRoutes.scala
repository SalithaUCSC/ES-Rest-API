// @GENERATOR:play-routes-compiler
// @SOURCE:/home/pool/Desktop/es-rest-api/conf/routes
// @DATE:Sat Apr 11 10:54:39 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:2
package controllers {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:2
  class ReverseAccountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:3
    def searchOneAccountByAccount(accountNumber:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/search/by_account/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("accountNumber", accountNumber)))
    }
  
    // @LINE:12
    def deleteIndex(name:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "index/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:5
    def searchAccountsByAgeRange(age:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/search/by_age/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("age", age)))
    }
  
    // @LINE:4
    def searchAccountsByName(name:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/search/by_name/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("name", name)))
    }
  
    // @LINE:11
    def createNewIndex(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "index/create")
    }
  
    // @LINE:6
    def searchAggregationByAgeAndGender(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/search/aggregation")
    }
  
    // @LINE:2
    def searchAllAccounts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "account/search")
    }
  
    // @LINE:9
    def deleteAccount(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "account/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:8
    def createNewAccount(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "account/create")
    }
  
  }


}
