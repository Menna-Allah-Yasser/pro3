package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Course;
import model.Student;

public class StudentCoursesDB {

    DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;

    public void addStudentToCourse(Student s, Course c, java.sql.Date sqlDate, int price) {
        try {
            connection = db.connect();
            query = "insert into Student_Courese(Student_id , Course_id , Start_Date ,  Price) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, s.getStudent_id());
            preparedStatement.setInt(2, c.getCourse_id());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setInt(4, price);
            preparedStatement.execute();
            System.out.println("Student added to Course ");
        } catch (SQLException ex) {
            StudentDB student=new StudentDB();
            System.out.println(ex.getMessage());
            int resultStudent = student.searchById(s.getStudent_id());
            if (resultStudent == 0) {
                System.out.println("Student Id not Found");
            }
            CourseDB course = new CourseDB();
            int resultCourse = course.searchById(c.getCourse_id());
            if (resultCourse == 0) {
                System.out.println("Course Id not Found");
            }
        }
    }

    
}
