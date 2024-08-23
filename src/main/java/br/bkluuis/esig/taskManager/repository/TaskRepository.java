package br.bkluuis.esig.taskManager.repository;

import br.bkluuis.esig.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
