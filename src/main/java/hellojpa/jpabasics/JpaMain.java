package hellojpa.jpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDateTime;

class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Team team = new Team();
            team.setCreatedBy("Minseok");
            entityManager.persist(team);

            Member member = new Member();
            member.setName("Member1");
            member.changeTeam(team);
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member.getId());
            System.out.println("findMember.getTeam().getClass() = " + findMember.getTeam().getClass());
            System.out.println("===================");
            System.out.println(
                    "findMember.getTeam().getCreatedBy() = " + findMember.getTeam().getCreatedBy());
            System.out.println("===================");

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
