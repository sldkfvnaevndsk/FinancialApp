import java.util.Scanner;

public class CostsMenu {

    Scanner scanner;
    Costs costs;

    public CostsMenu() {
        scanner = new Scanner(System.in);
        costs = new Costs();
    }

    public void in() {
        while (true) {
            print();
            try {
                int commandCosts = Integer.parseInt(scanner.nextLine().trim());
                switch (commandCosts) {
                    case 0 -> System.out.println("Возвращаемся назад ..." + '\n');
                    case 1 -> costs.add();
                    case 2 -> costs.remove();
                    case 3 -> costs.print();
                    case 4 -> costs.sum();
                    default -> System.out.println("Такой команды не существует, попробуй ещё раз)" + '\n');
                }
                if (commandCosts == 0)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода команды, попробуй ещё раз)" + '\n');
            }
        }
    }

    public void print() {
        System.out.println("Расходы ):");
        System.out.println("0. Назад");
        System.out.println("1. Добавить расходы");
        System.out.println("2. Удалить расходы");
        System.out.println("3. Посмотреть расходы");
        System.out.println("4. Посмотреть суммарные расходы");
        System.out.println("Введите номер:");
    }
}
