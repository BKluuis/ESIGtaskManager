package br.bkluuis.esig.taskManager.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;

@Data
@Entity
@Table(name = "tm_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 80)
    private String name;
}
