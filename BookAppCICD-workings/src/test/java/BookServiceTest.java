import ie.atu.bookprojectcicd.Book;
import ie.atu.bookprojectcicd.BookRepository;
import ie.atu.bookprojectcicd.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSingleBook() {

        String bookId = "yourBookId";
        Book mockBook = new Book(/* initialize a book */);
        when(bookRepository.findBookByBookId(bookId)).thenReturn(Optional.of(mockBook));

        Optional<Book> result = bookService.singleBook(bookId);

        assertTrue(result.isPresent());
        assertEquals(mockBook, result.get());

    }
}