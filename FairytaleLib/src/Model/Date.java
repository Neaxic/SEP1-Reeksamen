package Model;

import java.io.Serializable;

public class Date implements Serializable {

    private java.util.Date startdate;
    private java.util.Date returndate;

    public Date(java.util.Date startdate, java.util.Date returndate) {
        this.startdate = startdate;
        this.returndate = returndate;
    }

    public java.util.Date getStartdate() {
        return startdate;
    }

    public java.util.Date getReturndate() {
        return returndate;
    }

    @Override
    public String toString() {
        return "date{" +
                "startdate=" + startdate +
                ", returndate=" + returndate +
                '}';
    }
}
