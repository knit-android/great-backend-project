package pl.edu.pk.knit.android.backend.webservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
