package database;

import Service.AdminService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Admin;
import model.Course;
import model.Student;
import model.Teacher;

public class AdminDB {

    Scanner input = new Scanner(System.in);
    DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    AdminService as=new AdminService();
    
   /* public void insertAdmin(Admin admin){
        try {
            connection = db.connect();
            query = "insert into admin values (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, admin.getAdmin_id());
            preparedStatement.setString(2, admin.getAdmin_password());
            preparedStatement.execute();
            System.out.println("Admin " + admin.getAdmin_id() + " Added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    public void adminLogin(Admin admin) {
        try {
            connection = db.connect();
            ResultSet resultSet;
            query = "select * from Admin where Admin_id=? and Admin_password=? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, admin.getAdmin_id());
            preparedStatement.setString(2, admin.getAdmin_password());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Enter 1 : Add");
                System.out.println("Enter 2 : Delete");
                int x = input.nextInt();
                if (x == 1) {
                    as.add();
                } else if (x == 2) {
                     as.delete();
                } else {
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
