public class Test{
 public static void main(String[] args) {

   String str1 = "I love going to Rutgers University!";
   int index = str1.indexOf("University");
   String str2 = str1.substring(0, index - 1);
   String str3 = str1.substring(index);
   String str4 = str3.toUpperCase() + " - " + str2.toLowerCase();
   int length = str4.length();
   String finalMessage = str4.substring(0, 1).toLowerCase() + str4.substring(1, length - 1) + str4.substring(length - 1).toUpperCase();
   System.out.println(finalMessage);
 }}