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


            String query0 = "select concat('a','b') From Member m"; //ab 출력
            String query1 = "select substring(m.username,2,3) From Member m";
            String query2 = "select locate('de','abcdef') From Member m"; // 4출력
            String query3 = "select size(t.members) From Team t"; // 1출력

            String query = "select function('group_concat',m.username) From Member m"; // 1출력



            List<String> result = em.createQuery(query, String.class)
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
