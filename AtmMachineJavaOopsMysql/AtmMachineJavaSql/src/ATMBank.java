import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class ATMBank {
    Scanner sc = new Scanner(System.in);
    ConnectToDataBase ctD;

    public ATMBank() throws SQLException {
        ctD = new ConnectToDataBase();
    }
    public void loginCustomer()  throws SQLException{
        System.out.print("Enter Customer Name : ");
        String name = sc.nextLine();
        System.out.println();
        System.out.print("Enter Customer Password : ");
        String password = sc.next();
        boolean flag = ctD.login(name, password);
        if(flag){
            System.out.println("Login is Successful !");
            displayMenu();
        }else{
            System.out.println("Login Failed, Try Again");
            loginCustomer();
        }
    }

    public void displayMenu() throws SQLException{
        System.out.println("--------------------------------------------------");
        System.out.println("1.Check Balance");
        System.out.println("2.Withdraw Money");
        System.out.println("3.Deposit Money");
        System.out.println("4.Log Out");
        System.out.println("Select Your Choice");
        int choice = sc.nextInt();
        switch (choice){
            case 1: check_Balance();
            break;
            case 2: withdraw_Money();
            break;
            case 3: deposit_Money();
            break;
            case 4: log_Out();
            break;
            default:
                System.out.println("Please Select Valid Choice");
                //displayMenu();
        }
    }

    public void check_Balance() throws SQLException{
        int balance = ctD.getBalance(ctD.customerId);
        System.out.println("Your Total Balance in Your Account is : "+balance);
        displayMenu();
    }
    public void withdraw_Money() throws SQLException{
        System.out.println("Enter Amount You Want To Withdraw : ");
        int amount = sc.nextInt();
        boolean flag = ctD.withdrawMoney(ctD.customerId, amount);
        if(flag){
            System.out.println("Take Your Money : "+amount);
            displayMenu();
        }else{
            System.out.println("Not Enough Money In Your Account");
        }
    }
    public void deposit_Money() throws SQLException{
        System.out.println("Enter Amount You Want To Deposit : ");
        int amount = sc.nextInt();
        boolean flag = ctD.depositMoney(ctD.customerId, amount);
        if(flag){
            System.out.println("Successfully Deposited Money : "+amount);
            displayMenu();
        }
    }
    public void log_Out(){
        System.out.println("Good Bye !");
        // System.exit(0);
    }

    public static void main(String[] args) throws SQLException{
        ATMBank atm = new ATMBank();
        atm.loginCustomer();

    }
}
