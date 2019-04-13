package pl.edu.pk.knit.android.backend.webservice.model.chat;

import lombok.Data;

@Data
public class IncomingMessageDto {
    private long chatRoomId;
    private String content;
}
