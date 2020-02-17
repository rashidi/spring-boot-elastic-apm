package scratches.boot.apm.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Rashidi Zin
 */
@Data
@Document
public class Book {

    @Id
    private String id;

    private String title;

    private Author author;

    private String isbn;

}
