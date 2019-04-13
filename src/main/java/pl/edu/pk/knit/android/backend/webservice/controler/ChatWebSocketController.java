package pl.edu.pk.knit.android.backend.webservice.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.chat.ChatRoom;
import pl.edu.pk.knit.android.backend.webservice.model.chat.IncomingMessageDto;
import pl.edu.pk.knit.android.backend.webservice.model.chat.OutgoingMessageDto;
import pl.edu.pk.knit.android.backend.webservice.service.ChatRoomService;
import pl.edu.pk.knit.android.backend.webservice.service.UserService;

import java.security.Principal;

@Controller
public class ChatWebSocketController {
    private static final Logger logger = LoggerFactory.getLogger(ChatWebSocketController.class);

    @Autowired
    private SimpMessageSendingOperations messaging;
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private UserService userService;

    @MessageMapping("/chat-send")
    public void sendChatMessage(
            IncomingMessageDto message,
            Principal principal){

        ChatRoom destination = chatRoomService.getChatRoomById(message.getChatRoomId());
        User sender = userService.getUserByName(principal.getName());

        if(destination == null)
            throw new RuntimeException("Chat room with id " + message.getChatRoomId() + "not found");



        if( !destination.getSubscribers().contains(sender) ){
            throw new SecurityException("User " + sender.getUsername()
                    + " is not subscribed to chatroom " + destination.getName());
        }

        OutgoingMessageDto relayMessage =
                OutgoingMessageDto.createUserMessage(
                        sender, destination, message.getContent());

        messaging.convertAndSend("/topic/messages", relayMessage);

        logger.info("Chat message relayed:" + relayMessage);
    }


}
