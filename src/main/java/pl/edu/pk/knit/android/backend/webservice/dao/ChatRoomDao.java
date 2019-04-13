package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pk.knit.android.backend.webservice.model.chat.ChatRoom;


public interface ChatRoomDao extends CrudRepository<ChatRoom, Long> {


    ChatRoom getChatRoomByName(String name);
}
