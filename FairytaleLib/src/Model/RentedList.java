package Model;

import java.io.Serializable;
import java.util.Date;

public class RentedList implements Serializable {

    private product product;
    private Renters renters;
    //private Model.Date date;
    private Date låneDato;
    private Date returDato;

    public RentedList(Model.product product, Renters renters, Date låneDato, Date returDato) {
        this.product = product;
        this.renters = renters;
        this.låneDato = låneDato;
        this.returDato = returDato;
    }

    //product
    public Model.product getProduct() {
        return product;
    }

    public String getProductKind() { return product.getProductKind();}
    public String getTitle() { return product.getTitle(); }

    //renter

    public Renters getRenters() {
        return renters;
    }

    public String getName() { return renters.getName() ;}
    public String getEmail() { return renters.getEmail() ;}
    public String getStatus() { return renters.getStatus() ;}


    //date

    public Date getLåneDato() {
        return låneDato;
    }

    public Date getReturDato() {
        return returDato;
    }

    @Override
    public String toString() {
        return "RentedList{" +
                "product=" + product +
                ", renters=" + renters +
                ", date=" + låneDato +
                '}';
    }
}