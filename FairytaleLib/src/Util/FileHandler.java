package Util;

import Model.productList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class FileHandler {


    public static void saveProductList(ArrayList Plist) throws IOException {

        String filename = "Product2.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(Plist);
        outputStream.close();

        System.out.println("Saved file to: " + file.getAbsolutePath());

    }


    public static ArrayList loadProductList() throws IOException, ClassNotFoundException {
        String filename = "Product2.bin";
        File file = new File(filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList productList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("ProductList have been loaded");

            return productList;
        } catch (FileNotFoundException e) {
            System.out.println("Intet gemt i systmet");
        }

        ArrayList tom = new ArrayList();
        return tom;
    }


}
