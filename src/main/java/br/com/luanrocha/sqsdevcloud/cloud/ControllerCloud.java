package br.com.luanrocha.sqsdevcloud.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCloud {

    @Autowired
    QueueMessagingTemplate queueMessagingTemplate;

    @GetMapping("/")
    public String sendMessage() {
        queueMessagingTemplate.convertAndSend("product", "Nova mensagem");
        return "Funcionando";
    }
}
