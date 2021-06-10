package dev.fernanda.service;

import dev.fernanda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Selector {

    @Autowired
    PersonManager personManager;

    @Autowired
    Viewer viewer;

    Person person;

    public void run() {
        boolean isAdding = true;
        do {
            viewer.printMenu();
            Options chosenOption = Options.fromValue(viewer.getValue());

            switch (chosenOption) {
                case INSERT:
                    viewer.printInsert();
                    person = personManager.insertPerson(viewer.getName(), viewer.getCpf());
                    viewer.printPerson(person);
                    viewer.printEmptyLine();
                    break;

                case FIND:
                    viewer.printFind();
                    person = personManager.findById(viewer.getId());
                    viewer.printPerson(person);
                    viewer.getUserNextLine();
                    viewer.printEmptyLine();
                    break;

                case FIND_ALL:
                    viewer.printFindAll(personManager.findAll());
                    viewer.printEmptyLine();
                    break;

                case UPDATE:
                    int id;
                    viewer.printTryUpdate();
                    id = viewer.getId();
                    person = personManager.findById(id);
                    viewer.printPerson(person);
                    viewer.getUserNextLine();
                    viewer.printEmptyLine();
                    if(person == null) break;
                    viewer.printUpdate();
                    boolean isUpdated = personManager.updatePerson(id, viewer.getName(), viewer.getCpf());
                    viewer.printChangedResult(isUpdated);
                    viewer.printEmptyLine();
                    break;

                case DELETE:
                    viewer.printDelete();
                    boolean isDeleted = personManager.deletePerson(viewer.getId());
                    viewer.printChangedResult(isDeleted);
                    viewer.getUserNextLine();
                    viewer.printEmptyLine();
                    break;

                case EXIT:
                    isAdding = false;
                    viewer.closeUserInput();
                    break;

                case UNKNOWN:
                    viewer.printUnknown();
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
