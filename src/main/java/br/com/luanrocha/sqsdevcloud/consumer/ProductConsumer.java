package br.com.luanrocha.sqsdevcloud.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerCloud {

    @SqsListener(value = "${cloud.aws.sqs.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consumer(String message) {
        if (message.equals("luan")) {
            throw new RuntimeException("Teste");
        }
        log.info(message);
    }
}
