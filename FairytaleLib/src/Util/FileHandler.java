package Util;
import Model.productList;

import java.io.*;

public class FileHandler {


    public static void saveProductList(productList Plist) throws IOException {

        String filename = "Product.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);


        outputStream.writeObject(Plist);
        outputStream.close();

        System.out.println("Saved file to: " + file.getAbsolutePath());

    }



    public static productList loadProductList() throws IOException, ClassNotFoundException {
        String filename = "Product.bin";
        File file = new File(filename);

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        productList productList = (Model.productList) objectInputStream.readObject();
        objectInputStream.close();


        System.out.println("ProductList have been loaded");

        return productList;


    }












}
