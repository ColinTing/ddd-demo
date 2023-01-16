package ltd.colingting.types.repository;

/**
 * @author 丁浩
 * @date 2022年09月02日 10:24
 */

// 聚合根的Marker接口
public interface Aggregate <ID extends Identifier> extends Entity<ID> {

}
