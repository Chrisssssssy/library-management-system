import java.util.Objects;

public class Book {
    final String author;
    final String title;
    final String isbn;
    final int id;
    boolean isAvailable;

    public Book (String author, String title, String isbn, int id){
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.isAvailable = true;

    }

    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public int getId() { return id; }



    public String toString () {
        return String.format("%s by %s; ISBN %s; (%d) [%s]",
                title, author, isbn, id, isAvailable ? "available" : "on loan");

    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn) && Objects.equals(id, book.id);
    }





    public void loan(){
        if (isAvailable){
            isAvailable = false;
            IO.println("Book has been borrowed");
        }
        else {
            IO.println("Book is not available");
        }
    }

    public void returnBook(){
        if (!isAvailable){
            isAvailable = true;
            IO.println("Book has been return");
        }
        else {
            IO.println("Book is already in library");
        }
    }

}