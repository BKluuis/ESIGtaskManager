package br.bkluuis.esig.taskManager.controller;

import jakarta.faces.view.ViewScoped;
import lombok.Getter;
import lombok.Setter;
import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ViewScoped
@Getter
@Setter
@Join(path = "/", to = "/layout.xhtml")
public class TaskController implements Serializable {
    private String teste = "testando 1 2";
    public String getTasks(){
        return "Hello from task controller";
    }
}
