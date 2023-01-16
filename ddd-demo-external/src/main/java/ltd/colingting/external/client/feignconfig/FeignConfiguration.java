
package ltd.colingting.external.client.feignconfig;

import feign.Client;
import feign.Logger;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author: 丁浩
 * @date: 2022/7/15 8:52
 */
@Slf4j
@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        //这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }

    /****
     * 初始化，忽略HTTPS证书校验
     */
    @Bean
    @ConditionalOnMissingBean
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory,
    SpringClientFactory clientFactory) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext ctx = SSLContext.getInstance("SSL");
        X509TrustManager tm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain,
                    String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain,
                    String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        ctx.init(null, new TrustManager[]{tm}, null);
        return new LoadBalancerFeignClient(new Client.Default(ctx.getSocketFactory(),
        (hostname, session) -> {
            // TODO Auto-generated method stub
            return true;
        }),
        cachingFactory, clientFactory);
    }
}