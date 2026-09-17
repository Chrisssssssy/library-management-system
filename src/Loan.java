import java.time.LocalDate;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate borrowedDate;


    public Loan (Book book, Member member, LocalDate borrowedDate){
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook() {
        return book; }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate (){
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue(){
        LocalDate today = LocalDate.now();
         if (today.isAfter(getDueDate())) {
             return true;
        }
         return false;

    }



    @Override
    public String toString() {
        return book.getAuthor() + ": " + book.getTitle() + "; ISBN " + book.getIsbn() + "\n"
                + member + "\n"
                + "afleveringsfrist " + getDueDate() + "\n"
                + (isOverdue() ? " (overskredet)" : "");
    }
}
