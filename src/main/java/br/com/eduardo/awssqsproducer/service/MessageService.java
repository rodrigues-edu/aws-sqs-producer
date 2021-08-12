package br.com.eduardo.awssqsproducer.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Value("${consumer.sqs.message.queue.name}")
    private String queueName;

    private final AmazonSQS amazonSQS;


    public MessageService(AmazonSQS amazonSQS) {
        this.amazonSQS = amazonSQS;
    }

    public void sentToQueue(String message) {
        final SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(queueName)
                .withMessageBody(message);

        amazonSQS.sendMessage(sendMessageRequest);
    }
}
