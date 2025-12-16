package librarylist;

import java.util.ArrayList;

public final class BookRental {
    private BookRental() {
        super();
    }

    /**
    *
    */
    private static ArrayList<Book> library = new ArrayList<Book>();

    /**
     * @return current library
     */
    public static ArrayList<Book> getLibrary() {
        return library;
    }

    static void addBooks(final Book book) {
        library.add(book);
    }

    static void rentBooks(final Book book) {
        book.rent();
    }

    /**
    *
    */
    public static void clearLibrary() {
        library.clear();
    }

    /**
     * @return return library size
     */
    public static int getLibrarySize() {
        return library.size();
    }
    /**
     *
     */
    public static void displayBooks() {
        for (Book book : getLibrary()) {
            System.out.print(book.getTitle() + " " + book.getAuthor() + " "
                    + book.getYearPublished());
        }
    }
    /**
     *
     */
    public static void displayRentedBooks() {
        for (Book book : getLibrary()) {
            if (book.isRented()) {
                System.out.println(book.getTitle() + " " + book.getAuthor() + " "
                        + book.getYearPublished());
            }
        }
    }

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final int lotr = 1954;
        final int mocking = 1960;
        final int tipping = 2000;
        final int steel = 1997;
        addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien",
                lotr));
        addBooks(new FictionBook("To Kill a Mockingbird", "Harper Lee",
                mocking));
        addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell",
                tipping));
        addBooks(new NonFictionBook("Guns, Germs, and Steel", "Jared Diamond",
                steel));
        rentBooks(library.get(0));
        rentBooks(library.get(1));
    }

}
