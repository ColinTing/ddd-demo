package ltd.colingting.domain.domain.types;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Value;
import ltd.colingting.domain.domain.entity.Account;
import ltd.colingting.types.types.AccountNumber;
import ltd.colingting.types.types.Money;
import ltd.colingting.types.types.UserId;

/**
 * @author 丁浩
 * @date 2022年08月19日 14:16
 */
@Value
@AllArgsConstructor
public class AuditMessage {
    UserId userId;
    AccountNumber source;
    AccountNumber target;
    Money money;
    Date date;



    public AuditMessage(Account sourceAccount, Account targetAccount, Money targetMoney) {
        this.source = sourceAccount.getAccountNumber();
        this.target = targetAccount.getAccountNumber();
        this.money = targetMoney;
        this.userId = targetAccount.getUserId();
        this.date = new Date();
    }




    public String serialize() {
        return userId + "," + source + "," + target + "," + money + "," + date;
    }

    public static AuditMessage deserialize(String value) {
        // todo
        return null;
    }
}
