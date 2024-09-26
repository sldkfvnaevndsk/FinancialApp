import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Costs {

    Scanner scanner;
    HashMap<String, ArrayList<Double>> costs;
    ArrayList<Double> productExpenses;
    ArrayList<Double> healthExpenses;
    ArrayList<Double> transportExpenses;
    ArrayList<Double> giftExpenses;
    ArrayList<Double> entertainmentExpenses;
    StringBuilder toCategory;
    String productCategory;
    String healthCategory;
    String transportCategory;
    String giftCategory;
    String entertainmentCategory;

    public Costs() {
        scanner = new Scanner(System.in);
        costs = new HashMap<>();
        productExpenses = new ArrayList<>();
        healthExpenses = new ArrayList<>();
        transportExpenses = new ArrayList<>();
        giftExpenses = new ArrayList<>();
        entertainmentExpenses = new ArrayList<>();
        toCategory = new StringBuilder();
        productCategory = "Продукты";
        healthCategory = "Здоровье";
        transportCategory = "Транспорт";
        giftCategory = "Подарки";
        entertainmentCategory = "Развлечения";

        costs.put(productCategory, productExpenses);
        costs.put(healthCategory, healthExpenses);
        costs.put(transportCategory, transportExpenses);
        costs.put(giftCategory, giftExpenses);
        costs.put(entertainmentCategory, entertainmentExpenses);
    }

    public void add() {
        double newCosts;
        boolean isEqual = false;
        printCategories();
        try {
            System.out.println("Куда добавить расходы?");
            toCategory = new StringBuilder(scanner.nextLine().trim());
            for (String category : costs.keySet()) {
                if (toCategory.toString().equals(category)) {
                    System.out.println("Сколько расходов внести?");
                    newCosts = Double.parseDouble(scanner.nextLine().trim());
                    if (toCategory.toString().equals(productCategory)) {
                        productExpenses.add(newCosts);
                    } else if (toCategory.toString().equals(healthCategory)) {
                        healthExpenses.add(newCosts);
                    } else if (toCategory.toString().equals(transportCategory)) {
                        transportExpenses.add(newCosts);
                    } else if (toCategory.toString().equals(giftCategory)) {
                        giftExpenses.add(newCosts);
                    } else if (toCategory.toString().equals(entertainmentCategory)) {
                        entertainmentExpenses.add(newCosts);
                    }
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Такой категории не существует, попробуй ещё раз)" + '\n');
        }
    }

    public void remove() {
        double oldCosts;
        boolean isEqual = false;
        printCategories();
        try {
            System.out.println("Откуда удалить расходы?");
            toCategory = new StringBuilder(scanner.nextLine().trim());
            for (String category : costs.keySet()) {
                if (toCategory.toString().equals(category)) {
                    System.out.println("Какие расходы удалить?");
                    oldCosts = Double.parseDouble(scanner.nextLine().trim());
                    if (toCategory.toString().equals(productCategory)) {
                        productExpenses.remove(oldCosts);
                    } else if (toCategory.toString().equals(healthCategory)) {
                        healthExpenses.remove(oldCosts);
                    } else if (toCategory.toString().equals(transportCategory)) {
                        transportExpenses.remove(oldCosts);
                    } else if (toCategory.toString().equals(giftCategory)) {
                        giftExpenses.remove(oldCosts);
                    } else if (toCategory.toString().equals(entertainmentCategory)) {
                        entertainmentExpenses.remove(oldCosts);
                    }
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Такой категории не существует, попробуй ещё раз)" + '\n');
        }
    }

    public void print() {
        boolean isEqual = false;
        printCategories();
        try {
            System.out.println("Из какой категории показать расходы?");
            toCategory = new StringBuilder(scanner.nextLine().trim());
            for (String category : costs.keySet()) {
                if (toCategory.toString().equals(category)) {
                    printExpenses(toCategory.toString());
                    isEqual = true;
                    break;
                }
            }
            if (!isEqual) {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Такой категории не существует, попробуй ещё раз)" + '\n');
        }
    }

    public void sum() {
        double sum = 0;
        for (String category : costs.keySet())
            for (double expense : costs.get(category))
                sum += expense;
        if (sum == 0)
            System.out.println("Расходов нет" + '\n');
        else
            System.out.println("Всего расходов на " + sum + " руб." + '\n');
    }

    public void printCategories() {
        System.out.println("Имеющиеся категории:");
        for (String category : costs.keySet())
            System.out.println(category);
        System.out.print('\n');
    }

    public void printExpenses(String category) {
        if (costs.get(category).isEmpty()) {
            System.out.println("Расходов нет" + '\n');
        } else {
            for (double expense : costs.get(category))
                System.out.println(expense + " руб.");
            System.out.print('\n');
        }
    }
}
