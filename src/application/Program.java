package application;

import entities.Person;
import entities.enums.Options;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();

        boolean isAdding = true;

        do{
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Adicionar uma pessoa");
            System.out.println("2 - Sair");

            Options chosenOption = Options.fromValue(userInput.nextLine());
            System.out.println();

            switch (chosenOption) {
                case ADD:
                    System.out.println("Insira os dados da pessoa: ");

                    System.out.print("Nome: ");
                    String name = userInput.nextLine();


                    System.out.print("CPF: ");
                    String cpf = userInput.nextLine();
                    System.out.println();

                    Person person = new Person(name, cpf);

                    peopleList.add(person);
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


        System.out.println("Lista de pessoas cadastradas: ");
        for (Person person : peopleList) {
            System.out.println(person);
        }

        userInput.close();
    }

}
