package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.exception.NotEnoughStockException;
import jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {

        // given
        Member member = createMember();

        Item book = createBook("시골 JPA", 10000, 10);

        // when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        // then
        Order getOrder = orderRepository.findOne(orderId);

//        assertThat(OrderStatus.ORDER).isEqualTo(getOrder.getStatus()); // 주문 상태 검증
        assertEquals(OrderStatus.ORDER, getOrder.getStatus(), "주문상태 검증");
//        assertThat(1).isEqualTo(getOrder.getOrderItems().size()); // 주문 상품 종류 수 검증
        assertEquals(1, getOrder.getOrderItems().size(), "주문 상품 종류 수 검증 실패");
        assertThat(10000 * orderCount).isEqualTo(getOrder.getTotalPrice()); // 주문 가격은 가격 * 수량이다
        assertThat(8).isEqualTo(book.getStockQuantity()); // 주문 후 재고 수량 검증


//        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
    }

    //    @Test(expected = NotEnoughStockException.class)
    @Test
    public void 상품주문_재고수량초과() throws Exception {

        // given
        Member member = createMember();
        Book item = createBook("시골 JPA", 10000, 10);


        // when
        int orderCount = 11;
//        orderService.order(member.getId(), item.getId(), orderCount);

        // then
        NotEnoughStockException e = assertThrows(NotEnoughStockException.class,
                () -> orderService.order(member.getId(), item.getId(), orderCount), "재고 부족이 발생해야합니다.");

//        assertEquals(e.getMessage(),"need more stock");

//        fail("재고 수량 부족 예외가 발생해야한다.");

    }

    @Test
    public void 주문취소() throws Exception {

        // given
        Member member = createMember();
        Book item = createBook("시골 JPA", 10000, 10);

        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        // when
        orderService.cancelOrder(orderId);

        // then
        Order getOrder = orderRepository.findOne(orderId);

        assertEquals(OrderStatus.CANCEL, getOrder.getStatus(), "주문취소시 상태는 CANCEL 이다.");
        assertEquals(10, item.getStockQuantity(), "주문이 취소된 상품은 그만큼 재고가 증가해야한다.");

    }

    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember() {
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("화성", "삼천병마로", "123-123"));
        em.persist(member);
        return member;
    }

}