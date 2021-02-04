package application;

import entities.Person;
import entities.enums.Options;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        ArrayList<Person> peopleList = new ArrayList<Person>();
        String name, cpf;
        int index;

        boolean isAdding = true;

        do{
            if(peopleList.isEmpty()) {
                System.out.println("Digite a opção desejada: ");
                System.out.println("1 - Adicionar uma pessoa");
                System.out.println("X - Sair");
            } else {
                System.out.println("Digite a opção desejada: ");
                System.out.println("1 - Adicionar uma pessoa");
                System.out.println("2 - Listar pessoas cadastradas");
                System.out.println("3 - Atualizar dados de uma pessoa");
                System.out.println("4 - Excluir uma pessoa");
                System.out.println("X - Sair");
            }

            Options chosenOption = Options.fromValue(userInput.nextLine());
            System.out.println();

            switch (chosenOption) {
                case ADD:
                    System.out.println("Insira os dados da pessoa: ");

                    System.out.print("Nome: ");
                    name = userInput.nextLine();


                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    peopleList.add(new Person(name, cpf));
                    break;

                case READ:
                    readPeopleList(peopleList);
                    break;

                case UPDATE:
                    System.out.println("Insira a posição da pessoa a ser atualizada: ");
                    readPeopleList(peopleList);
                    index = userInput.nextInt() - 1;

                    System.out.print("Nome: ");
                    userInput.nextLine();
                    name = userInput.nextLine();


                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    peopleList.set(index, new Person(name, cpf));
                    break;

                case DELETE:
                    System.out.println("Insira a posição da pessoa a ser removida: ");
                    readPeopleList(peopleList);
                    index = userInput.nextInt() - 1;

                    System.out.println();

                    peopleList.remove(index);
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


    }

    private static void readPeopleList(ArrayList<Person> peopleList) {
        System.out.println("Lista de pessoas cadastradas: ");
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println("Posição " + (i + 1) + " - " + peopleList.get(i));
        }
        System.out.println();
    }

}
