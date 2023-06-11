package ltd.colingting.infrastructure.datahelper.vo;

import lombok.Value;

/**
 * @author 丁浩
 * @date 2022年08月23日 16:54
 */

@Value
public class Result<T> {

    boolean success;

    int code;

    String msg;

    T data;

    public static Result success(Boolean data) {
        return new Result(true, 200, "success", data);
    }

    public static Result fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }


}
