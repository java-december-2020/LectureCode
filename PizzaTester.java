public class PizzaTester {
  public static void main(String[] args) {
    // Pizza cheese = new Pizza();

    // cheese.size = "Large";
    // cheese.slices = 10;
    // cheese.crustType = "deep dish";
    // cheese.toppings = new String[] { "cheese" };
    // cheese.displayPizza();
    String[] pizza1Toppings = new String[] { "Jalapeno", "Onion", "Garlic", "Kale" };
    Pizza veggie = new Pizza(pizza1Toppings, "XL");

    veggie.displayPizza();

    Pizza cheese = new Pizza(new String[] { "cheese" }, "Large", 10, "Deep Dish");
    cheese.displayPizza();
    Pizza pepperoni = new Pizza(new String[] { "Cheese", "Pepperoni" }, "Large", 10, "New York Crust");

    Pizza meatPizza = new Pizza(new String[] { "Cheese", "Pepperoni", "Sasuage", "Ham", "chicken" }, "Extra Large", 16,
        "Regular Crust");
    Pizza hawaiian = new Pizza(new String[] { "Ham", "Pineapple" }, "Large", 10, "Regular Crust");

    Pizza newPizza = new Pizza(new String[] { "Pepperoni", "Sasusage", "Cheese" }, "Large");

    newPizza.displayPizza();
    meatPizza.eatSlice(3);
    pepperoni.setSize("");
    pepperoni.displayPizza();
    pepperoni.eatSlice(3);

    pepperoni.pizzaFight(cheese);

    hawaiian.pizzaFight(pepperoni);
  }
}