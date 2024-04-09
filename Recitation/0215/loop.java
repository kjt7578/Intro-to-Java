public class loop {
  public static void main(String args[]){
    int num = Integer.parseInt(args[0]);
    for ( int i = 1; i <= num; i++ ){
      if(i==num)
        System.out.print(i);
      else
      System.out.print(i + ",");
    }
    // fiuerst , 29
  }
}