package Model;

import Util.Subject;

import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.ArrayList;

public interface Client extends Subject
{
    ArrayList getAllClients();
    ArrayList getAllAvaliableProducts();


    Object clock();

    ArrayList searchRenters(String searchString);

    void createProduct(String title, String author, String isbn, String type, String releaseDate);

    ArrayList getAllProductsType();
    ArrayList search(String searchString);
    product deleteProduct(product product);

    void createUdlåntGenstand(RentedList rentedList) throws ParseException;
    void createReservedItem(RentedList rentedList);

    ArrayList<RentedList> getRentedList();
    ArrayList<RentedList> getReservedList();


    ArrayList getAllRenterType();

    void createRenter(String name,String email,String jobPosition);
    product addProduct(product product);


    RentedList deleteRenter(RentedList rentedList);
    RentedList deleteReserved(RentedList rentedList);

    ArrayList searchReserve(String searchString);



}
