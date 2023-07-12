package Service;

//import database.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Admin;

public class AdminService {

    Scanner input = new Scanner(System.in);
    Connection connection;
    String query;
    PreparedStatement preparedStatement;

    public AdminService(){
        
    }
    public AdminService(int id, String pass) {
        
        DB db = new DB();
        try {
            connection =  db.connect();
            query = "insert into admin values (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pass);
            preparedStatement.execute();
            System.out.println("Admin " + id + " Added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    
    
        

    public void avilableAdmin(int id, String pass) {
        try {
            ResultSet resultSet;
            query = "select * from Admin where Admin_id=? and Admin_password=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Enter 1 : Add");
                System.out.println("Enter 2 : Delete");
                int x = input.nextInt();
                if (x == 1) {
                   // add();
                } else if(x==2){
                    //delete();
                }else{
                    System.out.println("Invalid Number");
                }
            } else {
                System.out.println("Incorrect Password , try again");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
}
