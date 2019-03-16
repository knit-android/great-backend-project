package pl.edu.pk.knit.android.backend.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "last_location")
@Data @AllArgsConstructor @NoArgsConstructor
public class LastLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @Column
    private float accuracy;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "report_time")
    private Date reportTime;
}
