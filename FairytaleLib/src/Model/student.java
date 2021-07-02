package Model;

//Kasper Falk Mikkelsen
public class student implements renter {

    String name, email;

    public student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getJobPostion() {
        return "student";
    }
}
