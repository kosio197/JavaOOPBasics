package bg.softuni.bookshop;

public class Book {

    protected String author;
    protected String title;
    protected double price;

    public Book(String author, String title, double price) {
        setAuthor(author);
        setTitle(title);
        setPrice(price);
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        if (author.split(" ").length > 1) {
            char c = author.split(" ")[1].charAt(0);
            if (c > 47 && c < 58) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }

        this.title = title;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }

        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
        .append(System.lineSeparator())
        .append("Title: ").append(this.getTitle())
        .append(System.lineSeparator())
        .append("Author: ").append(this.getAuthor())
        .append(System.lineSeparator())
        .append("Price: ").append(this.getPrice())
        .append(System.lineSeparator());
        return sb.toString();
    }
}
