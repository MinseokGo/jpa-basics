package hellojpa.jpabasics;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "Albums")
@DiscriminatorValue(value = "A")
class Album extends Item {

    private String artist;
}
