public class BankAccount{
  //instance variables
  private String name;
  private int account_num;
  private doule balance;

  public Account(){
    String name;
    int account_num;
    double balance;
  }
//constructor 1
  //maybe we skip default constructors this time, because how can you make an account
  //at a bank, without providing any info?

  //what would the mimumum info be to make an account? (from the list of 3 above, pick 2 for now)
  //just for consistency, so that your solution works with the test code 
public BankAccount(String name, int account_num){ 
  this.name = name;
  this.account_num = account_num;
  this.balance = 0;
}

  //constructor 2
  //maybe this time the user gives us even MORE data than the minimum,
  //such as maybe,,, 
  //an initial deposit?
  //THINK – why is it okay to have two methods with the same name?
  //how will Java be able to differentiate which constructor version we want to use when we call one?
  //HINT: (what is different about the method signature?)
public BankAccount(String name,int account_num ,double balance){
  this.name = name;
  this.account_num = account_num;
  this.balance = balance;
}

  public boolean depositMoney(double amount){
    if(this.balance - amout < 0 ){
      System.out.println("Your current balance is negative.\nDeposit Canceled");
      return false;
    }
    else{
      this.balance += amount;
      System.out.println("You deposited $" + amount +"from the amount $" + (this.balance-amount) +"\nNow you have $" + this.balance);
      return true;
    }
}

  //similar to above
  //we use our method to limit access, and ensure
  //that changes to the object's data are valid
public boolean withdrawMoney(double amount){
  if(this.balance - amount < 0 ){
    return false;
  }
  else{
    this.balance -= amount;
    System.out.println("You withdrawed $" + amount +"from the amount $" + (this.balance+amount) +"\nNow you have $" + this.balance);
    return true;
  }
}

  //withdraw money returns true if the account had enough to be withdrawn
  //only if we can withdraw the money should we deposit it in the other account, right?
  public boolean transferMoney(BankAccount to, double amount){
  //hmm, how do we call a method from THIS instance of Bank account?
      //is there a method we can use to check if we can withdraw the money, and withdraw it if we can?
      //is there a method we can use to deposit the money in the other account?
      //how do we call a method on object "to"?
}

  //what if we want to know the account number of the account?
  //the data should be private so they need to call a method to get it
  public String getAccountNumber(){ 
  return this.account_num;
}
  //same thing here, but for balance!
public double getBalance(){ 
  return this.balance;
}

  @Override
  //^ think – why do we need this?
public String toString(){
  return "Name: " + this.name + "\nAccount Number: " + this.account_num + "\nCurrent Balance: $" + this.balance;
}

  //when are two bank accounts equal? what piece of data is unique to each bank account?
public boolean equals(BankAccount other){
  if(String.this.account_num.equals(String.other.account_num)){
    return true;
  }
  return false;
}

  //test your class here!
  public static void main(String [] args){
      BankAccount rushd = new BankAccount(rushd,1234);
      BankAccount jhonny = new BankAccount(jhonny,1111);
      BankAccount secondConstructorExample = new BankAccount(JT,1000,500000.00);

      //example of how our conditional logic handles incorrect usage
      if(rushd.depositMoney(-99)){
          System.out.println("successfully deposited negative money :/");
      }
      else System.out.println("unable to deposit.");
      //feel free to test the other methods as well!

      //
      System.out.println(rushd); //pre deposit. notice how toString is called automatically?
      rushd.depositMoney(999);
      System.out.println(rushd);//post deposit, should have mo money now

  }
}