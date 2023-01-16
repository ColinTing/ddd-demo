package ltd.colingting.domain.domain.eventbus;

/**
 * @author 丁浩
 * @date 2022年09月14日 10:50
 */

public interface EventExceptionHandler {
    void handle(Throwable cause, EventContext context);
}
