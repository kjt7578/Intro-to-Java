import java.lang.String;

public class F22{
  public static void main(String[] args){
    System.out.println("count(“apple”); : " + count("apple"));
    System.out.println("count(“apple”); : " + count("banana"));
    System.out.println("count(“apple”); : " + count("kiwi"));

  }

  public static int count(String str){
    int ct = 0;
    for(int i = 0; i < str.length(); i++){
      if (str.charAt(i) == 'a'){
        ct++;
      }
    }
    return ct;
  }
}