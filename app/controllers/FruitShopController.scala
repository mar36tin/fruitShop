package controllers

import play.api.mvc._
import forms.FormFruit._
import models.Fruit
import services.FruitService

trait FruitShopController extends Controller {
  this: Controller =>

  val fruitService = new FruitService
  val apple = Fruit("apple", 0.60)
  val orange = Fruit("orange", 0.25)

  def index = Action {
    Ok(views.html.index(fruitsForm))
  }

  def addFruit = Action { implicit request =>

    fruitsForm.bindFromRequest.fold(
      errors => BadRequest,
      fruits => {
        val apples = List.fill(fruits.apples.getOrElse(0))(apple)
        val oranges = List.fill(fruits.oranges.getOrElse(0))(orange)
        val fruitList = apples ::: oranges

        val totalprice = fruitService.calculateTotalPayment(fruitList)
        Redirect(routes.FruitShopController.checkout(totalprice.toString))
      }
    )
  }

  def checkout(totalPrice: String) = Action { implicit request =>
    Ok(views.html.checkout(totalPrice))
  }

}


object FruitShopController extends FruitShopController

