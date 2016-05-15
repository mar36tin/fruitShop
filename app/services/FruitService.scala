package services

import models.Fruit

class FruitService {

  def calculateTotalPayment(fruits: List[Fruit]): BigDecimal =
    fruits match {
        case Nil => 0.00
        case x :: tail => fruits.head.price + calculateTotalPayment(fruits.tail)
      }
}
