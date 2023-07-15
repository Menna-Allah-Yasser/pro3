package Service;

import database.AdminDB;
import database.CourseDB;
import database.DB;
import database.StudentCoursesDB;
import database.StudentDB;
import database.TeacherDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Admin;
import model.Course;
import model.Student;
import model.Teacher;

public class AdminService {

    Scanner input = new Scanner(System.in);
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    DB db = new DB();
    AdminDB adb = new AdminDB();
    CourseDB cdb = new CourseDB();
    StudentDB sdb = new StudentDB();
    TeacherDB tdb = new TeacherDB();
    StudentCoursesDB scdb = new StudentCoursesDB();

    public AdminService() {

    }

    public AdminService(int id, String pass) {

        try {
            connection = db.connect();
            query = "insert into admin values (?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, pass);
            preparedStatement.execute();
            System.out.println("Admin " + id + " Added");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void avilableAdmin(Admin admin) {
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
                    add();
                } else if (x == 2) {
                     delete();
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

    public void add() {
        System.out.println("Enter 1 : Add Teacher");
        System.out.println("Enter 2 : Add Student");
        System.out.println("Enter 3 : Add Course");
        System.out.println("Enter 4 : Add Student to Course");
        int x = input.nextInt();
        if (x == 1) {  // insert Teacher
            Teacher t = new Teacher();

            System.out.print("Enter Teacher name : ");
            t.setTeacher_name(input.next());
            System.out.print("Enter Teacher Email : ");
            t.setEmail(input.next());
            System.out.print("Enter Teacher Sex : ");
            t.setSex(input.next());
            tdb.insertTeacher(t);

        } else if (x == 2) { // insert Student
            Student s = new Student();
            System.out.print("Enter Student First name : ");
            s.setFName(input.next());
            System.out.print("Enter Student Last name : ");
            s.setLName(input.next());
            System.out.print("Enter Student Email : ");
            s.setEmail(input.next());
            System.out.print("Enter Student Sex : ");
            s.setSex(input.next());
            sdb.insertStudent(s);

        } else if (x == 3) { // insert Course
            Course c = new Course();

            System.out.print("Enter Course name : ");
            c.setName(input.next());
            System.out.print("Enter Teacher id : ");
            c.setTeacher_id(input.nextInt());
            cdb.insertCourse(c);

        } else if (x == 4) {// Add student to Course
            Student s = new Student();
            Course c = new Course();

            System.out.print("Enter Student id : ");
            s.setStudent_id(input.nextInt());
            System.out.print("Enter Course id : ");
            c.setCourse_id(input.nextInt());
            System.out.print("Enter Start Date : ");
            String sDate = input.next();
            java.util.Date myDate = new java.util.Date(sDate);
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            System.out.print("Enter Price : ");
            int price = input.nextInt();
            scdb.addStudentToCourse(s, c, sqlDate, price);

        } else {
            System.out.println("Invalid Number");
        }

    }

    public void delete() {
        System.out.println("Enter 1 : Delete Teacher ");
        System.out.println("Enter 2 : Delete Student ");
        System.out.println("Enter 3 : Delete Course ");
        int x = input.nextInt();

        if (x == 1) { // delete Teacher
            Teacher t = new Teacher();

            System.out.print("Enter Teacher id : ");
            t.setTeacher_id(input.nextInt());
            tdb.deleteTeacher(t);
        } else if (x == 2) { // delete student
            Student s = new Student();

            System.out.print("Enter Student id : ");
            s.setStudent_id(input.nextInt());
            sdb.deleteStudent(s);
        } else if (x == 3) { // delete Course
            Course c = new Course();

            System.out.print("Enter Course id : ");
            c.setCourse_id(input.nextInt());
             cdb.deleteCourse(c);
        }
    }
}
