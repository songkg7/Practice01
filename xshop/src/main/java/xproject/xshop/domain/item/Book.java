package xproject.xshop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 상품 테이블에서 구분하기 위해 추가
@Getter
@Setter
public class Book extends Item {

    private String author;
    private String isbn;

}
