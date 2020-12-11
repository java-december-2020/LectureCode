public class AnimalController {
  public static void main(String[] args) {
    Animal lion = new Animal("Leo", 'M', "rolling plains", 12);
    Animal bear = new Animal("Barry", 'M', "Alaska", 12);
    Animal goat = new Animal("Billy", "field");
    lion.battle(bear, "scratch");
    bear.battle(lion, "kick");

    goat.battle(lion);
  }

  public static int addTwoNumbers(int num1, int num2) {
    return num1 + num2;
  }

  public static double addTwoNumbers(double num1, double num2) {
    return num1 + num2;
  }
}