package services

import baseSpec.UnitSpec
import models.Fruit

/**
  * Created by mgwarada on 15/05/16.
  */
class FruitServiceSpec extends UnitSpec {

  val testFruitService = new FruitService

  "FruitService " should {
    "calculate the total price when given a list of fruits" in {
      val fruitList = List(Fruit("apple", 0.60), Fruit("apple", 0.25), Fruit("orange", 0.25))
      val result = testFruitService.calculateTotalPayment(fruitList)
      result shouldBe 1.10
    }
  }

}
