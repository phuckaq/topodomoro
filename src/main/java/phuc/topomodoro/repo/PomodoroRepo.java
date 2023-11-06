package phuc.topomodoro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.topomodoro.entity.Pomodoro;

@Repository
public interface PomodoroRepo extends JpaRepository<Pomodoro, Integer> {
}
