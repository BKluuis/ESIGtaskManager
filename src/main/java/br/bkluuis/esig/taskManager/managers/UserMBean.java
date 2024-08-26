package br.bkluuis.esig.taskManager.managers;

import br.bkluuis.esig.taskManager.model.User;
import br.bkluuis.esig.taskManager.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ApplicationScoped
public class UserMBean {
    @Autowired
    UserRepository userRepository;

    public List<String> getUsers(){
        return userRepository.findAll().stream().map(User::getName).toList();
    }
}
