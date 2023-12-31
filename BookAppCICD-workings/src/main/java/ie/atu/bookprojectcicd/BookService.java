package ie.atu.bookprojectcicd;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Book> allBooks(){
        List<Book> allBooks = bookRepository.findAll();
        List<Book> validBooks=allBooks.stream()
                .filter(book ->
                        book.getBookId() != null
                                && book.getAuthor() != null
                                && book.getTitle() != null
                                && book.getPoster() != null
                                && book.getId() != null
                                && book.getReviewLink() != null
                                && book.getReleaseDate() != null
                )
                .collect(Collectors.toList());
        return validBooks;
    }
    public Optional<Book> singleBook(String bookId){
        return bookRepository.findBookByBookId(bookId);
    }
}
