package phuc.topomodoro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.topomodoro.entity.PomodoroConfig;

@Repository
public interface PomodoroConfigRepo extends JpaRepository<PomodoroConfig, Integer> {
}
