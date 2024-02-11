package view;

import repository.RepositoryCollection;
import view.passenger.RegistrationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewRouter {
    private List<RouteOption> options = new ArrayList<>();

    public void addOption(String name, RouteFunction function) {
        options.add(new RouteOption(name, function));
    }

    public boolean run() {
        printAvailableOptions();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        while(true) {
            try {
                int chosenOptionNumber = Integer.parseInt(choice);

                if(chosenOptionNumber == getExitOptionNumber()) {
                    return false;
                }
                else if(chosenOptionNumber >= 1 && chosenOptionNumber <= options.size()) {
                    options.get(chosenOptionNumber - 1).function.run();
                    return true;
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

    private void printAvailableOptions() {
        int i = 1;
        for(RouteOption opt : options) {
            System.out.println(i + ". " + opt.name);
            i++;
        }
        System.out.println(getExitOptionNumber() + ". Wyjdź");
    }

    private int getExitOptionNumber() {
        return options.size() + 1;
    }


    private class RouteOption {
        public String name;
        public RouteFunction function;

        public RouteOption(String name, RouteFunction function) {
            this.name = name;
            this.function = function;
        }
    }
}
