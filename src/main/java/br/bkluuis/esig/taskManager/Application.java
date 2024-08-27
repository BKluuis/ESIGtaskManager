package br.bkluuis.esig.taskManager;

import br.bkluuis.esig.taskManager.model.Priority;
import br.bkluuis.esig.taskManager.model.Task;
import br.bkluuis.esig.taskManager.model.User;
import br.bkluuis.esig.taskManager.repository.TaskRepository;
import br.bkluuis.esig.taskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Application {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
