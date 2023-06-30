import java.sql.*;

public class ConnectToDataBase {

    Statement stmt = null;
    ResultSet rs = null;
    Connection con = null;
    int customerId = 0;
    int balanceMoney = 0;

    public ConnectToDataBase(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank?characterEncoding=latin1", "root", "Strong");
            System.out.println("Congratulation Successfully Connected with DataBase!");
        }
        catch (Exception e){

        }
    }

    public boolean login(String name, String password) throws SQLException {

        stmt = con.createStatement();
        rs = stmt.executeQuery("select * from customer where CustomerName='"+name+"' and CustomerPassword='"+password+"'");
        if(rs.next()){
            customerId=rs.getInt("CustomerId");
            return true;
        }
        else{
            return false;
        }
    }

    public int getBalance(int id) throws SQLException{
        rs=stmt.executeQuery("select BalanceAmount from Account where CustomerId="+id+"");
        if(rs.next()){
            balanceMoney=rs.getInt("BalanceAmount");
            return balanceMoney;
        }
        else{
            return 0;
        }
    }

    public boolean withdrawMoney(int id, int amount) throws SQLException{
        if(amount > balanceMoney){
            return false;
        }
        else{
            stmt.executeUpdate("update Account set BalanceAmount="+(balanceMoney-amount)+" where customerId="+id);
            return true;
        }
    }

    public boolean depositMoney(int id, int amount) throws SQLException{
            int a = stmt.executeUpdate("update Account set BalanceAmount="+(balanceMoney+amount)+" where customerId="+id);

            if(a==1){
                return true;
            }
            else{
                return false;
            }
    }

}
