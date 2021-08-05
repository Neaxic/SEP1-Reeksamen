package Model;

import java.io.Serializable;

public class product implements Serializable {

    private renter Renter;
    private renter reserver;
    private String productKind;
    private String title, author, isbn;
    private String releaseDate;

    public product(String productKind, String title, String author, String isbn, String releaseDate) {
        this.productKind = productKind;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.releaseDate = releaseDate;

    }

    public product(String productKind, String title) {
        this.productKind = productKind;
        this.title = title;
    }

    public boolean isRented() {
        if(Renter == null){
            if (Renter.getStatus() == null) {
                return false;
            } else {
                return true;
            }
        } else return true;
    }

    public boolean isReserved() {
        if (reserver.getStatus() == null) {
            return false;
        } else return true;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getProductKind() {
        return productKind;
    }

    public void setProductKind(String productKind) {
        this.productKind = productKind;
    }

    @Override
    public String toString() {
        return "product{" +
                "Renter=" + Renter +
                ", reserver=" + reserver +
                ", productKind='" + productKind + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
