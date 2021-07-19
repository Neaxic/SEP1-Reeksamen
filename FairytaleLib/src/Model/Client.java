package Model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Client
{
    public ArrayList getAllProducts();
    public ArrayList getAllClients();
    public ArrayList getAllRentedProducts();
    public ArrayList getAllAvaliableProducts();


    static void setAllProducts(ArrayList gemteListe) {}
    Object clock();

    void createProduct(String title, String author, String isbn, String type,String releaseDate);

    ArrayList getAllProductsType();
    ArrayList search(String searchString);
    int deleteProduct(product product);



    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);

   ArrayList populateUsers();

    boolean checkLogin(String username,String password);

    boolean createUser(String username,String Password);
    ArrayList getAllRenterType();

    void createRenter(String name,String email,String jobPosition);
    product addProduct(product product);


}
