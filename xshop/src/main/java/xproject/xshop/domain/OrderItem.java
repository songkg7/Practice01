package xproject.xshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;

    private Item item; // 주문상품

    private Order order; // 주문

    private int orderPrice; // 주문가격

    private int count; // 주문수량

}
