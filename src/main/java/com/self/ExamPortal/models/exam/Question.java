package com.self.ExamPortal.models.exam;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quesId;
    @Column(length = 5000)
    private String content;
    private String image;
    @Column(length = 1000)
    private String option1;
    @Column(length = 1000)
    private String option2;
    @Column(length = 1000)
    private String option3;
    @Column(length = 1000)
    private String option4;
    private String answer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

}
