package entities;

public class Person {

    private String name;
    private final String cpf;

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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

    @Override
    public String toString() {
        return "Nome: " + name + ", CPF: " + cpf + "; ";
    }

}
