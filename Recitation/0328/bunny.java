public class bunny {

  public static int numofEars(int n){
    if (n == 0){
      return 0;
    }
    else if (n > 0){
      return numofEars(n-1) + 2;
    }
  }
  
  public static void main(String[] args) {

  int num = Integer.parseInt(args[0]);
  int ears = numofEars(num);
  System.out.println("ears: " + ears);
  }
}