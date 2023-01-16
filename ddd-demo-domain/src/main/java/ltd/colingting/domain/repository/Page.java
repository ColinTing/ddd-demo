package ltd.colingting.domain.repository;

import java.util.List;
import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.types.OrderId;

/**
 * @author 丁浩
 * @date 2022年09月02日 15:23
 */

public interface Page<T extends Aggregate<OrderId>> {

    static com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> with(List<Order> result, long count) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> orderPage = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>();
        orderPage.setRecords(result);
        orderPage.setCurrent(1);
        orderPage.setTotal(count);
        orderPage.setSize(count);
        return orderPage;

    }
}
