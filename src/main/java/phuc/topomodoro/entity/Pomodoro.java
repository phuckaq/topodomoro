package phuc.topomodoro.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pomodoros")
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class Pomodoro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_time") // Define the column name
    private LocalDateTime startTime;

    @Column(name = "end_time") // Define the column name
    private LocalDateTime endTime;

    @OneToMany
    @JoinColumn(name = "pomodoro_id")
    private List<Item> items;

}
