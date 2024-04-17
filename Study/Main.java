public class Main{
  public static void main(String[] args){
    int n = StdIn.readInt();
    String [] STRs = new String[n];
    for(int i = 0; i < n; i++){
      STRs[i] = StdIn.readString();
      System.out.println(STRs[i]);
    } 
  }
}