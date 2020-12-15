import java.util.ArrayList;

public class Calculator2 {
  double results;
  ArrayList<Character> operators = new ArrayList<Character>();
  ArrayList<Double> nums = new ArrayList<Double>();

  public Calculator2() {

  }

  // if the number passed in has a decimal, add it to the arraylist
  public void performOperation(double num) {
    nums.add((double) num);
  }

  // Overloaded method, if the number is an int typecase it
  public void performOperation(int num) {
    nums.add((double) num);
  }

  public void performOperation(Character ch){
    // if the operand is not an equals, add it to the operators arraylist
    if(ch != '='){
      operators.add(ch);
    }

    // If it is an equals sign, we can do the calculations
    Double numsInProgress = nums.get(0);
    // Loop Through the operators
    for(int i = 0; i < operators.size(); i++){
      // switch(operators.get(i)){
      //   case '+': numsInProgress = numsInProgress + nums.get(i); break;
      //   case '-': numsInProgress = numsInProgress - nums.get(i); break;
      //   case '/': numsInProgress = numsInProgress / nums.get(i); break;
      //   case '*': numsInProgress = numsInProgress * nums.get(i); break;
      //   default: System.out.println("Operator not recognized"); break;
        if(operators.get(i) == '+'){
          numsInProgress = numsInProgress + nums.get(i);
           break;
        } else if(operators.get(i) == '-'){
          numsInProgress = numsInProgress - nums.get(i);
           break;
        } else if(operators.get(i) == '*'){
          numsInProgress = numsInProgress * nums.get(i); break;
        } else if(operators.get(i) == '/'){
          numsInProgress = numsInProgress / nums.get(i); break;
        } else {
          System.out.println("Operator not recognized");
           break;
        }
      }
    }this.results=numsInProgress;

  }

  public void getResults() {
    System.out.println(results);
  }
}