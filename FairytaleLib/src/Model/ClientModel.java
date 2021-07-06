package Model;

import java.util.ArrayList;

public class ClientModel implements Client
{
    private ArrayList allProducts = new ArrayList();

    public void fillArrayDemoItems(){
        allProducts.add(new product("DVD", "Ronja Røvedatter", "Bente bent", "513BC", "02/03/1990"));
        allProducts.add(new product("BOG", "Ronja Røvedatter", "Bente bent", "513BC", "02/03/1990"));
        allProducts.add(new product("CD", "Ronja Røvedatter", "Bente bent", "513BC", "02/03/1990"));
        allProducts.add(new product("ARTIKEL", "Ronja Røvedatter", "Bente bent", "513BC", "02/03/1990"));
    }


    public ArrayList getAllProducts(){
        fillArrayDemoItems();
        return allProducts;
    }





}
