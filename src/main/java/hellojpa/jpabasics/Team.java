package hellojpa.jpabasics;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
class Team extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public List<Member> getMembers() {
        return members;
    }
}
