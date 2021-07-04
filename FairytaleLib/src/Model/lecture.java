package Model;

import java.io.Serializable;

//Kasper Falk Mikkelsen
public class lecture implements renter, Serializable {

    String name, email;

    public lecture(String name, String email) {
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
        return "lecture";
    }

}
