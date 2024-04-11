public class CandyTester{

    public static void main(String[] args){
        //public Candy(String name, String color, boolean isSour, double price, int pieces)
        String kitketname = readString();
        Candy kitkat = new Candy("KitKat", "brown", false, 1.50, 4);
        System.out.println(kitkat.toString()); //print out details of kitkat
        kitkat.eatCandy(2); //eat 2 pieces of kitkat
        System.out.println(kitkat); //print out updated details of kitkat
        kitkat.eatCandy(3);
        System.out.println(kitkat);

        Candy jollyrancher = new Candy("Jolly Rancher", "blue", true, 5.00, 20);
        System.out.println(jollyrancher); //print out details of jolly rancher
        jollyrancher.flavor(); //print out flavor of jollyrancher

        Candy reeses = new Candy("Reese's", "brown", false, 3.00, 30);
        Candy sourPatch = new Candy("Sour Patch", "red", true, 2.50, 15);
        Candy MnM = new Candy("MnM's", "brown", false, 4.80, 40);

        //Candy[] candies = new Candy[5]; //creating an array of 5 Candy objects
        Candy[] candies = {kitkat, jollyrancher,reeses,sourPatch,MnM};
        for (int i = 0; i < candies.length; i++){
           if (candies[i].getPrice() < 3.0)
                System.out.println(candies[i]);
        }
    }

}