
package model;


public class Admin {
    private int Admin_id;
    private String Admin_password;

    public Admin() {
    }

    
    public Admin(int Admin_id, String Admin_password) {
        this.Admin_id = Admin_id;
        this.Admin_password = Admin_password;
    }

    public int getAdmin_id() {
        return Admin_id;
    }

    public void setAdmin_id(int Admin_id) {
        this.Admin_id = Admin_id;
    }

    public String getAdmin_password() {
        return Admin_password;
    }

    public void setAdmin_password(String Admin_password) {
        this.Admin_password = Admin_password;
    }

    @Override
    public String toString() {
        return "Admin{" + "Admin_id=" + Admin_id + ", Admin_password=" + Admin_password + '}';
    }
    
    
}
