package br.bkluuis.esig.taskManager.managers;

import br.bkluuis.esig.taskManager.model.Priority;
import br.bkluuis.esig.taskManager.model.Task;
import br.bkluuis.esig.taskManager.repository.TaskRepository;
import br.bkluuis.esig.taskManager.repository.UserRepository;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;


@Data
@Component
@ViewScoped
public class NewTaskMBean implements Serializable {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    private Task task = new Task();
    private String userName;

    public Priority[] getPriorityValues(){
        return Priority.values();
    }

    public String save(){
        userRepository.findByName(userName).ifPresent(task::setResponsible);
        taskRepository.save(task);
        return "task-list.xhtml?faces-redirect=true";
    }
}
