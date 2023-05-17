package fitmeets.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubscribeToUserRequest {
    private Long subscriberId;
    private Long subscribedToId;
}
