public class FirstProgram {
  public static void main(String[] args) {
    // Variables
    byte myByte = 100; // stores whole numbers from -128 to 127
    short myShort = 10000; // stores whole numbers from -32,768 to 32,767
    int myInt = 100000; // stores whole numbers from -2,147,483,648 to 2,147,583,647
    long myLong = 100000000; // stores whole numbers -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
    float myFloat = 3.14f; // Stores fractional numbers for 6 to 7 decimal digits
    double myDouble = 3.1432434; // Stores fractional numbers up to 15 decimal digits

    boolean myBool = true; // stores true or false values
    char myChar = 'c'; // stores a single character/letter of ASCII values

    // Wrapper Class
    Integer myInteger = 100000;
    Character myCharacter = 'c';

    // Strings
    String myString = "Java December 2020";
    System.out.println(myString.length());

    String bootcamp = "Java";
    String bootCamp = "December";
    String bootCAMP = "2020";

    System.out.println(bootcamp + bootCamp + bootCAMP);

    // Operators and Conditionals
    int myInt2 = 4;
    int myInt3 = 4;

    System.out.println(myInt2 == myInt2);

    String name = "Terra";
    String name2 = "Terra";

    System.out.println(name.equals(name2));

    int isOdd = 5;
    if (isOdd % 2 != 0) {
      System.out.println("Number is odd");
    } else {
      System.out.println("Number is even!");
    }

    // Loops
    // While Loop
    int i = 0;
    while (i < 5) {
      System.out.println(i);
      i++;
    }

    // For Loop
    for (int index = 0; index < 5; i++) {
      System.out.println(index);
    }

    // Methods
    myCountingApp();
  }

  public static void myCountingApp() {
    for (int counter = 0; counter < 50; counter++) {
      System.out.println(counter);
    }
  }

}