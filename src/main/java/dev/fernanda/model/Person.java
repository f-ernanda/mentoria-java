package dev.fernanda.model;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private int id;
    private String name;
    private String cpf;

    public Person(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("name", name);
        values.put("cpf", cpf);
        return values;
    }

    @Override
    public String toString() {
        return "ID: " + id +  ", nome: " + name + ", CPF: " + cpf + "; ";
    }

}
