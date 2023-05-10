package fitmeets.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    public void deleteEvent(@RequestBody Long eventId) {
        eventService.deleteEvent(eventId);
    }

}
