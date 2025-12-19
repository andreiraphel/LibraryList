package librarylist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        // Clear the library before each test
       BookRental.clearLibrary();
       
       outContent.reset();
       System.setOut(new PrintStream(outContent));

    }

    @Test
    void testBookCreation_WhenAddingABookAndCheckIfBookIsNotNullAndBooksAreNotYetRentedByDefault_ReturnsFalse() {
        Book newBook = new Book("The Notebook", "Nicholas Sparks", 1996);
        assertEquals(false, newBook.isRented(), () -> "The Notebook is not rented");
    }

    @Test
    void testRentMethod_WhenAddingABookAndWhenTheRentMethodIsCalledTheStatusOfTheBookWillThenBeChangedToRented_ReturnsTrue() {
        Book newBook = new Book("The Notebook", "Nicholas Sparks", 1996);
        newBook.rent();
        assertEquals(true, newBook.isRented(), () -> "The Notebook is rented");
    }
    @Test
    void testAddBooksMethod_WhenAddingAFictionBookAndANonFictionBookAndCheckIfTheSizeOfTheListCorrespondsToTheNumberOfBooksAdded_ReturnsTwo() {
        BookRental.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        BookRental.addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
        assertEquals(BookRental.getLibrarySize(), 2, () -> "The number of books is 2");
    }
    @Test
    void testRentBooksWithValidIndex_WhenAddingAFictionBookAndANonFictionBookAndRentOnlyOneOfTheBooks_ReturnsTrue() {
        BookRental.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        BookRental.addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
        ArrayList<Book> library = BookRental.getLibrary();
        BookRental.rentBooks(library.get(0));
        Book rentedBook = library.get(0);
        
        assertEquals(true, rentedBook.isRented(), () -> "LOTR is rented");
    }
    @Test
    void testRentBooksWithInvalidIndex_WhenAddingABookAndRentAnInvalidIndex_ThrowsIndexOutOfBoundsException() {
        BookRental.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        ArrayList<Book> library = BookRental.getLibrary();
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BookRental.rentBooks(library.get(1));
        }, "Accessing index 1 should throw an IndexOutOfBoundsException.");
    }
    
    @Test
    void testDisplayBooks_WhenAddingAFictionBookAndANonFictionBook_ReturnsTrue() {
        BookRental.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        BookRental.addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
        BookRental.displayBooks();
        
        String expectedOutput = "The Lord of the Rings J.R.R. Tolkien 1954" + "\n" + "The Tipping Point M. Gladwell 2000";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void testDisplayRentedBooks_WhenAddingAFictionBookAndANonFictionBook_ReturnsTrue() {
        BookRental.addBooks(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        BookRental.addBooks(new NonFictionBook("The Tipping Point", "M. Gladwell", 2000));
        ArrayList<Book> library = BookRental.getLibrary();
        library.get(0).rent();
        BookRental.displayRentedBooks();
        
        String expectedOutput = "\nBooks Rented: \nThe Lord of the Rings J.R.R. Tolkien 1954" + "\n";
        String actualOutput = outContent.toString();

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void testMain_WhenMainArgumentIsNull_VoidReturnsNothing() {
        BookRental.main(null);
    }
}
