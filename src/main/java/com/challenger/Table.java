package com.challenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@javax.persistence.Table(name = "tbl")
@EntityListeners(TableListener.class)
@Slf4j
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String password;

    @Column(name = "last_change")
    private String lastChange;



}
