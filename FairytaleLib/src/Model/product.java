package Model;

import java.io.Serializable;

//Kasper Falk Mikkelsen
public class product implements Serializable {
    renter Renter = new notRented();
    renter reserver = new notRented();
    String productKind;
    String title, author, isbn;


    product(String productKind, String title, String author, String isbn) {
        this.productKind = productKind;
        this.title = title;
        this.author = author;
        this.isbn = isbn;

    }

    public void setRenter(String renterType, String renterName, String renterMail) {
        if (reserver.getJobPostion() == null || reserver.getEmail() == renterMail) {
            if (renterType == "student") {
                Renter = new student(renterName, renterMail);
            } else if (renterType == "lecture") {
                Renter = new lecture(renterName, renterMail);
            } else {
                System.out.println("Renter type not valid");
                Renter = new notRented();
            }
        } else {
            System.out.println("Object reserved to :" + reserver.getName());
        }

    }

    public boolean isRented() {
        if (Renter.getJobPostion() == null) {
            return false;
        } else return true;
    }

    public void removeRenter() {
        Renter = new notRented();
    }

    public void setReserver(String renterType, String renterName, String renterMail) {
        if (renterType == "student") {
            reserver = new student(renterName, renterMail);
        } else if (renterType == "lecture") {
            reserver = new lecture(renterName, renterMail);
        } else {
            //SHOULD THROW AN EXCEPTION INSTEAD
            System.out.println("reserver type not valid");
            reserver = new notRented();
        }
    }

    public boolean isReserved() {
        if (reserver.getJobPostion() == null) {
            return false;
        } else return true;
    }

    public void removeReserver() {
        reserver = new notRented();
    }


    //Help functions
    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getProductKind() {
        return productKind;
    }

    public String getTitle() {
        return title;
    }

    public String getRenterName() {
        return Renter.getName();
    }

    public String getRenterEmail() {
        return Renter.getEmail();
    }

    public String getRenterJobPostion() {
        return Renter.getJobPostion();
    }

    public String getReserverName() {
        return reserver.getName();
    }

    public String getReserverEmail() {
        return reserver.getEmail();
    }

    public String getReserverJobPostion() {
        return reserver.getJobPostion();
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }

    public void setRenter(renter renter) {
        Renter = renter;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}