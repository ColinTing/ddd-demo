package ltd.colingting.domain.domain.eventbus;

import java.lang.reflect.Method;

/**
 * @author 丁浩
 * @date 2022年09月14日 10:33
 */

public class Subscriber {
    private final Object object;
    private final Method method;

    private boolean disabled;

    public Subscriber(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    public Object getObject() {
        return object;
    }

    public Method getMethod() {
        return method;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
