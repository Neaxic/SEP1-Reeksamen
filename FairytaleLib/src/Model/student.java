package Model;

import java.io.Serializable;

//Kasper Falk Mikkelsen
public class student implements renter, Serializable {

    String name, email;
    String jobPostion;

    public student(String name, String email) {
        this.name = name;
        this.email = email;
        jobPostion = "student";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    public String getJobPostion() {
        return jobPostion;
    }
}
