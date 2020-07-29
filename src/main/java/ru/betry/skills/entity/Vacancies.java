package ru.betry.skills.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Vacancies {

    private List<Vacancy> items;

    public Vacancies() {
    }

    public List<Vacancy> getItems() {
        return items;
    }

    public void setItems(List<Vacancy> items) {
        this.items = items;
    }
}
