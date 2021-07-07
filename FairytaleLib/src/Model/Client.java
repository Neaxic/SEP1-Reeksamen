package Model;

import java.util.ArrayList;

public interface Client
{

    public ArrayList getAllProducts();
    public void createProduct(String title, String author, String isbn, String type,String releaseDate);
    ArrayList getAllProductsType();

}
