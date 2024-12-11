package hellojpa.jpql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Member member = new Member();
            member.setName("member");
            member.setAge(10);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            List<MemberDTO> result = entityManager.createQuery(
                    "SELECT new hellojpa.jpql.MemberDTO(m.name, m.age) FROM member_jpql m", MemberDTO.class
            ).getResultList();

            MemberDTO memberDTO = result.get(0);
            System.out.println("memberDTO.getName() = " + memberDTO.getName());
            System.out.println("memberDTO.getAge() = " + memberDTO.getAge());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
