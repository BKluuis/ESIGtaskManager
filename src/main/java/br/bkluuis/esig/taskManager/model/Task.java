package br.bkluuis.esig.taskManager.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tm_task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title", nullable = false, length = 80)
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "responsible")
    private User responsible;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority", length = 50)
    private Priority priority;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deadline")
    private Date deadline;
}
