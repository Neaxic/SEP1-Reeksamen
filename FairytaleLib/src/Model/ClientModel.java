package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;

public class ClientModel implements Client
{
    public static ArrayList<product> allProducts = new ArrayList();
    private ArrayList allProductsType = new ArrayList<>();
    private ArrayList allRenterType = new ArrayList<>();
    public static ArrayList<renter> allClients = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ArrayList search(String searchString){
        ArrayList<product> productArrayList = new ArrayList<>();
        //TODO: maybe contains + søge over brugere
        for (product allProduct : allProducts) {
            if (allProduct.getProductKind().toLowerCase().contains(searchString.toLowerCase()) ||allProduct.getProductKind().toUpperCase().contains(searchString.toUpperCase())
                    || allProduct.getTitle().toLowerCase().contains(searchString.toLowerCase()) || allProduct.getTitle().toUpperCase().contains(searchString.toUpperCase())
                    || allProduct.getAuthor().toUpperCase().contains(searchString.toUpperCase()) || allProduct.getAuthor().toLowerCase().contains(searchString.toLowerCase())
                    || allProduct.getIsbn().toLowerCase().contains(searchString.toLowerCase())  || allProduct.getIsbn().toUpperCase().contains(searchString.toUpperCase())
                    ||allProduct.getReleaseDate().toUpperCase().contains(searchString.toUpperCase()) ||  allProduct.getReleaseDate().toLowerCase().contains(searchString.toLowerCase()))
                    productArrayList.add(allProduct);

        }
        return productArrayList;
    }

    public ArrayList populateUsers(){

        users.add(new User("bob","123"));
        users.add(new User("bb","123"));
        users.add(new User("b","123"));

        return users;

    }





    public boolean checkLogin(String username,String password){
         populateUsers();

        for (User user : users) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)){
                return true;
            }

        }
        return false;

    }


    public int deleteProduct(product product){

        for (int i = 0; i <allProducts.size() ; i++) {
            allProducts.remove(product);
        }

        return 0;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
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

    public ArrayList<renter> getAllClients(){
        return allClients;
    }

    public ArrayList getAllRentedProducts(){
        if (allClients.isEmpty()){
        //TEST TODO:FJERN NÅR LÅNER VIRKER
        student andreas = new student("Andreas", "abc@gmail.com","student");
        //allProducts.get(0).setRenter(andreas, "10-02-2020");
        //System.out.println(allProducts.get(0).isRented());
        allClients.add(andreas);
        }
        ArrayList allRentedProducts = new ArrayList();
        for(product i : allProducts){
            if(i.isRented()){
                allRentedProducts.add(i);
            }
        }

        return allRentedProducts;

    }

    public ArrayList getAllAvaliableProducts(){
        //Vi laver dem her for at kunne skilne mellem de 3 typer imens vi har en allproducts som rod
        ArrayList allAvaliableProducts = new ArrayList();
        for(product i : allProducts){
            if(!i.isRented()){
                allAvaliableProducts.add(i);
            }
        }
        return allAvaliableProducts;
    }

    public static void setAllProducts(ArrayList gemteListe){
        allProducts = gemteListe;
    }

    @Override
    public Object clock() {
        Date myDate=new Date();
        support.firePropertyChange("time",null,myDate.getTime());

        return myDate;
    }

    public void createProduct(String title, String author, String isbn, String type,String releaseDate){
        allProducts.add(new product(type, title, author, isbn, releaseDate));
    }

    public void createRenter(String name,String email,String jobPosition){
        allClients.add(new lecture(name,email,jobPosition));
    }


    public boolean createUser(String username,String Password){

        if (users.add(new User(username,Password))){

            return true;
        } else {
            return false;
        }

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


    public ArrayList getAllRenterType(){
        if (allRenterType.isEmpty()){
            allRenterType.add("student");
            allRenterType.add("lecture");

        }
        return allRenterType;
    }


    public static void setUsers(ArrayList users) {
        ClientModel.users = users;
    }


    public static void setAllClients(ArrayList allClients) {
        ClientModel.allClients = allClients;
    }
}