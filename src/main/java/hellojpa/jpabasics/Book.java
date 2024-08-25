package hellojpa.jpabasics;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "B")
class Book extends Item {

    private String author;

    private String isbn;
}
