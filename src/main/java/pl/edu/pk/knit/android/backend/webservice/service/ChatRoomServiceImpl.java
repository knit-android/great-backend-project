package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.ChatRoomDao;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.chat.ChatRoom;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ChatRoomServiceImpl implements ChatRoomService {

    @Autowired
    private ChatRoomDao chatRoomDao;

    @Autowired
    private SimpMessageSendingOperations messaging;



    @Override
    public Iterable<ChatRoom> getAllPublicChatRooms() {

        return chatRoomDao.findAll();
    }

    @Override
    public ChatRoom getChatRoomByName(String name) {

        return chatRoomDao.getChatRoomByName(name);
    }

    @Override
    public ChatRoom getChatRoomById(long id) {
        Optional result = chatRoomDao.findById(id);
        if(result.isPresent())
            return (ChatRoom)result.get();
        else
            return null;
    }

    @Override
    public void subscribe(User newUser, ChatRoom chatRoom) {
        chatRoom.getSubscribers().add(newUser);
        chatRoomDao.save(chatRoom);
    }
}
