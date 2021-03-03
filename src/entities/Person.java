package entities;

public class Person {

    private final int id;
    private String name;
    private String cpf;

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + name + ", CPF: " + cpf + "; ";
    }

}
