public class addition{
  public static int Myaddition(int a, int b){
    if (b == 0){
      return a;
    }
    else{
      return Myaddition(a,b-1)+1;
    }
  }
  public static void main(String[] args){
    int num1 = Integer.parseInt(args[0]);
    int num2 = Integer.parseInt(args[1]);
    int sum = Myaddition(num1 ,num2);
    System.out.println(sum);
  }
}