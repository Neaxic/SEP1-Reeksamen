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



    public static void saveRenter(ArrayList Rlist) throws IOException {

        String filename = "Renter.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(Rlist);
        outputStream.close();

        System.out.println("Saved file to: " + file.getAbsolutePath());

    }


    public static void saveRentedList(ArrayList Rlist) throws IOException {

        String filename = "RenterList.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(Rlist);
        outputStream.close();

        System.out.println("Saved file to: " + file.getAbsolutePath());

    }


    public static void saveReservedList(ArrayList Rlist) throws IOException {

        String filename = "ReservedList.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        outputStream.writeObject(Rlist);
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




    public static ArrayList loadRenter() throws IOException, ClassNotFoundException {
        String filename = "Renter.bin";
        File file = new File(filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList renterList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("RenterList have been loaded");

            return renterList;
        } catch (FileNotFoundException e) {
            System.out.println("Intet gemt i systmet");
        }

        ArrayList tom = new ArrayList();
        return tom;
    }


    public static ArrayList loadRenterList() throws IOException, ClassNotFoundException {
        String filename = "RenterList.bin";
        File file = new File(filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList renterList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("RenterList have been loaded");

            return renterList;
        } catch (FileNotFoundException e) {
            System.out.println("Intet gemt i systmet");
        }

        ArrayList tom = new ArrayList();
        return tom;
    }




    public static ArrayList loadReservedList() throws IOException, ClassNotFoundException {
        String filename = "ReservedList.bin";
        File file = new File(filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList ReservedList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("ReservedList have been loaded");

            return ReservedList;
        } catch (FileNotFoundException e) {
            System.out.println("Intet gemt i systmet");
        }

        ArrayList tom = new ArrayList();
        return tom;
    }





}
