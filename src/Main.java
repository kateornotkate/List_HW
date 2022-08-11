import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shopList = new ArrayList<>();

        while (true) {
            System.out.println("\nВыберите операцию и введите её номер:" +
                    "\n1 - Добавить товар в список покупок" +
                    "\n2 - Показать список покупок" +
                    "\n3 - Удалить товар из списка покупок" +
                    "\n4 - Найти товар в списке покупок" +
                    "\nexit");

            String command = scanner.nextLine().trim();
            if (command.equals("exit")) {
                System.out.println("Программа завершена.");
                break;
            }
            if (command.isEmpty()) {
                continue;
            }

            int operation = Integer.parseInt(command);
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить? ");
                    String input = scanner.nextLine().toLowerCase();
                    if (input.isEmpty()) { // программа не добавит пустую строку в список;
                        break;
                    }
                    shopList.add(input);
                    System.out.println("Итого в списке покупок: " + shopList.size());
                    break;
                case 2:
                    printList(shopList);
                    break;
                case 3:
                    printList(shopList);
                    System.out.println("Какую покупку хотите удалить? Введите её номер или название:");
                    String stringInput = scanner.nextLine().trim().toLowerCase();
                    int numItem = 0;
                    if (stringInput.isEmpty()) {
                        break;
                    }
                    try {
                        numItem = Integer.parseInt(stringInput);
                    } catch (NumberFormatException e) {
                    }
                    boolean isDeleted = false;
                    for (int j = 0; j < shopList.size(); j++) {
                        String item = shopList.get(j);
                        if ((numItem - 1) == j || stringInput.toLowerCase().equals(item.toLowerCase())) {
                            shopList.remove(j);
                            isDeleted = true;
                            System.out.println("Покупка " + item + " удалена.");
                            break;
                        }
                    }
                    if (!isDeleted) {
                        System.out.println("Такого товара в списке покупок нет.");
                    }
                    printList(shopList);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String query = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено: ");
                    for (int s = 0; s < shopList.size(); s++) {
                        String searchItem = shopList.get(s).toLowerCase();
                        if (searchItem.contains(query)) {
                            System.out.println((s + 1) + ". " + searchItem);
                        }
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static void printList(List<String> shopList) {
        if (shopList.size() == 0) {
            System.out.println("Ваш список продуктов пуст.");
        } else {
            System.out.println("Ваш список покупок:");
            for (int i = 0; i < shopList.size(); i++) {
                System.out.println((i + 1) + ". " + shopList.get(i));
            }
        }
    }
}