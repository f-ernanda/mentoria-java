package dev.fernanda.dao;

public interface Queries {

    String INSERT = "insert into people (name, cpf) values (?, ?)";
    String FIND_BY_ID = "select * from people where id = ?";
    String FIND_ALL = "select * from people";
    String UPDATE = "update people set name = ?, cpf = ? where id = ?";
    String DELETE_BY_ID = "delete from people people where id = ?";
}
