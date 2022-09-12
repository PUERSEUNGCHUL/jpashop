package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {

        // 새로 생성하는 객체일 경우는 신규등록
        if (item.getItems() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i").getResultList();
    }

    public List<Item> findByName(String name) {
        return em.createQuery("SELECT i FROM Item i WHERE i.name= :name")
                .setParameter("name", name)
                .getResultList();
    }

}
