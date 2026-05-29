package az.shopery.order_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@EnableJpaAuditing
@SpringBootApplication
public class OrderMsApplication {

	static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	}
}
