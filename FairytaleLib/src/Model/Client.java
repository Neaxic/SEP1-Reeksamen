package Model;

import java.util.ArrayList;

public interface Client
{
    public ArrayList getAllProducts();
    public ArrayList getAllClients();
    public ArrayList getAllRentedProducts();
    public ArrayList getAllAvaliableProducts();

    static void setAllProducts(ArrayList gemteListe) {}

    void createProduct(String title, String author, String isbn, String type,String releaseDate);

    ArrayList getAllProductsType();
    ArrayList search(String searchString);
    int deleteProduct(product product);

}
