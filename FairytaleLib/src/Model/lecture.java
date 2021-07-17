package Model;

import java.io.Serializable;

//Kasper Falk Mikkelsen
public class lecture implements renter, Serializable {

    String name, email;
    String jobPostion;

    public lecture(String name, String email,String jobPostion) {
        this.name = name;
        this.email = email;
        this.jobPostion = jobPostion;
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
