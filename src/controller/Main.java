package controller;

import Service.AdminService;
import Service.StudentService;
import Service.TeacherService;
import java.util.Scanner;
import model.Admin;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int t = 1, memmber;

        AdminService adminService = new AdminService();
        Admin admin = new Admin();
        while (t >= 1) {

            System.out.println("Enter 1 : Admin");
            System.out.println("Enter 2 : Teacher");
            System.out.println("Enter 3 : Student");
            memmber = input.nextInt();
            if (memmber == 1) {
                int id;
                String pass;
                System.out.print("Enter Your Id : ");
                id = input.nextInt();
                System.out.print("Enter Your Password : ");
                pass = input.next();
                admin.setAdmin_id(id);
                admin.setAdmin_password(pass);
                adminService.avilableAdmin(admin);
            } else if (memmber == 2) {
                TeacherService ts=new TeacherService();
                ts.teacherLogin();
            } else if (memmber == 3) {
                StudentService ss=new StudentService();
                ss.studentLogin();
            } else {
                System.out.println("Unkown input");
            }

            System.out.println("Enter 0 : Exit");
            System.out.println("Enter 1 : Continue");
            t = input.nextInt();
        }
    }

}
