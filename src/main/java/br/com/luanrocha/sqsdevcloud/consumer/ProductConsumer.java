package br.com.luanrocha.sqsdevcloud.consumer;

import br.com.luanrocha.sqsdevcloud.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductConsumer {

    @SqsListener(value = "${cloud.aws.sqs.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consumer(Product product) {
        log.info("Product SQS {}", product);

        if (product.getId() == 1L) {
            throw new RuntimeException("Erro SQS");
        }
    }
}
