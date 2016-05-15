
case class Fruit(fruit: String, price: BigDecimal)

val fruits = List(Fruit("apple", 0.60), Fruit("apple", 0.25), Fruit("orange", 0.25))


def sum(f: List[Fruit]): BigDecimal = {

  f match {
    case Nil => 0.00
    case x :: tail => f.head.price + sum(f.tail)
  }

}


sum(List(Fruit("apple", 0.60), Fruit("apple", 0.25), Fruit("orange", 0.25)))