package pl.edu.pk.knit.android.backend.webservice.model.chat;

import lombok.Data;
import pl.edu.pk.knit.android.backend.webservice.model.User;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "chat_rooms")
public class ChatRoom {
    @Id
    @Column(name = "chat_room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "chat_rooms_subscribers",
            joinColumns = @JoinColumn(name = "chat_room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> subscribers;

}
