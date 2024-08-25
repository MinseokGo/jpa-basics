package hellojpa.jpabasics;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Books")
@DiscriminatorValue(value = "B")
class Book extends Item {

    private String author;

    private String isbn;
}
