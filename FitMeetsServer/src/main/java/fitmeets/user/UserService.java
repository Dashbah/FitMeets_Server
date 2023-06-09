package fitmeets.user;

import fitmeets.event.UserIdValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public User findUserById(Long id) {
        var userList = userRepository.findAllById(Collections.singleton(id));
        if (userList.isEmpty()) {
            throw new NullPointerException("no such user");
        }
        if (userList.size() > 1) {
//      TODO:  throw new Exception("More then 2 users with such id");

        }
        var user = userList.get(0);
        user.setPassword(null);
        return user;
    }

    public ResponseEntity<User> editUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setCity(userDetails.getCity());
        user.setDescription(userDetails.getDescription());
        user.setAge(userDetails.getAge());
        user.setSex(userDetails.getSex());
        user.setRole(userDetails.getRole());
        user.setSportTypes(userDetails.getSportTypes());
        user.setEvents(userDetails.getEvents());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    public ResponseEntity<List<Long>> getEvents(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        // todo : new ResourceNotFoundException("User not found for this id :: " + userId)
                );
        List<Long> eventIds = new ArrayList<>();
        for (var eventId : user.getEvents()) {
            eventIds.add(eventId.getValue());
        }
        return ResponseEntity.ok(eventIds);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public void subscribeUserToUser(Long subscriberId, Long subscribedToId) {
        // add subscriber
        var userToSubscribe = userRepository.findById(subscribedToId).orElseThrow();
        var subscribers = userToSubscribe.getSubscribers();
        subscribers.add(new UserSubscriberIdValue(subscriberId));
        userToSubscribe.setSubscribers(subscribers);
        userRepository.save(userToSubscribe);

        // add subscription
        var userSubscriber = userRepository.findById(subscriberId).orElseThrow();
        var subscriptions = userSubscriber.getSubscribers();
        subscriptions.add(new UserSubscriberIdValue(subscribedToId));
        userSubscriber.setSubscriptions(subscriptions);
        userRepository.save(userSubscriber);
    }
}
