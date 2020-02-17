package scratches.boot.apm.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Rashidi Zin
 */
@DataMongoTest
class BookRepositoryTests {

    @Autowired
    private MongoTemplate template;

    @Autowired
    private BookRepository repository;

    @Test
    void findByAuthorName() {
        var author = new Author();
        var book = new Book();

        author.setName("Rudyard Kipling");

        book.setAuthor(author);
        book.setTitle("The Jungle Book");
        book.setIsbn("9781620280119");

        template.save(book);

        assertThat(repository.findByAuthorName("Rudyard Kipling")).hasSize(1);
    }
}
