package hello.itemservice.domain.item;

import lombok.Data;
import lombok.NoArgsConstructor;

//단순한 DTO에서는 사용해도된다. 그래도 확인을 잘 해보고. 주의를 좀 해야한다.
@Data // 위험, 직접 찍어서 하고 핵심 도메인에서는 사용하면 안됨
@NoArgsConstructor
public class Item {

    private Long id;
    private String itemName;
    // null로 들어간다고 가정
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
