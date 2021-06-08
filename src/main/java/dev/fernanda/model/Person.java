package dev.fernanda.model;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class Person {
    private int id;
    private String name;
    private String cpf;

    public Person(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Person(String fernanda, String name) {
        this.name = name;
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
