
public class AbstractGorilla extends AbtractMammal {

  public void sleep() {
    System.out.println("zzzZzZZZzzz");
  }

  public void eat() {
    System.out.println("the gorilla just ate a banana");
  }

  public static void main(String[] args) {
    AbstractGorilla g = new AbstractGorilla();
    g.makeSound();
    g.eat();
  }
}