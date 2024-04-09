
public class Game{
  public static void main(String[] args) {

    double total = args.length;
    double sum = 0;
    int i = 0;
    while ( i < total ) {
      sum += Double.parseDouble(args[i]);
      i++;
    }
    System.out.println(sum / total);


      
  }
}