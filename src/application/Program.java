package application;

import crud.*;
import entities.Person;
import entities.enums.Options;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {

        Scanner userInput = new Scanner(System.in);

        Create createPerson = new Create();
        Read readTable = new Read();
        Update updatePerson = new Update();
        Delete deletePerson = new Delete();

        String name, cpf;
        int id;


        boolean isAdding = true;

        do{
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Adicionar uma pessoa");
            System.out.println("2 - Listar pessoas cadastradas");
            System.out.println("3 - Atualizar dados de uma pessoa");
            System.out.println("4 - Excluir uma pessoa");
            System.out.println("X - Sair");

            Options chosenOption = Options.fromValue(userInput.nextLine());
            System.out.println();

            switch (chosenOption) {
                case ADD:
                    System.out.println("Insira os dados da pessoa: ");

                    System.out.print("ID: ");
                    id = userInput.nextInt();

                    System.out.print("Nome: ");
                    userInput.nextLine();
                    name = userInput.nextLine();


                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    createPerson.createRecord(new Person(id, name, cpf));
                    break;

                case READ:
                    readTable.readRecord();

                    break;

                case UPDATE:
                    System.out.println("Insira o id da pessoa a ser atualizada: ");
                    readTable.readRecord();

                    id = userInput.nextInt();

                    System.out.print("Nome: ");
                    userInput.nextLine();
                    name = userInput.nextLine();

                    System.out.print("CPF: ");
                    cpf = userInput.nextLine();
                    System.out.println();

                    updatePerson.updateRecord(new Person(id, name, cpf));
                    break;

                case DELETE:
                    System.out.println("Insira o id da pessoa a ser removida: ");
                    readTable.readRecord();
                    id = userInput.nextInt();

                    System.out.println();

                    deletePerson.deleteRecord(id);
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

}
