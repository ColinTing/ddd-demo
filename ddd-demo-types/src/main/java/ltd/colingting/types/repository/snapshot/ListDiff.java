package ltd.colingting.types.repository.snapshot;

import java.util.Iterator;

/**
 * @author 丁浩
 * @date 2022年09月03日 22:00
 */

public class ListDiff extends Diff implements Iterable<Diff>{
    @Override
    public Iterator<Diff> iterator() {
        return null;
    }
}
