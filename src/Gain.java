import java.util.Scanner;
import java.util.ArrayList;

public class Gain {

    Scanner scanner;
    ArrayList<Double> gain;

    public Gain() {
        scanner = new Scanner(System.in);
        gain = new ArrayList<>();
    }

    public void add() {
        System.out.println("Введите доходы:");
        try {
            double newGain = Double.parseDouble(scanner.nextLine().trim());
            if (newGain < 0) {
                throw new IllegalArgumentException();
            }
            gain.add(newGain);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода дохода, попробуй ещё раз)" + '\n');
        } catch (IllegalArgumentException e) {
            System.out.println("Доход не может быть отрицательным, попробуй ещё раз)" + '\n');
        }
    }

    public void remove() {
        System.out.println("Удалите доходы:");
        try {
            double oldGain = Double.parseDouble(scanner.nextLine().trim());
            gain.remove(oldGain);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода дохода, попробуй ещё раз)" + '\n');
        }
    }

    public void print() {
        if (gain.isEmpty()) {
            System.out.println("Доходов нет" + '\n');
        } else {
            for (double g : gain)
                System.out.println(g + " руб.");
            System.out.print('\n');
        }
    }

    public void sum() {
        double sum = 0;
        if (gain.isEmpty()) {
            System.out.println("Доходов нет" + '\n');
        } else {
            for (double g : gain)
                sum += g;
            System.out.println("Всего доходов на " + sum + " руб." + '\n');
        }
    }
}
