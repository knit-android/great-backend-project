package pl.edu.pk.knit.android.backend.webservice.model.chat;

import lombok.*;
import pl.edu.pk.knit.android.backend.webservice.model.User;

@ToString @Getter @Setter
public class OutgoingMessageDto {
    public enum MessageTypeEnum{
        UserMessage, SystemMessage
    }

    private MessageTypeEnum messageType;

    private String body;

    private String senderUsername;
    private long senderId;

    private String chatRoomName;
    private long chatRoomId;

    private OutgoingMessageDto(
            MessageTypeEnum messageType, String body,
            String senderUsername, long senderId,
            String chatRoomName, long chatRoomId) {
        this.messageType = messageType;
        this.body = body;
        this.senderUsername = senderUsername;
        this.senderId = senderId;
        this.chatRoomName = chatRoomName;
        this.chatRoomId = chatRoomId;
    }

    public static OutgoingMessageDto createUserMessage(
            User sender,
            ChatRoom chatRoom,
            String body){

        return new OutgoingMessageDto(
                MessageTypeEnum.UserMessage, body,
                sender.getUsername(), sender.getUserId(),
                chatRoom.getName(), chatRoom.getId());
    }

    public static OutgoingMessageDto createSystemMessage(
            ChatRoom chatRoom,
            String body){

        return new OutgoingMessageDto(
                MessageTypeEnum.SystemMessage, body,
                "System", 0,
                chatRoom.getName(), chatRoom.getId());
    }
}
