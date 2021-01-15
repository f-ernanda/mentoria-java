package application;

import entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.print("Entre com o n\u00famero de pessoas a serem cadastradas: ");
        int numberOfPeople = userInput.nextInt();
        System.out.println();

        List<Person> peopleList = new ArrayList<>();

        for(int i = 0; i < numberOfPeople; i++) {

            System.out.println("Insira os dados da pessoa " + (i + 1) + ": ");

            System.out.print("Nome: ");
            userInput.nextLine();
            String name = userInput.nextLine();

            System.out.print("CPF: ");
            String cpf = userInput.next();
            System.out.println();

            Person person = new Person(name, cpf);

            peopleList.add(person);
        }

        System.out.println("Lista de pessoas cadastradas: ");
        for (Person person : peopleList) {
            System.out.println(person);
        }

        userInput.close();
    }

}
