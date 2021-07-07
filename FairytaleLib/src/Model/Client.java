package Model;

import java.util.ArrayList;

public interface Client
{

    ArrayList getAllProducts();
    void createProduct(String title, String author, String isbn, String type,String releaseDate);
    ArrayList getAllProductsType();
    ArrayList search(String searchString);

}
