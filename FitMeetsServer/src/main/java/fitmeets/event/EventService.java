package fitmeets.event;

import fitmeets.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventService {
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
        subscribers.add(new UserIdValue(userId));
        event.setSubscribers(subscribers);
        event.setNumOfParticipants(event.getNumOfParticipants() + 1);
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public Event findEventById(Long id) {
        var eventList = eventRepository.findAllById(Collections.singleton(id));
        if (eventList.isEmpty()) {
            throw new NullPointerException("no such event id");
        }
        if (eventList.size() > 1) {
            //  TODO:  throw new Exception("More then 2 users with such id");
        }
        var event = eventList.get(0);
        return event;
    }

    public ResponseEntity<Event> editEvent(Long eventId, Event eventDetails) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow();

        event.setDate(eventDetails.getDate());
        event.setTime(eventDetails.getTime());
        event.setPlace(eventDetails.getPlace());
        event.setMinAge(eventDetails.getMinAge());
        event.setMaxAge(eventDetails.getMaxAge());
        event.setCity(eventDetails.getCity());
        event.setDescription(eventDetails.getDescription());
        event.setSportType(eventDetails.getSportType());
        event.setNumOfParticipants(eventDetails.getNumOfParticipants());

        Event updatedEvent = eventRepository.save(event);

        return ResponseEntity.ok(updatedEvent);
    }
}
