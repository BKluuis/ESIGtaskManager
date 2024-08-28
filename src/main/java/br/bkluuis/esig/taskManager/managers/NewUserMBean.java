package br.bkluuis.esig.taskManager.managers;

import br.bkluuis.esig.taskManager.model.User;
import br.bkluuis.esig.taskManager.repository.UserRepository;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class NewUserMBean {
    @Autowired
    UserRepository userRepository;

    @Setter
    @Getter
    String username = "";

    public String save(){
        if(username == null || username.isBlank() || userRepository.findByName(username).isPresent()){
            return null;
        }
        User user = new User();
        user.setName(username);
        userRepository.save(user);
        return "task-list.xhtml?faces-redirect=true";
    }
}
