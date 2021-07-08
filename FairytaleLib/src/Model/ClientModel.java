package Model;

import java.util.ArrayList;

public class ClientModel implements Client
{
    public static ArrayList<product> allProducts = new ArrayList();
    private ArrayList allProductsType = new ArrayList();

    public ArrayList search(String searchString){
        ArrayList<product> productArrayList = new ArrayList<>();
        for (product allProduct : allProducts) {
            if (allProduct.getProductKind().equalsIgnoreCase(searchString)|| allProduct.getTitle().equalsIgnoreCase(searchString)|| allProduct.getAuthor().equalsIgnoreCase(searchString)|| allProduct.getIsbn().equalsIgnoreCase(searchString) ||allProduct.getReleaseDate().equalsIgnoreCase(searchString))
                productArrayList.add(allProduct);

        }
        return productArrayList;
    }

    public int deleteProduct(product product){

        for (int i = 0; i <allProducts.size() ; i++) {
            allProducts.remove(product);

        }

        return 0;
    }


    public void fillArrayDemoItems(){
        if (allProducts.isEmpty()){
            allProducts.add(new product("DVD", "Ronja Røvedatter", "Ester Erikson", "513BC", "02-03-1990"));
            allProducts.add(new product("BOG", "Bøjrne brødre", "Bente bent", "A231D", "13-06-2008"));
            allProducts.add(new product("BOG", "En klog bog", "Aristoteles", "BER31", "16-02-1940"));
            allProducts.add(new product("CD", "Takwondo banden", "Kent knudsen", "E9182", "21-11-2010"));
            allProducts.add(new product("ARTIKEL", "Noget reality show", "Tank top thomas", "BDE32", "5-07-1990"));
        }

    }

    public ArrayList getAllProducts(){
        //fillArrayDemoItems();
        return allProducts;
    }

    public static void setAllProducts(ArrayList gemteListe){
        allProducts = gemteListe;
    }

    public void createProduct(String title, String author, String isbn, String type,String releaseDate){
        allProducts.add(new product(type, title, author, isbn, releaseDate));

    }


    public ArrayList getAllProductsType(){
        if (allProductsType.isEmpty()){

            allProductsType.add("dvd");
            allProductsType.add("artikel");
            allProductsType.add("cd");
            allProductsType.add("BOG");

        }

        return allProductsType;
    }


}
