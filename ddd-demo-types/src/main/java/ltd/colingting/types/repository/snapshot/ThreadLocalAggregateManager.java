package ltd.colingting.types.repository.snapshot;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.repository.Identifier;
import ltd.colingting.types.repository.snapshot.util.DiffUtils;
import ltd.colingting.types.repository.snapshot.util.ReflectionUtils;
import ltd.colingting.types.repository.snapshot.util.SnapshotUtils;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:40
 */

public class ThreadLocalAggregateManager<T extends Aggregate<ID>, ID extends Identifier> implements AggregateManager<T, ID> {
    private ThreadLocal<DbContext<T, ID>> context;
    private Class<? extends T> targetClass;

    public ThreadLocalAggregateManager(Class<? extends T> targetClass) {
        this.targetClass = targetClass;
        this.context = ThreadLocal.withInitial(() -> new DbContext<>(targetClass));
    }

    @Override
    public void attach(T aggregate) {
        context.get().attach(aggregate);
    }

    @Override
    public void attach(T aggregate, ID id) {
        context.get().setId(aggregate, id);
        context.get().attach(aggregate);
    }

    @Override
    public void detach(T aggregate) {
        context.get().detach(aggregate);
    }

    @Override
    public T find(ID id) {
        return context.get().find(id);
    }

    @Override
    public EntityDiff detectChanges(T aggregate) {
        return context.get().detectChanges(aggregate);
    }

    @Override
    public void merge(T aggregate) {
        context.get().merge(aggregate);
    }
}

class DbContext<T extends Aggregate<ID>, ID extends Identifier> {

    @Getter
    private Class<? extends T> aggregateClass;

    private Map<ID, T> aggregateMap = new HashMap<>();

    public DbContext(Class<? extends T> aggregateClass) {
        this.aggregateClass = aggregateClass;
    }

    public void attach(T aggregate) {
        if (aggregate.getId() != null) {
            if (!aggregateMap.containsKey(aggregate.getId())) {
                this.merge(aggregate);
            }
        }
    }

    public void detach(T aggregate) {
        if (aggregate.getId() != null) {
            aggregateMap.remove(aggregate.getId());
        }
    }

    public EntityDiff detectChanges(T aggregate) {
        if (aggregate.getId() == null) {
            return EntityDiff.EMPTY;
        }
        T snapshot = aggregateMap.get(aggregate.getId());
        if (snapshot == null) {
            attach(aggregate);
        }
        return DiffUtils.diff(snapshot, aggregate);
    }

    public T find(ID id) {
        return aggregateMap.get(id);
    }

    public void merge(T aggregate) {
        if (aggregate.getId() != null) {
            T snapshot = SnapshotUtils.snapshot(aggregate);
            aggregateMap.put(aggregate.getId(), snapshot);
        }
    }

    public void setId(T aggregate, ID id) {
        ReflectionUtils.writeField("id", aggregate, id);
    }
}
