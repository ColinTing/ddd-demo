package ltd.colingting.types.repository.snapshot;

import ltd.colingting.types.repository.Aggregate;
import ltd.colingting.types.repository.Identifier;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:43
 */

public interface AggregateManager<T extends Aggregate<ID>, ID extends Identifier> {
    void attach(T aggregate);

    void attach(T aggregate, ID id);

    void detach(T aggregate);

    T find(ID id);

    EntityDiff detectChanges(T aggregate);

    void merge(T aggregate);

    static <ID extends Identifier, T extends Aggregate<ID>> AggregateManager<T,ID> newInstance(Class<T> targetClass) {
        return new ThreadLocalAggregateManager<>(targetClass);
    }
}
