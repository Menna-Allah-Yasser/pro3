
package Controller;


public class Teacher {
    private int Teacher_id;
    private String Teacher_name;
    private String Email;
    private String Sex;

    public Teacher(int Teacher_id, String Teacher_name, String Email, String Sex) {
        this.Teacher_id = Teacher_id;
        this.Teacher_name = Teacher_name;
        this.Email = Email;
        this.Sex = Sex;
    }

    public int getTeacher_id() {
        return Teacher_id;
    }

    public void setTeacher_id(int Teacher_id) {
        this.Teacher_id = Teacher_id;
    }

    public String getTeacher_name() {
        return Teacher_name;
    }

    public void setTeacher_name(String Teacher_name) {
        this.Teacher_name = Teacher_name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    @Override
    public String toString() {
        return "Teacher{" + "Teacher_id=" + Teacher_id + ", Teacher_name=" + Teacher_name + ", Email=" + Email + ", Sex=" + Sex + '}';
    }
    
    
            
}
