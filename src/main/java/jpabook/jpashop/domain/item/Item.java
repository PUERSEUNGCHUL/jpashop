package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dType")
@Getter
@NoArgsConstructor
public abstract class Item {

    protected Item(Long id, int price, String name, int stockQuantity, List<Category> items) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.items = items;
    }

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private int price;
    private String name;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> items = new ArrayList<Category>();

    /**
     * 재고 수량 증가
     * @param quantity
     */
    public void addStock(int quantity) {

        this.stockQuantity += quantity;
    }

    /**
     * 재고 수량 감소
     * @param quantity
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;

        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }

        this.stockQuantity = restStock;
    }
}
