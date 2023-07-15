package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Course;

public class CourseDB {

    DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;
    TeacherDB tdb=new TeacherDB();
    
    public void insertCourse(Course c) {
        try {
            connection = db.connect();
            query = "insert into coursedata (Course_name , Teacher_id) values (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getName());
            preparedStatement.setInt(2, c.getTeacher_id());
            preparedStatement.execute();
            System.out.println("Course inserted with Id : "+c.getCourse_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            int result = tdb.searchById(c.getTeacher_id());
            if (result == 0) {
                System.out.println("Teacher Id not Found");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int searchById(int id) {
        try {
            connection = db.connect();
            query = "select * from coursedata where course_id = ?";
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
    
    public void deleteCourse(Course c){
        try {
                connection = db.connect();
                query = "delete from coursedata where course_id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, c.getCourse_id());
                preparedStatement.execute();
                System.out.println("Delete course with id " + c.getCourse_id() + " done");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
}

