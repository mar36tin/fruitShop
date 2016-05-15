package controllers

import scala.concurrent.Future

import org.scalatest._
import org.scalatestplus.play._

import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._

class FruitShopControllerSpec extends PlaySpec with Results {

  class TestController() extends Controller with FruitShopController

  "Fruit shop index page" should {
    "respond with a valid page" in {
      val controller = new TestController()
      val result: Future[Result] = controller.index().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
      bodyText must include("Apples")
      bodyText must include("Oranges")
      status(result) mustBe OK
    }

    "redirect with the correct total" in {
      val controller = new TestController()
      val result: Future[Result] = controller.addFruit().apply(FakeRequest())
      val bodyText: String = contentAsString(result)
//      bodyText must include("Apples")
//      bodyText must include("Oranges")
      status(result) mustBe (SEE_OTHER)
//      redirectLocation(result) must contain("/cases")
    }
  }
}