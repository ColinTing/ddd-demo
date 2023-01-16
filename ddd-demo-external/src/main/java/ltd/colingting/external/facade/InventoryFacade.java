package ltd.colingting.external.facade;

/**
 * @author 丁浩
 * @date 2022年09月17日 18:28
 * 库存Facade
 */

public interface InventoryFacade {
    boolean withhold(Long itemId, Integer quantity);
}
