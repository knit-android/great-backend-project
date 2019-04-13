package pl.edu.pk.knit.android.backend.webservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pk.knit.android.backend.webservice.model.chat.ChatRoom;
import pl.edu.pk.knit.android.backend.webservice.service.ChatRoomService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/room")
    public Iterable<ChatRoom> listChatRooms(){
        return chatRoomService.getAllPublicChatRooms();
    }

}
