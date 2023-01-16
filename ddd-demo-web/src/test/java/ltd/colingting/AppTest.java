package ltd.colingting;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.domain.repository.OrderRepository;
import ltd.colingting.infrastructure.persistence.po.OrderPO;
import ltd.colingting.types.types.Currency;
import ltd.colingting.types.types.ItemId;
import ltd.colingting.types.types.Money;
import ltd.colingting.types.types.OrderState;
import ltd.colingting.types.types.Quantity;
import ltd.colingting.types.types.UserId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AppTest {

    @Autowired
    private OrderRepository repo;

    @Test
    public void multiInsert() {
        System.out.println(UUID.randomUUID().toString());

        OrderPO dao = new OrderPO();

        Order order = new Order();
        order.setUserId(new UserId(11L));
        order.setStatus(OrderState.ENABLED);
        order.setLineItems(new ArrayList<>());
        order.addLineItem(new ItemId(13L), new Quantity(5), new Money(BigDecimal.valueOf(4),new Currency("CNY")));
        order.addLineItem(new ItemId(14L), new Quantity(2), new Money(BigDecimal.valueOf(3),new Currency("CNY")));

        System.out.println("第一次保存前");
        System.out.println(order);

        repo.save(order);
        System.out.println("第一次保存后");
        System.out.println(order);

        order.getLineItems().get(0).setQuantity(new Quantity(3));
        order.pay();
        repo.save(order);

        System.out.println("第二次保存后");
        System.out.println(order);
    }


}
