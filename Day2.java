import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  public static void main(String[] args) {
    String name = "Brandi";
    String name2 = "Brandi";

    String name3 = new String("Matthew");
    String name4 = new String("Matthew");

    System.out.println(name3.equals(name4));

    // Arrays

    String[] people = { "christopher", "Matt", "Terra", "Hanna", "Jasmine", "Brandi", "Anias" };

    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }

    // Superclass Method to Display Array.
    System.out.println(Arrays.toString(numbers));

    // Collections
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("String");
    stringList.add("String1");
    stringList.add("String2");

    System.out.println(stringList);

    // Enhanced For Loop / forEach
    for (String s : stringList) {
      System.out.println(s);
    }

    // HashMaps
    HashMap<String, String> ourHobbies = new HashMap<String, String>();
    ourHobbies.put("Matthew", "Photography");
    ourHobbies.put("Terra", "Gardening");
    ourHobbies.put("Hanna", "Cooking");
    ourHobbies.put("Christopher", "Video Games");
    ourHobbies.put("Brandi", "");
    ourHobbies.put("Anias", "Drawing");
    ourHobbies.put("Platt", "WebFun");

    System.out.println(ourHobbies.get("Matthew"));

    // Iterate Over Keys
    for (String hobbyName : ourHobbies.keySet()) {
      System.out.println(hobbyName);
    }

    // Iterate Over Values
    for (String hobbyValue : ourHobbies.values()) {
      System.out.println(hobbyValue);
    }

    // Iterate key values from hashMap
    for (HashMap.Entry<String, String> nameHobby : ourHobbies.entrySet()) {
      System.out.println("Key: " + nameHobby.getKey() + ", Value " + nameHobby.getValue());
    }

    // Methods
    System.out.println(maxArrayValue(numbers));
    sayHello("Terra");

    // Errors
    // Compilation Error
    // int[] myAwesomeInts = new String[];
    // Runtime Error

  }

  public static void sayHello(String name) {
    System.out.println("Hello" + name);
  }

  public static int maxArrayValue(int[] nums) {
    // establish a variable that holds the current max value
    // loop through the array
    // compare each array position to what the current max value is
    // return current max value
    int currMaxValue = nums[0];
    for (int i = 0; i <= nums.length; i++) {
      try {
        if (currMaxValue < nums[i]) {
          currMaxValue = nums[i];
        }
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    return currMaxValue;
  }
}