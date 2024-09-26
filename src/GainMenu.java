import java.util.Scanner;

public class GainMenu {

    Scanner scanner;
    Gain gain;

    public GainMenu() {
        scanner = new Scanner(System.in);
        gain = new Gain();
    }

    public void in() {
        while (true) {
            print();
            try {
                int commandGain = Integer.parseInt(scanner.nextLine().trim());
                switch (commandGain) {
                    case 0 -> System.out.println("Возвращаемся назад ..." + '\n');
                    case 1 -> gain.add();
                    case 2 -> gain.remove();
                    case 3 -> gain.print();
                    case 4 -> gain.sum();
                    default -> System.out.println("Такой команды не существует, попробуй ещё раз)" + '\n');
                }
                if (commandGain == 0)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода команды, попробуй ещё раз)" + '\n');
            }
        }
    }

    public void print() {
        System.out.println("Доходы (:");
        System.out.println("0. Назад");
        System.out.println("1. Добавить доходы");
        System.out.println("2. Удалить доходы");
        System.out.println("3. Посмотреть доходы");
        System.out.println("4. Посмотреть суммарные доходы");
        System.out.println("Введите номер:");
    }
}
