import java.util.Arrays;

public class Pizza {
  // Things Pizzas Have
  // Array of Strings that hold the toppings
  // String that holds on to the size
  // int slices
  // String type of crust
  private String[] toppings;
  private String size;
  private int slices;
  private String crustType;
  private static int numberOfPizzas;

  public Pizza(String[] toppings, String size, int slices, String crustType) {
    this.toppings = toppings;
    this.size = size;
    this.slices = slices;
    this.crustType = crustType;
    numberOfPizzas++;
  }

  // Method Overloading
  public Pizza(String[] toppings, String size) {
    this.toppings = toppings;
    this.size = size;
    this.slices = 10;
    this.crustType = "New York";
    numberOfPizzas++;
  }

  // Getters
  public String[] getToppings() {
    return this.toppings;
  }

  public String getSize() {
    return this.size;
  }

  public int getSlices() {
    return this.slices;
  }

  public String getCrustType() {
    return this.crustType;
  }

  public int getNumOfPizza() {
    return this.numberOfPizzas;
  }

  // Setters
  public void setToppings(String[] toppings) {
    this.toppings = toppings;
  }

  public void setSize(String size) {
    if (size.equals("")) {
      System.out.println("Size Not Recognized");
      return;
    }
    this.size = size;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public void setCrustType(String crustType) {
    this.crustType = crustType;
  }

  // Things our pizza can do
  // Method to advertise for our pizza shop
  // Eat a slice of pizza
  // Display the type of pizza

  public void displayPizza() {
    System.out.println(
        "This is a " + Arrays.toString(toppings) + " pizza that is size " + size + " with " + slices + " slices.");
  }

  public static void advertise() {
    System.out.println("Hey, you, come check out these pizzas at these great prices!!!");
  }

  public void eatSlice(int slices) {
    System.out.println("You just ate " + slices + "slices");
    this.slices -= slices;
    System.out.println("Now this pizza has " + this.slices + " slices.");
  }

  public void eatSlice() {
    this.slices -= 1;
    System.out.println("One slice was eaten and now has " + this.slices + " slices");
  }

  public void pizzaFight(Pizza otherPizza) {
    int beginningSlices = otherPizza.getSlices();
    int totalSlices = beginningSlices - 2;
    otherPizza.setSlices(totalSlices);
    System.out.println(Arrays.toString(otherPizza.toppings) + " pizza just got wolloped, and now has "
        + otherPizza.getSlices() + " slices");
  }
}