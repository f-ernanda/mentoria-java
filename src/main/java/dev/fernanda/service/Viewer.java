package dev.fernanda.service;

import dev.fernanda.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class Viewer {

    Scanner userInput = new Scanner(System.in);

    public void printMenu() {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Adicionar uma pessoa ao cadastro");
        System.out.println("2 - Achar uma pessoa cadastrada pelo ID");
        System.out.println("3 - Listar as pessoas cadastradas");
        System.out.println("4 - Atualizar dados de uma pessoa cadastrada pelo ID");
        System.out.println("5 - Excluir uma pessoa cadastrada pelo ID");
        System.out.println("X - Sair");
        System.out.println();
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printPerson(Person person) {
        System.out.println();
        if(person != null) {
            System.out.println(person);
        }
        else {
            System.out.println("Pessoa não encontrada :/");
        }
    }

    public void printInsert() {
        System.out.println("Insira os dados: ");
    }

    public void printFind() {
        System.out.println("Insira o ID da pessoa a ser consultada: ");
    }

    public void printFindAll(List<Person> people) {
        System.out.println("Pessoas cadastradas até o momento: ");
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public void printTryUpdate() {
        System.out.println("Insira o ID da pessoa a ser atualizada: ");
    }

    public void printUpdate() {
        System.out.println("Insira os dados da pessoa a ser atualizada: ");
    }

    public void printDelete() {
        System.out.println("Insira o ID da pessoa a ser removida: ");
    }

    public void printChangedResult(boolean isChanged) {
        if(isChanged) System.out.println("Alteração feita com sucesso :)");
        else System.out.println("Não foi possível fazer a alteração :(");
    }

    public void printUnknown() {
        System.out.println("Infelizmente essa opção não existe :/");
        System.out.println();
    }

    public String getValue() {
        return userInput.nextLine();
    }

    public void getUserNextLine() {
        userInput.nextLine();
    }

    public int getId() {
        System.out.print("ID: ");
        return userInput.nextInt();
    }

    public String getName() {
        System.out.print("Nome: ");
        return userInput.nextLine();
    }

    public String getCpf() {
        System.out.print("CPF: ");
        return userInput.nextLine();
    }

    public void closeUserInput() {
       userInput.close();
    }

}
