package Model;

import java.util.ArrayList;

public interface Client
{
    public ArrayList getAllProducts();
    static void setAllProducts(ArrayList gemteListe) {}
    void createProduct(String title, String author, String isbn, String type,String releaseDate);
    ArrayList getAllProductsType();
    ArrayList search(String searchString);

}
