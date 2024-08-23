package br.bkluuis.esig.taskManager.model;

import lombok.Data;
@Data
public class SearchTask {
    private String keywords;
    private Boolean isActive;
    private String responsibleName;
}
