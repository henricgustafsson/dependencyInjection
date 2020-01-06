package se.lexicon.henric.dependencyinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import se.lexicon.henric.dependencyinjection.util.ErrorStrings;

@Configuration
public class ErrorMessagesConfig {
	
	@Bean
	public ErrorStrings errorMessages() {
		return new ErrorStrings();
	}

}


