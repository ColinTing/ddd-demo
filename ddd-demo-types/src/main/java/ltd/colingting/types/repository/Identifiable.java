package ltd.colingting.types.repository;

/**
 * @author 丁浩
 * @date 2022年09月02日 10:29
 */

public interface Identifiable<ID extends Identifier> {
    ID getId();
}
