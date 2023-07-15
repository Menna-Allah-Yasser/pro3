package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;

public class StudentDB {

     DB db = new DB();
        Connection connection;
        String query;
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        
   public  void insertStudent(Student s) {
        try {
            connection = db.connect();
            query = "insert into studentdata (fname , lname , email , sex) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, s.getFName());
            preparedStatement.setString(2, s.getLName());
            preparedStatement.setString(3, s.getEmail());
            preparedStatement.setString(4, s.getSex());
            preparedStatement.execute();
            System.out.println("Student inserted with Id : "+ s.getStudent_id());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
   public int searchById(int id) {
        try {
            connection = db.connect();
            query = "select * from studentdata where student_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
   
   public void deleteStudent( Student s){
       
        try {
                connection = db.connect();
                query = "delete from studentdata where student_id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, s.getStudent_id());
                preparedStatement.execute();
                System.out.println("Delete student with id " + s.getStudent_id() + " done");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
   }
   
   public void showCourses(int studentId) {
        ResultSet resultSet = null;
        try {
            query = "select s.course_id , c.Course_name , s.degree\n"
                    + "from Student_Courese s\n"
                    + "join coursedata c\n"
                    + "on s.course_id = c.course_id\n"
                    + "where s.student_id =?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Syudent with Id = "+ studentId + "  has not enrolled Courses");
            }else{
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("course_id") + "  "
                        + resultSet.getString("Course_name") + "  " + resultSet.getFloat("degree"));
            }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
