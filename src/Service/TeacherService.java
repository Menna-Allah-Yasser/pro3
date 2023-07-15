package Service;

import database.TeacherDB;
import java.util.Scanner;

public class TeacherService {

    TeacherDB tdb = new TeacherDB();
    Scanner input=new Scanner(System.in);
    
    public void teacherLogin() {
        System.out.print("Teacher Id : ");
        int teacherId = input.nextInt();
        int r = tdb.searchById(teacherId);
        if (r == 1) {
            System.out.println("Enter 1 : Show Courses");
            System.out.println("Enter 2 : set degree to student");
            int y = input.nextInt();
            TeacherDB tdb=new TeacherDB();
            if (y == 1) {
                tdb.showCourses(teacherId);
            } else {
                tdb.setDegree(teacherId);
            }
        } else {
            System.out.println("Teacher not found");
        }
    }

}
