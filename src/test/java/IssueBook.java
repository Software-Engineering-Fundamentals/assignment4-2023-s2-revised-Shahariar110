
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
// import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

/**
 *  Implement and test {Programme.addStudent } that respects the considtion given the assignment specification
 * NOTE: You are expected to verify that the constraints to borrow a new book from a library
 *
 * Each test criteria must be in an independent test method .
 *
 * Initialize the test object with "setting" method.
 */
public class IssueBook {

    private LibraryCard libraryCard;
    private Book availableHighDemandBook;
    private Book availableLowDemandBook;
    private Book alreadyBorrowedBook;
    private Book unavailableBook;
    private Book fineBook;

    @BeforeEach
    void init() {
        
        // Create a LibraryCard for testing
        Student student = new Student("Syed Shahariar Hossain", 3961200);
        Date issueDate = new Date(System.currentTimeMillis());
        // 60 days from the issue date
        Date expiryDate = new Date(issueDate.getTime() + 60L * 24 * 60 * 60 * 1000);
        libraryCard = new LibraryCard(student, issueDate, expiryDate, 1);


        // Create books for testing
        availableHighDemandBook = new Book(1, "Book in high demand", 1);
        availableLowDemandBook = new Book(2, "Book in low demand", 0);
        alreadyBorrowedBook = new Book(3, "Already Borrowed Book", 0);
        unavailableBook = new Book(4, "Unavailable Book", 1);
        fineBook = new Book(5, "Fine Book", 0);

        // Set the status of books and add books to the library card
        availableHighDemandBook.setStatus(true);
        availableLowDemandBook.setStatus(true);
        alreadyBorrowedBook.setStatus(true);
        unavailableBook.setStatus(false);
        fineBook.setStatus(true);

      
        // A book has been added intentionally to test "throwsException_whenAlreadyBorrowed()"
        libraryCard.getBooks().add(alreadyBorrowedBook);

    }


    @Test
    @DisplayName("Returns true during book issuance for high demand book")
    void True_WhenHighDemandAvailableBookisIssued() throws  IllegalBookIssueException{
        
        assertTrue(libraryCard.issueBook(availableHighDemandBook));
        assertTrue(libraryCard.getBooks().contains(availableHighDemandBook));
    }

    @Test
    @DisplayName("Returns true during book issuance for low demand book")
    void True_WhenLowDemandAvailableBookisIssued() throws  IllegalBookIssueException{

        assertTrue(libraryCard.issueBook(availableLowDemandBook));
        assertTrue(libraryCard.getBooks().contains(availableLowDemandBook));
    }

    @Test
    @DisplayName("Throws exception during book issuance due to already borrowed book")
    void throwsException_whenAlreadyBorrowed() throws  IllegalBookIssueException{
        assertThrows(IllegalBookIssueException.class,() -> libraryCard.issueBook(alreadyBorrowedBook));

    }


    @Test
    @DisplayName("Returns false during book issuance due to exceeding book limit")
    void False_WhenExceedingBookLimit() throws  IllegalBookIssueException{

        libraryCard.getBooks().add(new Book(1, "New Book One", 0));
        libraryCard.getBooks().add(new Book(2, "New Book Two", 0));
        libraryCard.getBooks().add(new Book(3, "New Book Three", 0));
        libraryCard.getBooks().add(new Book(4, "New Book Four", 0));

    
        assertFalse(libraryCard.issueBook(new Book(6, "New Book", 0)));
    }

    @Test
    @DisplayName("returns false during book issuance due to expired library card")
    void False__WhenLibraryCardIsExpired() throws  IllegalBookIssueException{
        // Set expiry date in the future
        libraryCard.setExpiryDate(new Date(System.currentTimeMillis() - 1000)); 
        assertFalse(libraryCard.issueBook(availableHighDemandBook));
        assertFalse(libraryCard.issueBook(availableLowDemandBook));
    }

    @Test
    @DisplayName("Returns false during book issuance due to unavailable book")
    void False__WhenBookIsUnavailable() throws  IllegalBookIssueException{

        assertFalse(libraryCard.issueBook(unavailableBook));
    }

    @Test
    @DisplayName("Returns false during book issuance due to pending fine")
    void False__WhenPendingFineExists() throws  IllegalBookIssueException{
        // A fine has been set
        libraryCard.setFine(19.0); 
        assertFalse(libraryCard.issueBook(fineBook));
    }

}
