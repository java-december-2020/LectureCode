import java.util.ArrayList;

public class ZooTester {
  public static void main(String[] args) {
    // Mammal slasher = new Mammal("dog", 100);

    // ArrayList<Mammal> animals = new ArrayList<Mammal>();
    // animals.add(slasher);

    Gorilla magilla = new Gorilla();
    // animals.add(magilla);

    // for (Mammal m : animals) {
    // System.out.println(m.getSpecies());
    // }

    magilla.eatBanana();

    Barrel b = new Barrel();

    magilla.attack(b);
  }
}