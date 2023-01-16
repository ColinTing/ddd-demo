package ltd.colingting.infrastructure.datahelper.vo;

import java.io.Serializable;

/**
 * @author 丁浩
 * @date 2022年08月23日 16:54
 */


public final class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    boolean success;

    int code;

    String message;

    T data;

    private Result() {
    }

    private Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(boolean success, int code, String message) {
        this(success, code, message, null);
    }

    public static <T> Result<T> success(Boolean data) {
        return new Result(true, 200, "success", data);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result(false, code, msg, null);
    }


    public static <T> Result<T> fail(String message) {
        return new Result(false, 500, message, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(true, 200, "success", data);
    }
}
