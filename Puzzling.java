import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzling {
  public static void main(String[] args) {
    ArrayList<Character> alphabet = new ArrayList<Character>();
    Random r = new Random();

    for (char ch = 'a'; ch <= 'z'; ++ch) {
      alphabet.add(ch);
    }

    System.out.println(alphabet);
    Collections.shuffle(alphabet);
    System.out.println(alphabet);
    System.out.println(alphabet.get(25));
    int randomNum = r.nextInt(25);
    System.out.println(alphabet.get(randomNum));
  }
}