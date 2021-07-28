package Model;

import java.io.Serializable;

//Kasper Falk Mikkelsen
public class Renters implements renter, Serializable {

    private String name, email;
    private String status;

    public Renters(String name, String email, String status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Renters{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
