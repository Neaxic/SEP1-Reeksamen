package View.registreNewRenter;

import Model.Client;

import java.util.ArrayList;

public class registerNewRenterViewModel
{
  private Client client;

  private ArrayList<String> allItemList;

  public registerNewRenterViewModel(Client client) {
    this.client = client;
    allItemList = new ArrayList<>();
  }

  public void populate(){
    this.allItemList.add("ITEM");

  }

  public void getAvaliable(){

  }
}
