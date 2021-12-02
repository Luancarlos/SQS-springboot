package br.com.luanrocha.sqsdevcloud.controller;

import br.com.luanrocha.sqsdevcloud.model.Product;
import com.amazonaws.services.sqs.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @SneakyThrows
    @GetMapping("/")
    public String sendMessage(@RequestParam("id") Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Macbook Pro");
        product.setDescription("New Macbook Prod");

        String json = new ObjectMapper().writeValueAsString(product);

        queueMessagingTemplate.send("product", MessageBuilder.withPayload(json).build());
        return "Working...";
    }
}
