public class Test {
  public static void main (String[] args) {
    System.out.println("Please guess the number: ");
    int a = StdIn.readInt();
    int b = (int) (Math.random() * 100+1);
    System.out.println(b);

    while(b != a ){
      System.out.println("You are worng. Please try again");
      a = StdIn.readInt();
    }

    System.out.println("You are correct");
    
  }
}