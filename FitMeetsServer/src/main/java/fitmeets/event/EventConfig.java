package fitmeets.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class EventConfig {

    @Bean
    CommandLineRunner commandLineRunner(EventRepository repository) {
        return args -> {
            Event patriki = new Event( LocalDate.of(2023, Month.MAY, 31), LocalTime.of(14, 0), "Patriki",
                    0, 100, "Going for Yoga", 10);
            Event kg = new Event( LocalDate.of(2023, Month.JUNE, 28), LocalTime.of(11, 35), "KG",
                    17, 20, "Running to Vyshka", 20);
            repository.saveAll(
                    List.of(patriki, kg)
            );
        };
    }
}
