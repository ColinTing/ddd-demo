package ltd.colingting.domain.domain.eventbus;

import java.lang.reflect.Method;

/**
 * @author 丁浩
 * @date 2022年09月14日 10:50
 */

public interface EventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
