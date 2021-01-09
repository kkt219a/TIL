package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloA");
//            em.persist(member);

//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//            for(Member member: result){
//                System.out.println("member.getName() = " + member.getName());
//            }


//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("==before==");
//            em.persist(member);
//            //em.detach(member);// 영속성 컨텍스트 삭제
//            System.out.println("==After==");
//
//            //1차캐시 조회
//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());


//            //영속, 1차 확인
//            Member member1 = em.find(Member.class, 101L);
//            Member member2 = em.find(Member.class, 101L);
//            System.out.println("result: "+ (member1==member2));


//            //영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("===============");


//            //Update 테스트
//            Member member = em.find(Member.class, 150L);
//            member.setName("zzzzz");


//            //즉시 입력
//            Member member = new Member(200L,"member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("===============");


//            //준영속 만들기
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAA");
//            //em.detach(member);
//            //em.clear();
//            Member member2 = em.find(Member.class, 150L);
//            System.out.println("===============");


//            //ENUM TEST
//            Member member = new Member();
//            member.setUsername("C");
//            System.out.println("JpaMain.main");
//            member.setRoleType(RoleType.ADMIN);
//            em.persist(member);
//            System.out.println("JpaMain.main");


//            //단방향 연관관계
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team); //단방향 연관관계 설정, 참조 저장
//            em.persist(member);
//
//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());
//            //팀 바꿔주기
//            Team newTeam = em.find(Team.class,100L);
//            findMember.setTeam(newTeam);

//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }


//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//            Member member =new Member();
//            member.setUsername("member1");
//            team.getMembers().add(member);
//            member.setTeam(team);
//            em.persist(member);

//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//            em.persist(team);


//            Movie movie = new Movie();
//            movie.setDirector("Aaa");
//            movie.setActor("ssss");
//            movie.setName("ㅂㅏ람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);

//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//            Team team2 = new Team();
//            team.setName("team2");
//            em.persist(team2);
//
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setTeam(team);
//            em.persist(member);
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            member2.setTeam(team2);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();


//            Child child1 = new Child();
//            Child child2 = new Child();
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            //findParent.getChildList().remove(0);
//            em.remove(findParent);


            Address address = new Address("city", "street", "zipcode");

            Member member = new Member();
            member.setUsername("member1");
            member.setAddress(address);
            em.persist(member);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setAddress(newAddress);

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
