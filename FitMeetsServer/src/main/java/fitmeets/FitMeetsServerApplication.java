package fitmeets;

import fitmeets.event.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class FitMeetsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitMeetsServerApplication.class, args);
    }

    //    new Event(1L, LocalDate.of(2023, Month.MAY, 31), "Patriki",
//            0, 100, "Going for Yoga", 10).toString())
//    @GetMapping("/hello")
//    public List<Event> hello() {
//        return List.of(
//                new Event(LocalDate.of(2023, Month.MAY, 31), "Patriki",
//                        0, 100, "Going for Yoga", 10),
//                new Event(LocalDate.of(2023, Month.JUNE, 28), "KG",
//                        17, 20, "Running to Vyshka", 20)
//        );
//    }
}
