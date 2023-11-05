package phuc.topomodoro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import phuc.topomodoro.entity.Item;

@Repository
public interface TodoRepo extends JpaRepository<Item, Integer> {
}
