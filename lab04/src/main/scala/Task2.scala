class ShoppingItem(var productName: String, var price: Double, var isInBusket: Boolean = false) {

  override def toString: String = s"${productName} - price ${price} | Is in basket?: ${isInBusket}"

  def toBusket(): Unit = {isInBusket = true}

}



class ShoppingItemList() {
  var shoppingList : List[ShoppingItem] = List()

  override def toString : String = {
    shoppingList.mkString("\n")
  }

  def +(shoppingItem: ShoppingItem) : Unit = {
    shoppingList = shoppingItem :: shoppingList
  }
  def putInBasket(num: Int) : Unit = {
    if(num <= shoppingList.length){
      shoppingList(num-1).toBusket()
    }
  }

  def removeItemsWhichAreInBasket() : ShoppingItemList = {
    shoppingList = shoppingList.filter(! _.isInBusket)
    this
  }
}


object Task2 {
  def main(args: Array[String]) = {
    val shoppingList = new ShoppingItemList()

    shoppingList + new ShoppingItem("Milk", 6.66)
    shoppingList + new ShoppingItem("Beer", 3.33)
    shoppingList + new ShoppingItem("Vodka (please not żubrówka)", 38.99)

    println("-------------List v1-------------")
    println(shoppingList)

    // Prints list of all three ShoppingItems nicely formatted, each in separate line

    shoppingList.putInBasket(1)
    shoppingList.putInBasket(2)

    println("-------------List v2-------------")
    println(shoppingList)

    // Prints list of all three ShoppingItems nicely formatted, each in separate line, with beer and vodka in basket

    val itemsYetToBuy = shoppingList.removeItemsWhichAreInBasket()
    println("-------------List v3-------------")
    println(itemsYetToBuy)

    // Prints just one ShoppingItem - Milk
  }
}
