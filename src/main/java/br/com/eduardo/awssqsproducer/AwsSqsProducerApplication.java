package br.com.eduardo.awssqsproducer;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwsSqsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsSqsProducerApplication.class, args);
	}

	@Bean
	public AmazonSQS createSQSClient() {
		return AmazonSQSClient.builder()
				.withCredentials(new ProfileCredentialsProvider())
				.withRegion(Regions.US_EAST_1)
				.build();
	}

}
