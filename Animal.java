public class Animal {
  private String name;
  private char sex;
  private String habitat;
  private int health;
  private int strength;

  // Method Overloading
  public Animal(String name, String habitat) {
    this.name = name;
    this.habitat = habitat;
  }

  // Constructor
  public Animal(String name, char sex, String habitat, int strength) {
    this.name = name;
    this.sex = sex;
    this.habitat = habitat;
    this.strength = strength;
    this.health = 100;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSex(char sex) {
    this.sex = sex;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public String getName() {
    return this.name;
  }

  public char getSex() {
    return this.sex;
  }

  public String getHabitat() {
    return this.habitat;
  }

  public int getHealth() {
    return this.health;
  }

  public int getStrength() {
    return this.strength;
  }

  // Attacks Another Animal
  public void battle(Animal target, String powerMove) {
    // Define logic of how animal attacks
    int damage;
    if (powerMove.equals("kick")) {
      damage = 3;
    } else if (powerMove.equals("scratch")) {
      damage = 5;
    } else if (powerMove.equals("roar")) {
      damage = 7;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // Multiply the strength x damage
    int effectiveDamage = this.strength * damage;

    // Reduce target's health by effectiveDamage
    int targetHealth = target.getHealth();
    target.setHealth(targetHealth -= effectiveDamage);

    // Print to the console what just happened using a formatted string
    System.out.printf("%s attacks %s for %d health\n", this.name, target.getName(), effectiveDamage);
    System.out.printf("%s health is now %d\n", target.getName(), target.getHealth());
  }

  // Overloaded Method
  public void battle(Animal target) {
    battle(target, "kick");
  }
}