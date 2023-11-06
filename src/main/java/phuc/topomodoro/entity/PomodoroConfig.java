package phuc.topomodoro.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pomodoro_configs")
@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class PomodoroConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "work_duration")
    private Integer workDuration;

    @Column(name = "break_duration")
    private Integer breakDuration;

}
