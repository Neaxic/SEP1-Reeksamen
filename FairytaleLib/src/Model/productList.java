package Model;

//Kasper Falk Mikkelsen
import java.util.ArrayList;

public class productList {
    private ArrayList<product> arr = new ArrayList<>();

    public productList() {
        //READ FROM FILE HERE
    }

    public void addProduct(String productKind,String title,String author,String isbn) {
        product p = new product(productKind,title,author,isbn);
        arr.add(p);
    }

    public ArrayList<product> getProducts() {
        return arr;
    }

    public product getProductFromIsbn(String isbn) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getIsbn() == isbn) {
                return arr.get(i);
            }
        }
        //SHOULD THROW SOME EXCEPTION INSTEAD
        return null;
    }
}
