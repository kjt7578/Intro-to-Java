
public class Between{
  public static void main(String[] args) {

    int first = Integer.parseInt(args[0]);
    int second = Integer.parseInt(args[1]);
    if ( first > second ) {
      int temp = second;
      second = first;
      first = temp;
    }
    int i = 0;
    int num = 0;
    while ( i < args.length)
      {
       num = Integer.parseInt(args[i]);
        if ( num > first && num < second )
          System.out.print(num + " ");
        i++;
      }

}
}