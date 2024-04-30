import java.lang.String;
//.length 는 array의 길이 반환
//.length()는 String의 길이 반환

public class MyString{
  public static void main(String[] args){
    System.out.println("String reference sheet");
    String apple = "apple";
    String banana = "banana";
    String kiwi = "kiwi";
    String test1 = apple;
    String test2 = new String("apple");
    String [] fruit = {apple, banana, kiwi};

    System.out.println("int length()");
    for(int i = 0; i < fruit.length; i++){
      int length = fruit[i].length();
      System.out.println("Length of " + fruit[i] + ": " + length);
    }System.out.println();

    System.out.println("char chatAt(int i)");
    for(int i = 0; i < fruit.length; i++){
      for(int j = 0; j < fruit[i].length(); j++){
        if(fruit[i].charAt(j) == 'a'){  // Should be ' ' because its comeparing with char
          System.out.println(fruit[i] + " contains 'a' on " + j + "th");
        }
      }
    }System.out.println();

    System.out.println("String substring(int i, int j)");
    for(int i = 0; i < fruit.length; i++){
      String line = fruit[i].substring(0, 4);
      System.out.println(fruit[i] + " contains " + line + " on (0,4]");
    }System.out.println();

    System.out.println("boolean contains(String sub)");
    for(int i = 0; i < fruit.length; i++){
      Boolean contain = fruit[i].contains("a");
      System.out.println(fruit[i] + " contains 'a'? : " + contain);
    }System.out.println();
    
    System.out.println("boolean startsWith(String pre)");
    for(int i = 0; i < fruit.length; i++){
      Boolean contain = fruit[i].startsWith("a");
      System.out.println(fruit[i] + " startsWith 'a'? : " + contain);
    }System.out.println();

    System.out.println("boolean endsWith(String post)");
    for(int i = 0; i < fruit.length; i++){
      Boolean contain = fruit[i].endsWith("a");
      System.out.println(fruit[i] + " endsWith 'a'? : " + contain);
    }System.out.println();

    System.out.println("int indexOf(String p)");
    for(int i = 0; i < fruit.length; i++){
      int firstOccur = fruit[i].indexOf("a");
      System.out.println(fruit[i] + " contains 'a' on " + firstOccur + "th");
    }System.out.println();

    System.out.println("int indexOf(String p, int i)");
    for(int i = 0; i < fruit.length; i++){
      int firstOccur = fruit[i].indexOf("a",1);
      System.out.println(fruit[i] + " contains 'a' on " + firstOccur + "th after 1th char");
    }System.out.println();

    System.out.println("String concat(String t)");
    for(int i = 0; i < fruit.length; i++){
      System.out.println(fruit[i].concat(" added String"));
    }System.out.println();

    System.out.println("int compareTo(String t) ");
    //0 if same, -1 if t is located grammerically foward than fruit. +1 " but later 
    for(int i = 0; i < fruit.length; i++){
      if(fruit[i].compareTo("apple") == 0){
      System.out.println(fruit[i] + "is apple!");
      }
    }System.out.println();

    System.out.println("String replaceAll(String a, String b)");
    for(int i = 0; i < fruit.length; i++){
      fruit[i].replaceAll("a","b");
      System.out.println("All a is converted to b : " + fruit[i]);
    }System.out.println();

    System.out.println("String[] split(String delim) ");
    String str = "apple, orange, banana, kiwi";
    String [] sp_str = str.split(", ");
    for(int i = 0; i < sp_str.length; i++){
      System.out.println(sp_str[i]);
    }System.out.println();

    System.out.println("boolean equals(Object t)");
    for(int i = 0; i < fruit.length; i++){
      if(fruit[i].equals(fruit[i])){
      System.out.println(fruit[i] + "is apple!");
      }
    }System.out.println();
    

    
  }
}