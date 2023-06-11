package ltd.colingting.domain.vo;

import java.util.Arrays;
import javax.xml.bind.ValidationException;
import lombok.Value;

/**
 * @author 丁浩
 * @date 2022年07月23日 18:54
 */

@Value
public class PhoneNumber {
    String number;
    public String getNumber() {
        return number;
    }

    public PhoneNumber(String number) throws ValidationException {
        if (number == null) {
            throw new ValidationException("number不能为空");
        } else if (!isValid(number)) {
            throw new ValidationException("number格式错误");
        }
        this.number = number;
    }

    public String getAreaCode() {
        for (int i = 0; i < number.length(); i++) {
            String prefix = number.substring(0, i);
            if (isAreaCode(prefix)) {
                return prefix;
            }
        }
        return null;
    }

    private static boolean isAreaCode(String prefix) {
        String[] areas = new String[]{"0571", "021", "010", "0755"};
        return Arrays.asList(areas).contains(prefix);
    }

    public static boolean isValid(String number) {
        String pattern = "^0?[1-9]{2,3}-?\\d{8}$";
        return number.matches(pattern);
    }

}
