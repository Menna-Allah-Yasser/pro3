package Service;

import database.StudentDB;
import java.util.Scanner;

public class StudentService {

    Scanner input = new Scanner(System.in);
    StudentDB sdb=new StudentDB();
    
    public void studentLogin() {
        System.out.print("Student Id : ");
        int studentId = input.nextInt();
        int result = sdb.searchById(studentId);
        if (result == 1) {
            System.out.println("Enter 1 : show your Courses");
            int in = input.nextInt();
            if (in == 1) {
                sdb.showCourses(studentId);
            }
        } else {
            System.out.println("Invalid Student Id");
        }
    }
}
