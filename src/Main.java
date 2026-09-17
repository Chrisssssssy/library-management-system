void main() {
    Library library = new Library();
    Book book1 = new Book("Allan B. Downey",
            "Think Java",
            "9781492072508", 1);
    Book book2 = new Book("Rachel Cusk",
            "Omrids",
            "9788763851664", 2);
    Book book3 = new Book("Yuval Noah Harari",
            "Sapiens",
            "9780062316097", 3);

    /*IO.println(book1);
    IO.println(book2);
    IO.println(book3);

     */
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Peter Larsen", 333);

    /*
    IO.println(member1);
    IO.println(member2);
    */

    Loan loan1 = new Loan(book1, member1, LocalDate.of(2026, 9, 11));
    Loan loan2 = new Loan(book2, member2, LocalDate.of(2026, 7, 10));
    /*
    IO.println(loan1);
    IO.println(loan2);
    */
    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);
    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

//    library.printBooks();
//    library.printMembers();

    ArrayList<Book> books = new ArrayList<>();

    books.add (new Book("Homer", "Odyssey", "9780062316097", 5));
    books.add (new Book("Homer", "Iljad", "9780062316098", 6));



    Book odyssey = new Book("Homer", "Odyssey", "9780062316097", 5);
    Book iljad = new Book("Homer", "Iljad", "9780062316098", 6);
    boolean isOdysseyFound = books.contains(odyssey);
    boolean isIljadFound = books.contains(iljad);

    for (Book book : books) {
        library.addBook(book);
    }

//    IO.println(isOdysseyFound);
//    IO.println(isIljadFound);

//    Book foundBook = library.getBook(1);
//    IO.println(foundBook); // Allan B. Downey; Think java etc
//    Book notFoundBook = library.getBook(117);
//    IO.println(notFoundBook); // null
//
//    Member foundMember = library.getMember(111);
//    IO.println(foundMember); // Thorkild Hansen (Lån
//    Member notFoundMember = library.getMember(999);
//    IO.println(notFoundMember); // null

//    IO.println(library.loanBook(1, 111)); // true
//    IO.println(library.loanBook(9, 111)); // false
//    IO.println(library.loanBook(1, 999));

    library.loanBook(1, 111);
    ArrayList<Loan> loans = library.getLoans();
    IO.println(loans);
// [Allan B. Downey; Think Java; isbn 97814920725
// Thorkild Hansen (Lånernummer: 111),
// afleveringsfrist: 2026-08-26]
    IO.println(library.returnBook(1)); // true
    loans = library.getLoans();
    IO.println(loans); // []
    IO.println(library.returnBook(1)); // false
    IO.println(library.returnBook(117)); // false

    loans = library.findLoansByMemberId(222);
    IO.println(loans);

    ConsoleUI consoleUI = new ConsoleUI(library);

//    library.addMember(member1);
//    library.addMember(member2);
//
//    library.addBook(book1);
//    library.addBook(book2);
//    library.addBook(book3);


    consoleUI.run();
}



