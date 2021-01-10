package jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.setMemberType(MemberType.USER);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query ="select coalesce(m.username,'이름 없는 회원') from Member m ";
            String query2 ="select nullif(m.username,'관리자') from Member m ";
            List<String> result = em.createQuery(query2, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }

            tx.commit();

        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
            emf.close();
        }
    }

}
