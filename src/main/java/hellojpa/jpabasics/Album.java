package hellojpa.jpabasics;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
class Album extends Item {

    private String artist;
}
