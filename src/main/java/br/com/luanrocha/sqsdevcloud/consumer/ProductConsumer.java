package br.com.luanrocha.sqsdevcloud.consumer;

import br.com.luanrocha.sqsdevcloud.model.Product;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class ProductConsumer {

    @Autowired
    private AmazonSQS amazonSqs;

    @SqsListener(value = "${cloud.aws.sqs.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consumer(Product product) throws InterruptedException {
        Long id = new Date().getTime();

        log.info("Product SQS {}", product);
        log.info("INICIOU O {}", id);

        Thread.sleep(10000);

        log.info("FINALIZOU O {}", id);

        if (product.getId() == 1L) {
            throw new RuntimeException("Erro SQS");
        }
    }
}
