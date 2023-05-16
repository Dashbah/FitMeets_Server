package fitmeets.user;

import fitmeets.event.Event;
import fitmeets.event.EventRepository;
import fitmeets.event.UserIdValue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            // repository.save(new User());
        };
    }
}
