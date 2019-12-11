package com.xavierkress.springdata.basicExample.model;

import javax.persistence.*;

public class BookListener {
    @PreUpdate
    public void preUpdate(Book b) {
        System.out.println("pre update");
    }

    @PostUpdate
    public void postUpdate(Book b) {
        System.out.println("post update");
    }

    @PostLoad
    public void postLoad(Book b) {
        System.out.println("post load");
    }

    @PrePersist
    public void prePersist(Book b) {
        System.out.println("pre persist");
    }

    @PostPersist
    public void postPersist(Book b) {
        System.out.println("post persist");
    }

    @PreRemove
    public void preRemove(Book b) {
        System.out.println("pre remove");
    }

    @PostRemove
    public void postRemove(Book b) {
        System.out.println("post remove");
    }
}
