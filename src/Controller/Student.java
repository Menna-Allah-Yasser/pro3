package Controller;

public class Student {

    private int Student_id;
    private String FName;
    private String LName;
    private String Email;
    private String sex;

    public Student(int Student_id, String FName, String LName, String Email, String sex) {
        this.Student_id = Student_id;
        this.FName = FName;
        this.LName = LName;
        this.Email = Email;
        this.sex = sex;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int Student_id) {
        this.Student_id = Student_id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
