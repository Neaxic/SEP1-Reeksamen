package Util;

import java.io.*;

import java.util.ArrayList;

public class FileHandler {

    public static void saveEverything(ArrayList Products, ArrayList RentedProducts, ArrayList RservedProducts, ArrayList Renters) throws IOException {

        String filename = "Database.bin";
        File file = new File(filename);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        ArrayList samlet = new ArrayList();
        samlet.add(Products);
        samlet.add(RentedProducts);
        samlet.add(RservedProducts);
        samlet.add(Renters);

        outputStream.writeObject(samlet);
        outputStream.close();

        System.out.println("Gemt alt til filen: " + file.getAbsolutePath());
    }

    public static ArrayList loadEverything() throws IOException, ClassNotFoundException {
        String filename = "Database.bin";
        File file = new File(filename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            ArrayList productList = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("Alt er blevet indlæst");

            return productList;
        } catch (FileNotFoundException e) {
            System.out.println("Intet gemt i systmet");
        }

        ArrayList tom = new ArrayList();
        return tom;
    }
}
