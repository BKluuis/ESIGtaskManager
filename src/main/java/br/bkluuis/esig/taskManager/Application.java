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

	@Bean
	CommandLineRunner mock(){
		String[] titles = {
				"Reunião de planejamento do projeto",
				"Desenvolver módulo de autenticação",
				"Atualizar documentação técnica",
				"Revisar código da API",
				"Testar integração com o sistema externo",
				"Configurar ambiente de produção",
				"Elaborar plano de testes",
				"Treinamento da equipe",
				"Ajustar layout da interface",
				"Análise de requisitos do cliente"
		};
		String[] descriptions = {
				"Organizar a reunião de planejamento com todos os envolvidos no projeto.",
				"Implementar e testar o módulo de autenticação de usuários.",
				"Atualizar a documentação técnica com as últimas alterações no sistema.",
				"Revisar o código da API para garantir a conformidade com as normas de qualidade.",
				"Realizar testes de integração com o sistema externo para garantir a compatibilidade.",
				"Configurar o ambiente de produção para o lançamento da nova versão.",
				"Criar um plano de testes abrangente para as funcionalidades críticas.",
				"Conduzir um treinamento para a equipe sobre as novas ferramentas utilizadas.",
				"Ajustar o layout da interface de usuário de acordo com o feedback do cliente.",
				"Realizar uma análise detalhada dos requisitos fornecidos pelo cliente."
		};
		String[] names = {
				"Carlos Silva", "Mariana Costa", "Fernanda Oliveira",
				"Lucas Souza", "Rafael Santos", "Bianca Almeida",
				"Pedro Lima", "Camila Mendes", "Gustavo Pereira",
				"Juliana Ferreira"
		};
		Priority[] priorities = Priority.values();


		return args -> {
			for (String name : names) {
				User user = new User();
				user.setName(name);
				userRepository.save(user);
			}

			List<User> users = userRepository.findAll();
			Random random = new Random();

			for (int i = 0; i < 10; i++) {
				Task task = Task.builder()
						.title(titles[i])
						.description(descriptions[i])
						.priority(priorities[random.nextInt(priorities.length)])
						.responsible(users.get(random.nextInt(users.size())))
						.deadline(LocalDateTime.now().plusDays(random.nextInt(10) + 1))
						.build();
				taskRepository.save(task);
			}
		};
	}
}
