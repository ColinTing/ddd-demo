package ltd.colingting.domain.messaging;

import ltd.colingting.domain.domain.types.AuditMessage;

/**
 * @author 丁浩
 * @date 2022年08月19日 14:18
 */

public interface AuditMessageProducer {
    void send(AuditMessage message);
}
