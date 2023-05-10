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
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
        // System.out.println(event.toString());
    }


    public void subscribeUserToEvent(Long userId, Long eventId) {
        var event = eventRepository.findById(eventId).orElseThrow(
                //
        );
        var subscribers = event.getSubscribers();
        subscribers.add(new LongValue(userId));
        event.setSubscribers(subscribers);
        eventRepository.save(event);
    }
}
