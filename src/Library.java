import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();


    public void addBook(Book book) {books.add(book);
        }

    public void addMember(Member member) {members.add(member);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList getMembers (){
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public void printBooks (){
        for (Book books : books){
            IO.println(books);
        }
    }

    public void printMembers(){
        for (Member members : members){
            IO.println(members);
        }
    }

    public Book getBook (int bookId){
        for (Book book : books){
            if (bookId == book.getId()) {
                return book;
            }
        }
        return null;
    }

    public Member getMember (int memberId){
        for (Member member : members){
            if (memberId == member.memberNumber) {
                return member;
            }
        }
        return null;
    }

    public boolean loanBook (int bookId, int memberId) {
        if (getBook(bookId) == null || getMember(memberId) == null || !getBook(bookId).isAvailable) {
            return false;
        }
        Loan loan = new Loan((getBook(bookId)), (getMember(getMember(memberId).memberNumber)), LocalDate.now());
        loans.add(loan);
        getBook(bookId).isAvailable = false;
        return true;
    }

    public boolean returnBook (int bookId) {
        for (Loan loan : loans) {
            if (loan.book().getId() == bookId) {
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> result = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.member().memberNumber == memberId) {
                result.add(loan);
            }
        }
        return result;
    }
}



