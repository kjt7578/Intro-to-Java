public class pyramid{
  public static void main(String args[]){
    int num = Integer.parseInt(args[0]);
    for (int i = 1; i <= num; i++){
      for (int j = 1; j<=i; j++){
      System.out.print("*");
      }
      //for (int k = num; k <= 0; k--){
      //System.out.print("");
      //}
      System.out.println();
    }

    for (int i = 1; i <= num; i++){
      for (int j = (num-1); j>=i; j--){
      System.out.print("*");
      }
      //for (int k = 1; k <= num; k++){
      //System.out.print("");
      //}
      System.out.println();
    }


    
  }
}