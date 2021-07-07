package Model;

import java.util.ArrayList;

public class ClientModel implements Client
{
    private ArrayList allProducts = new ArrayList();
    private ArrayList allProductsType = new ArrayList();




    public void fillArrayDemoItems(){
        allProducts.add(new product("DVD", "Ronja Røvedatter", "Ester Erikson", "513BC", "02-03-1990"));
        allProducts.add(new product("BOG", "Bøjrne brødre", "Bente bent", "A231D", "13-06-2008"));
        allProducts.add(new product("BOG", "En klog bog", "Aristoteles", "BER31", "16-02-1940"));
        allProducts.add(new product("CD", "Takwondo banden", "Kent knudsen", "E9182", "21-11-2010"));
        allProducts.add(new product("ARTIKEL", "Noget reality show", "Tank top thomas", "BDE32", "5-07-1990"));

    }

    public ArrayList getAllProducts(){
        fillArrayDemoItems();
        return allProducts;
    }

    public void createProduct(String title, String author, String isbn, String type,String releaseDate){
        allProducts.add(new product(type, title, author, isbn, releaseDate));

    }


    public ArrayList getAllProductsType(){
        allProductsType.add("dvd");
        allProductsType.add("artikel");
        allProductsType.add("cd");
        allProductsType.add("BOG");

        return allProductsType;
    }


}
