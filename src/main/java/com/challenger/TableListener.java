package com.challenger;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@Component
public class TableListener {


    Table table;


    @Autowired
    static TableJpaRepository tableJpaRepository;

    @PrePersist
    public void prePersist(Object o) {

    }

    @PreUpdate
    public void preUpdate(Object o) {
        log.info("Log : {}", (Table) o);
        if (!((Table) o).getPassword().equals(table.getPassword())) {
            ((Table) o).setLastChange(Instant.now().toString());
        }
    }

    @PreRemove
    public void preRemove(Object o) {

    }

    @PostLoad
    public void postLoad(Object o) {
        log.info("postload");
        table = new Table();
        table.setPassword(((Table) o).getPassword());
    }

    @PostRemove
    public void postRemove(Object o) {

    }

    @PostUpdate
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void postUpdate(Object o) {

    }

    @PostPersist
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void postPersist(Object o) {

    }
}
