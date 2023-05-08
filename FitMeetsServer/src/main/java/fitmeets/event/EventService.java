package fitmeets.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class EventService  {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
//        return List.of(
//                new Event(1L, LocalDate.of(2023, Month.MAY, 31), "Patriki",
//                        0, 100, "Going for Yoga", 10).toString());
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
        // System.out.println(event.toString());
    }
}
