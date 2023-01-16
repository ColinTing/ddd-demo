package ltd.colingting.domain.domain.oop;

/**
 * @author 丁浩
 * @date 2022年09月05日 10:38
 */

public class Elf extends Monster {

    @Override
    public void receiveDamageBy(Weapon weapon, Player player) {
        if (weapon.getDamageType() != 0) {
            this.setHealth(this.getHealth() - weapon.getDamage() / 2); // Orc的物理防御规则
        } else {
            super.receiveDamageBy(weapon, player);
        }
    }
}
