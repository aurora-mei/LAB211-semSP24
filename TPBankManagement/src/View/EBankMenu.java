package View;

import common.EBankInputter;
import java.util.List;
import java.util.stream.Stream;

public abstract class EBankMenu {

    public String title;
    public List<String> list;

    public EBankMenu(String title, List<String> list) {
        this.title = title;
        this.list = list;
    }

    public void display() {
        Stream.generate(() -> "=").limit(10).forEach(System.out::print);
        System.out.print(" "+ this.title + " ");
        Stream.generate(() -> "=").limit(10).forEach(System.out::print);
//        Stream.generate(() -> "=").limit(70).forEach(System.out::print);
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
//        System.out.println(Stream.generate(() -> "=").limit(70).collect(Collectors.joining()));
    }

    public int getChoice() {
        EBankInputter in = new EBankInputter();
        return in.inputPositiveInt("Please choose one option");
    }

    public abstract void execute(int choice);

    public void run() {
        int choice;
        do {
            display();
            choice = getChoice();
            execute(choice);
        } while (choice > 0 && choice <= list.size());
    }

}
