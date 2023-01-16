package ltd.colingting.domain.domain.eventbus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 丁浩
 * @date 2022年09月14日 10:30
 */

public class EventRegistry {
    // topic -> subscriber collection
    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Subscriber>> subscriberMap = new ConcurrentHashMap<>();


    public void bind(Object subscriber) {
        List<Method> subscriberMethods = getSubscriberMethods(subscriber);
        subscriberMethods.forEach(m -> tierSubscriber(subscriber, m));
    }

    public void unbind(Object subscriber) {
        subscriberMap.forEach((topic, queue) -> {
            queue.forEach(s -> {
                if (s.getObject() == subscriber) {
                    // 为了提高速度，只对subscriber设置失效
                    s.setDisabled(false);
                }
            });
        });
    }

    public ConcurrentLinkedQueue<Subscriber> scanSubscriber(final String topic) {
        return subscriberMap.get(topic);
    }

    private void tierSubscriber(Object subscriber, Method method) {
        final Subscribe subscribe = method.getDeclaredAnnotation(Subscribe.class);
        String topic = subscribe.topic();

        subscriberMap.putIfAbsent(topic, new ConcurrentLinkedQueue<>());
        subscriberMap.get(topic).add(new Subscriber(subscriber, method));
    }

    // 抽取Subscribe注解的方法
    private List<Method> getSubscriberMethods(Object subscriber) {
        final List<Method> methods = new ArrayList<>();
        Class<?> temp = subscriber.getClass();
        while (temp != null) {
            Method[] declaredMethods = temp.getDeclaredMethods();
            Arrays.stream(declaredMethods)
                .filter(m -> m.isAnnotationPresent(Subscribe.class)
                    && m.getParameterCount() == 1
                    && m.getModifiers() == Modifier.PUBLIC)
                .forEach(methods::add);
            temp = temp.getSuperclass();
        }

        return methods;
    }
}
