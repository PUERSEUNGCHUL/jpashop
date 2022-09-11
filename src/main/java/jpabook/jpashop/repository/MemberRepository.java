package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public Long save(Member m) {

        em.persist(m);

        return m.getId();
    }

    public Member findMember(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {

        return em.createQuery("SELECT M FROM Member M", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {

        return em.createQuery("SELECT M FROM Member M WHERE M.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
