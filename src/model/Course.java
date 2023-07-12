
package model;


public class Course {
    private int Course_id;
    private  String Name;
    private int Teacher_id;

    public Course() {
    }

    
    public Course(int Course_id, String Name, int Teacher_id) {
        this.Course_id = Course_id;
        this.Name = Name;
        this.Teacher_id = Teacher_id;
    }

    public int getCourse_id() {
        return Course_id;
    }

    public void setCourse_id(int Course_id) {
        this.Course_id = Course_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }

    @Override
    public String toString() {
        return "Course{" + "Course_id=" + Course_id + ", Name=" + Name + ", Teacher_id=" + Teacher_id + '}';
    }
    
    
}
