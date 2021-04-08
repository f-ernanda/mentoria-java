package dev.fernanda;

import dev.fernanda.model.Person;
import dev.fernanda.config.DBConfig;
import dev.fernanda.dao.PersonDAO;
import dev.fernanda.model.enums.Options;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
        Scanner userInput = new Scanner(System.in);

        PersonDAO personDAO = context.getBean(PersonDAO.class);

        String name, cpf;
        int id;

        boolean isAdding = true;

        do{
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Adicionar uma pessoa ao cadastro");
            System.out.println("2 - Achar uma pessoa cadastrada");
            System.out.println("3 - Listar as pessoas cadastradas");
            System.out.println("4 - Atualizar dados de uma pessoa cadastrada");
            System.out.println("5 - Excluir uma pessoa cadastrada");
            System.out.println("X - Sair");

            Options chosenOption = Options.fromValue(userInput.nextLine());
            System.out.println();

            switch (chosenOption) {
                case CREATE:
                    System.out.println("Insira os dados: ");

                    System.out.print("Nome: ");
                    name = userInput.nextLine();


                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    personDAO.createPerson(name, cpf);

                    break;

                case READ:
                    System.out.println("Insira o ID da pessoa a ser consultada: ");

                    System.out.print("ID: ");
                    id = userInput.nextInt();
                    System.out.println();

                    System.out.println(personDAO.readPerson(id));
                    userInput.nextLine();

                    System.out.println();

                    break;

                case READ_ALL:
                    System.out.println("Pessoas cadastradas até o momento: ");

                    for (Person person : personDAO.readPeople()) {
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

                    personDAO.updatePerson(id, name, cpf);

                    break;

                case DELETE:
                    System.out.println("Insira o ID da pessoa a ser removida: ");

                    System.out.print("ID: ");
                    id = userInput.nextInt();
                    System.out.println();

                    personDAO.deletePerson(id);
                    userInput.nextLine();

                    break;

                case EXIT:
                    isAdding = false;
                    break;

                case UNKNOWN:
                    System.out.println("Infelizmente essa opção não existe :/");
                    System.out.println();
                    break;
            }

        } while(isAdding);

        userInput.close();
        context.close();

    }


}
