package Model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaveInfo {

    private Renters renters;
    private product product;

    private static SaveInfo instance;
    private static Lock lock = new ReentrantLock();

    private SaveInfo() {}

    public static SaveInfo getInstance() {
        // if one doesn't already exist, create it
        if (instance == null) {
            synchronized (lock) {
                if (instance == null)
                    instance = new SaveInfo();
            }
        }
        return instance;
    }

    public Renters getRenters() {
        return renters;
    }

    public void setRenters(Renters renters) {
        this.renters = renters;
    }

    public Model.product getProduct() {
        return product;
    }

    public void setProduct(Model.product product) {
        this.product = product;
    }
    @Override
    public String toString() {
        return "SaveInfo{" +
                "renters=" + renters +
                ", product=" + product +
                '}';
    }
}
