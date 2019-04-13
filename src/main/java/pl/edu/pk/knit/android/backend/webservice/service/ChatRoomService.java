package pl.edu.pk.knit.android.backend.webservice.service;

import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.chat.ChatRoom;

public interface ChatRoomService {

    Iterable<ChatRoom> getAllPublicChatRooms();
    ChatRoom getChatRoomByName(String name);
    ChatRoom getChatRoomById(long id);

    void subscribe(User newUser, ChatRoom chatRoom);
}
