package fitmeets.event;

import fitmeets.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping()
    public void registerNewEvent(@RequestBody Event event) {
        eventService.addNewEvent(event);
    }

    @PostMapping("/subscribe")
    public void subscribeUserToEvent(@RequestBody SubscribeToEventRequest request) {
        eventService.subscribeUserToEvent(request.getUserId(), request.getEventId());
    }

    @GetMapping("/info/{id}")
    public Event getInfo(@PathVariable(value = "id") Long id) {
        return eventService.findEventById(id);
    }

    @DeleteMapping
    public void deleteEvent(@RequestBody Long eventId) {
        eventService.deleteEvent(eventId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
                                           @RequestBody Event eventDetails) {
        try {
            return eventService.editEvent(eventId, eventDetails);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

}
