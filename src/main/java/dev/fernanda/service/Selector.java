package dev.fernanda.service;

import dev.fernanda.dao.PersonDAO;
import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;

@Service
public class Selector {

    @Autowired
    PersonDAO personDAO;

    public void run() {

        Scanner userInput = new Scanner(System.in);
        boolean isAdding = true;

        do {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Adicionar uma pessoa ao cadastro");
            System.out.println("2 - Achar uma pessoa cadastrada pelo ID");
            System.out.println("3 - Listar as pessoas cadastradas");
            System.out.println("4 - Atualizar dados de uma pessoa cadastrada pelo ID");
            System.out.println("5 - Excluir uma pessoa cadastrada pelo ID");
            System.out.println("X - Sair");
            System.out.println();

            Options chosenOption = Options.fromValue(userInput.nextLine());

            switch (chosenOption) {
                case INSERT:
                    System.out.println("Insira os dados: ");

                    System.out.print("Nome: ");
                    String name = userInput.nextLine();

                    System.out.print("CPF: ");
                    String cpf = userInput.nextLine();
                    System.out.println();

                    personDAO.insert(new Person(name, cpf));

                    System.out.println();
                    break;

                case FIND:
                    System.out.println("Insira o ID da pessoa a ser consultada: ");

                    System.out.print("ID: ");
                    int id = userInput.nextInt();
                    System.out.println();

                    System.out.println(personDAO.findById(id));
                    userInput.nextLine();

                    System.out.println();
                    break;

                case FIND_ALL:
                    System.out.println("Pessoas cadastradas até o momento: ");

                    for (Person person : personDAO.findAll()) {
                        System.out.println(person);
                    }

                    System.out.println();
                    break;

                case UPDATE:
                    System.out.println("Insira o ID da pessoa a ser atualizada: ");

                    System.out.print("ID: ");
                    id = userInput.nextInt();
                    System.out.println();

                    System.out.println("Insira os dados da pessoa a ser atualizada: ");

                    System.out.print("Nome: ");
                    userInput.nextLine();
                    name = userInput.nextLine();

                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    boolean isUpdated = personDAO.update(new Person(id, name, cpf));
                    if (isUpdated) System.out.println("Pessoa atualizada com sucesso");
                    else System.out.println("Não foi possível atualizar essa pessoa");

                    System.out.println();
                    break;

                case DELETE:
                    System.out.println("Insira o ID da pessoa a ser removida: ");

                    System.out.print("ID: ");
                    id = userInput.nextInt();
                    userInput.nextLine();
                    System.out.println();

                    boolean isDeleted = personDAO.deleteById(id);
                    if (isDeleted) System.out.println("Pessoa excluída com sucesso");
                    else System.out.println("Não foi possível excluir essa pessoa");

                    System.out.println();
                    break;

                case EXIT:
                    isAdding = false;
                    userInput.close();
                    break;

                case UNKNOWN:
                    System.out.println("Infelizmente essa opção não existe :/");
                    System.out.println();
                    break;
            }

        } while (isAdding);
    }

    enum Options {
        INSERT("1"),
        FIND("2"),
        FIND_ALL("3"),
        UPDATE("4"),
        DELETE("5"),
        EXIT("X"),
        UNKNOWN("-100");

        private final String value;

        Options(final String value) {
            this.value = value;
        }

        public static Options fromValue(final String value) {
            return Arrays.stream(Options.values())
                    .filter((option) -> value.equals(option.value))
                    .findFirst()
                    .orElse(UNKNOWN);

        }
    }
}
