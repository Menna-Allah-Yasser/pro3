package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.Teacher;

public class TeacherDB {

     DB db = new DB();
     Connection connection;
     String query;
     PreparedStatement preparedStatement;
     ResultSet resultSet = null;
     Scanner input = new Scanner(System.in);
     
    public int searchById(int teacherId) {
        try {
            connection = db.connect();
            query = "select * from teacherdata where teacher_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
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

    public void insertTeacher(Teacher teacher) {
        try {
            connection = db.connect();
            query = "insert into teacherdata (Teacher_name , Email , Sex) values (?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, teacher.getTeacher_name());
            preparedStatement.setString(2, teacher.getEmail());
            preparedStatement.setString(3, teacher.getSex());
            preparedStatement.execute();
            System.out.println("Teacher inserted with ID : " + teacher.getTeacher_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void deleteTeacher(Teacher t){
        
        try {
                connection = db.connect();
                query = "delete from teacherdata where teacher_id=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, t.getTeacher_id());
                preparedStatement.execute();
                System.out.println("Delete Teacher with id " + t.getTeacher_id() + " done");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
    public void showCourses(int id){
        ResultSet resultSet = null;
        try {
            connection = db.connect();
            query = "select * from coursedata where teacher_id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Teacher with Id = "+ id + "  has not any Courses");
            }else{
            System.out.println("Teacher with Id = "+ id + "  has Courses : ");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("course_id") + "  "
                        + resultSet.getString("Course_name") );
            }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int findTeacherIdOfCourse(int courseId){
         ResultSet resultSet = null;
        try {
            connection = db.connect();
            query = "select teacher_id from coursedata where course_id=?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                System.out.println("Course with Id = "+ courseId + "  has not Founded");
            }else{
            while (resultSet.next()) {
                return resultSet.getInt("teacher_id");
            }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
    
    public void setDegree(int teacherId) {
        System.out.print("Enter Student Id : ");
        int studentId=input.nextInt();
        System.out.print("Enter Course Id : ");
        int courseId=input.nextInt();
        int result=findTeacherIdOfCourse(courseId);
        if(result ==teacherId)
        {
            System.out.print("Enter Degree : ");
            float degree=input.nextFloat();
            try{
            query="update Student_Courese set degree=? where Student_id=? and Course_id=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setFloat(1, degree);
            preparedStatement.setInt(2, studentId);
            preparedStatement.setInt(3, courseId);
            preparedStatement.execute();
                System.out.println("Degree Updated");
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            System.out.println("Sorry, this Course has another Teacher");
        }
    }
    
    
}
