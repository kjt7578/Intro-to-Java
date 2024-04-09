public class datatype{

    /*
 What is a data type?
    A. A set of values and a set of operations on those values.
 What is an abstract data type?
    A. A data type whose representation is hidden from the client
 What is a primitive data type?
    A. A set primitive values (int, double, char, ..) that are not abstract data           types.
 What is an object reference?
    A. A reference to the object but not the internal details of the object
 What is an immutable String?
    A. An object whose individual characters cannot be changed (String, Charge, Color...)
 What is a mutable object?
    A. An object whose internal representation can be altered (Turtle, Picture, Histogram...)
    */
  public static void printHello(){
    String s = new String ("Hello, World");
    StdOut.println( s.substring(0, 5) );
    String name = "Computer Science"; // String literal
    StdOut.println(name);
    name = new String ("CS"); //String object // make new seperated CS on HEAP
    StdOut.println(name);
    name = name + s;
    StdOut.println(name);
  }
  
  public static void main(String args[]){
    printHello();
  }

}