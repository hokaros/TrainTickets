package view;

import java.util.List;
import java.util.Scanner;

public abstract class EntitySelectionView<E> {

    public E run() {
        printTitle();

        List<E> options = getAll();
        printOptions(options);

        int selectedNum = promptChoice(options.size());

        return options.get(selectedNum - 1);
    }

    protected abstract void printTitle();
    protected abstract List<E> getAll();

    protected void printOptions(List<E> options) {
        int i = 1;
        for(E entity : options) {
            System.out.println(i + ". " + entity);
            i++;
        }
    }

    protected int promptChoice(int optionsCount) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        while(true) {
            try {
                int chosenOptionNumber = Integer.parseInt(choice);

                if(chosenOptionNumber >= 1 && chosenOptionNumber <= optionsCount) {
                    return chosenOptionNumber;
                }
                else {
                    System.out.println("Niepoprawna opcja");
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Niepoprawna opcja");
            }
        }
    }
}
