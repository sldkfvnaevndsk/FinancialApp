import java.util.Scanner;

public class FinancialApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CostsMenu costsMenu = new CostsMenu();
        GainMenu gainMenu = new GainMenu();

        while(true) {
            printMenu();
            try {
                int commandMain = Integer.parseInt(scanner.nextLine().trim());
                switch (commandMain) {
                    case 0 -> System.out.println("Выходим ...");
                    case 1 -> costsMenu.in();
                    case 2 -> gainMenu.in();
                    default -> System.out.println("Такой команды не существует, попробуй ещё раз)" + '\n');
                }
                if (commandMain == 0)
                    break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода команды, попробуй ещё раз)" + '\n');
            }
        }
    }

    public static void printMenu() {
        System.out.println("Финансовое приложение <3");
        System.out.println("0. Выход");
        System.out.println("1. Расходы");
        System.out.println("2. Доходы");
        System.out.println("Введите номер:");
    }
}
