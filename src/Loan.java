import java.time.LocalDate;

public record Loan(Book book, Member member, LocalDate borrowedDate) {

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);

    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return book.getAuthor() + ": " + book.getTitle() + "; ISBN " + book.getIsbn() + "\n"
                + member + "\n"
                + "afleveringsfrist " + getDueDate() + "\n"
                + (isOverdue() ? " (overskredet)" : "");
    }
}



