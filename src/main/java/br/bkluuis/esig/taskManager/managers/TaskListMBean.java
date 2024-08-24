package br.bkluuis.esig.taskManager.managers;

import br.bkluuis.esig.taskManager.model.SearchTask;
import br.bkluuis.esig.taskManager.model.Task;
import br.bkluuis.esig.taskManager.repository.TaskRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
@ViewScoped
@Join(path = "/", to = "/task-list.xhtml")
public class TaskListMBean implements Serializable {
    @Autowired
    private TaskRepository taskRepository;

    @Getter
    List<Task> tasks = new ArrayList<>();
    @Getter
    List<Task> filteredTasks;

    @Getter
    @Setter
    SearchTask searchExample = new SearchTask();

    @PostConstruct
    public void load() {
        tasks = taskRepository.findAll();
        filteredTasks = tasks;
    }

    public String newTask(){
        return "new-task?faces-redirect=true";
    }
    public void deleteTask(Task task) {
        taskRepository.delete(task);
        load();
    }

    public String editTask(Task task){
        System.out.println("Task recebida: " + task);
        return "edit-task.xhtml/?faces-redirect=true&id="+task.getId();
    }

    public void finishTask(Task task) {
        task.setIsActive(false);
        taskRepository.save(task);
        load();
    }

    public void search() {
        if (searchExample.getKeywords() != null){
            searchExample.setKeywords(searchExample.getKeywords().trim());
        }
        filteredTasks = tasks.stream()
                .filter(task ->
                        (searchExample.getKeywords() == null || searchExample.getKeywords().isEmpty() ||
                                task.getDescription().toLowerCase().contains(searchExample.getKeywords().toLowerCase()) ||
                                task.getTitle().toLowerCase().contains(searchExample.getKeywords().toLowerCase())) &&
                        (searchExample.getResponsibleName() == null || searchExample.getResponsibleName().isEmpty() || task.getResponsible().getName().equals(searchExample.getResponsibleName())) &&
                        (searchExample.getIsActive() == null || task.getIsActive() == searchExample.getIsActive())
                ).toList();
    }
}
