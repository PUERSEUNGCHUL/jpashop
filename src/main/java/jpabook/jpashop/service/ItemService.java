package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    /**
     * 물품 등록
     * @param item
     * @return
     */
    public Long saveItem(Item item) {

        itemRepository.save(item);
        return item.getId();
    }

    /**
     * 전 물품 조회
     * @return
     */
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    /**
     * 물품 조회
     * @param itemId
     * @return
     */
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }

}
