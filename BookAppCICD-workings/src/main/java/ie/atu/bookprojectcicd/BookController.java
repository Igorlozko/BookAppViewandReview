package ie.atu.bookprojectcicd;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static reactor.core.publisher.Mono.when;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/getAllBooks")
    public ResponseEntity<Map<String, List<Book>>> getAllBooks(){
        List<Book> books =bookService.allBooks();
        Map<String, List<Book>> response = new HashMap<>();
        response.put("books", books);
        return new ResponseEntity<>(response, HttpStatus.OK);
        //return new ResponseEntity<List<Meeting>>(meetingService.allMeetings(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Optional<Book>> getSingleBook(@PathVariable String bookId){
        return new ResponseEntity<Optional<Book>>(bookService.singleBook(bookId),HttpStatus.OK);
    }


}
