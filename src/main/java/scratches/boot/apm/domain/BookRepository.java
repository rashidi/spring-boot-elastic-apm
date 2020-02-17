package scratches.boot.apm.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Rashidi Zin
 */
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findByAuthorName(String name);

}
