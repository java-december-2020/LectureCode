public class Gorilla extends Mammal {
  public Gorilla() {
    // Directly Call From The Mammal Constructor
    super("Gorilla", 500);
  }

  public void eatBanana() {
    System.out.printf("I am a %s eating a banana\n", this.species);
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }
}