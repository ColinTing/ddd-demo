package ltd.colingting.infrastructure.repository.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import ltd.colingting.domain.domain.dto.OrderQuery;
import ltd.colingting.domain.domain.entity.LineItem;
import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.domain.repository.OrderRepository;
import ltd.colingting.domain.repository.Page;
import ltd.colingting.infrastructure.persistence.mapper.LineItemMapper;
import ltd.colingting.infrastructure.persistence.mapper.OrderMapper;
import ltd.colingting.infrastructure.persistence.po.LineItemPO;
import ltd.colingting.infrastructure.persistence.po.OrderPO;
import ltd.colingting.infrastructure.repository.assemble.LineItemAssembler;
import ltd.colingting.infrastructure.repository.assemble.OrderAssembler;
import ltd.colingting.types.repository.snapshot.DbRepositorySupport;
import ltd.colingting.types.repository.snapshot.Diff;
import ltd.colingting.types.repository.snapshot.DiffType;
import ltd.colingting.types.repository.snapshot.EntityDiff;
import ltd.colingting.types.repository.snapshot.ListDiff;
import ltd.colingting.types.types.OrderId;
import ltd.colingting.types.types.StoreId;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

/**
 * @author 丁浩
 * @date 2022年09月01日 10:39
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl extends DbRepositorySupport<Order, OrderId> implements OrderRepository {


    private  final OrderMapper orderDAO;


    private final LineItemMapper lineItemDAO;

//    private final Cache cache;


    private final  OrderAssembler orderAssembler;


    private final  LineItemAssembler lineAssembler;

//    protected OrderRepositoryImpl(Class<Order> targetClass) {
//        super(targetClass);
//    }



    @Override
    protected void onInsert(Order aggregate) {

    }

    @Override
    protected Order onSelect(OrderId orderId) {
        return null;
    }

    @Override
    protected void onUpdate(Order aggregate, EntityDiff diff) {
        if (diff.isSelfModified()) {
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.updateById(orderDO);
        }

        Diff lineItemDiffs = diff.getDiff("lineItems");
        if (lineItemDiffs instanceof ListDiff) {
            ListDiff diffList = (ListDiff) lineItemDiffs;
            for (Diff itemDiff : diffList) {
                if (itemDiff.getType() == DiffType.Removed) {
                    LineItem line = (LineItem) itemDiff.getOldValue();
                    //子实体不能有独立的Repository，不可以单独保存和取出，必须要通过聚合根的Repository实例化
                    //TODO 这里的LineItemPO 要替换成 OrderPO
//                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
//                    lineItemDAO.deleteById(lineDO.getId());
                }
                if (itemDiff.getType() == DiffType.Added) {
                    LineItem line = (LineItem) itemDiff.getNewValue();
//                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
//                    lineItemDAO.insert(lineDO);
                }
                if (itemDiff.getType() == DiffType.Modified) {
                    LineItem line = (LineItem) itemDiff.getNewValue();
                    LineItemPO lineDO = lineAssembler.fromLineItem(line);
                    lineItemDAO.updateById(lineDO);
                }
            }
        }
    }

    @Override
    protected void onDelete(Order aggregate) {

    }

    @Override
    public void attach(Order aggregate) {

    }

    @Override
    public void detach(Order aggregate) {

    }

    @Override
    public Order find(OrderId orderId) {

        OrderPO orderDO = orderDAO.selectById(orderId.getId());
        return orderAssembler.toOrder(orderDO);
    }

    @Override
    public void remove(@NotNull Order aggregate) {
        OrderPO orderDO = orderAssembler.fromOrder(aggregate);
        orderDAO.deleteById(orderDO.getId());
    }

    @Override
    public void save(Order aggregate) {
        if (aggregate.getId() != null && aggregate.getId().getId() > 0) {
            // update
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.updateById(orderDO);
            for (LineItem lineItem: aggregate.getLineItems()) {
                save(lineItem);
            }
        } else {
            // insert
            OrderPO orderDO = orderAssembler.fromOrder(aggregate);
            orderDAO.insert(orderDO);
            aggregate.setId(orderAssembler.toOrder(orderDO).getId());
        }
    }

    private void save(LineItem lineItem) {
        if (lineItem.getId() != null && lineItem.getId().getId() > 0) {
            LineItemPO lineItemDO = lineAssembler.fromLineItem(lineItem);
            lineItemDAO.updateById(lineItemDO);
        } else {
            LineItemPO lineItemDO = lineAssembler.fromLineItem(lineItem);
            lineItemDAO.insert(lineItemDO);
            lineItem.setId(lineAssembler.toLineItem(lineItemDO).getId());
        }
    }

    @Override
    public Long count(OrderQuery query) {
        return null;
    }

    @Override
    public com.baomidou.mybatisplus.extension.plugins.pagination.Page<Order> query(OrderQuery query) {

        List<OrderPO> orderDOS = orderDAO.selectList(new QueryWrapper<OrderPO>().lambda().eq(OrderPO::getId, query.getOrderId()));
        long count = orderDAO.selectCount(new QueryWrapper<OrderPO>().lambda().eq(OrderPO::getId, query.getOrderId()));
        List<Order> result = orderDOS.stream().map(orderAssembler::toOrder).collect(Collectors.toList());
        return Page.with(result, count);
    }

    @Override
    public Order findInStore(OrderId id, StoreId storeId) {
        OrderPO orderDO = orderDAO.findInStore(id.getId(), storeId.getId());
        return orderAssembler.toOrder(orderDO);
    }
}
