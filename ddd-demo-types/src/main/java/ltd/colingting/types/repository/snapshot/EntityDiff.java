package ltd.colingting.types.repository.snapshot;

/**
 * @author 丁浩
 * @date 2022年09月03日 21:44
 */

public class EntityDiff {
    static EntityDiff EMPTY = new EntityDiff();


    public boolean isEmpty() {
        return false;
    }

    public boolean isSelfModified() {
        return false;
    }

    public Diff getDiff(String lineItems) {
        return new Diff();
    }
}
