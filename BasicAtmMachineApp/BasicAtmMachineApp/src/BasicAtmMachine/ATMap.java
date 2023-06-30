package BasicAtmMachine;

import java.util.HashMap;
import java.util.Scanner;

class  ATMap{
    // int balance;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();
    ATMap(){
        System.out.println("*************************************************");
        System.out.println("--------- WELCOME TO ATM MACHINE ----------");
    }


    public void checkAnotherAccount(){
        System.out.println("*************************************************");
        System.out.println("ENTER YOUR PIN NUMBER");
        int pin = sc.nextInt();

        if(map.containsKey(pin)==true){
            Data obj = map.get(pin);
            menu(obj);
        }
        else{
            System.out.println("*************************************************");
            System.out.println("PLEASE CREATE YOUR ACCOUNT");
            System.out.println("SET YOUR PIN CODE");
            int pinSet = sc.nextInt();
            Data obj = new Data();
            map.put(pinSet, obj);
            menu(obj);

        }

    }
    public void menu(Data obj){
        System.out.println("*************************************************");
        System.out.println("PLEASE CHOOSE ANY NUMBER");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSIT MONEY");
        System.out.println("3. WITHDRAW MONEY");
        System.out.println("4. CHECK ANOTHER ACCOUNT");
        System.out.println("5. EXIT");

        int x = sc.nextInt();

        if(x==1){
            checkBalance(obj);
            menu(obj);
        }
        else if(x==2){
            depositMoney(obj);
            menu(obj);
        }
        else if(x==3){
            withdrawMoney(obj);
            menu(obj);
        }
        else if(x==4){
            checkAnotherAccount();
            menu(obj);
        }
        else if(x==5){
            System.out.println("---------------THANK YOU!!------------");
        }
        else{
            System.out.println("--------PLEASE ENTER VALID NUMBER-------");
            menu(obj);
        }
    }

    public void checkBalance(Data obj){
        System.out.println("YOUR BALANCE IS : "+obj.balance);
    }
    public void depositMoney(Data obj){
        System.out.println("ENTER YOUR AMOUNT : ");
        float amount = sc.nextFloat();

        obj.balance += amount;

        System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");

    }

    public void withdrawMoney(Data obj){
        System.out.println("ENTER YOUR AMOUNT : ");
        float amount = sc.nextFloat();

        if(amount<=obj.balance){
            obj.balance -= amount;
            System.out.println("AMOUNT WITHDRAWAL SUCCESSFULLY");
        }
        else{
            System.out.println("Withdrawal Failed Due To Not Sufficient Balance");
        }

    }

}
