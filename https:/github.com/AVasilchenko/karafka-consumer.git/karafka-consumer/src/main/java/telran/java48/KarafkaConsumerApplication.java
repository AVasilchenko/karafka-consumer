package telran.java48;

import java.util.function.Consumer;

import org.apache.kafka.common.protocol.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kotlin.contracts.Returns;

@SpringBootApplication
public class KarafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarafkaConsumerApplication.class, args);
	}
	
	@Bean
	public Consumer<String> log() {
		return message -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Long t = System.currentTimeMillis();
			String[] text = message.split(" ");
			Long t1 = Long.valueOf(text[text.length - 1]); 
			System.out.println("Received: " + message + "___" + (t - t1)); 
		};
	}

}
