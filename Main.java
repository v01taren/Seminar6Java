import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Acer", 8, 512, "Windows", "Silver", "Acer"));
        notebooks.add(new Notebook("Dell", 16, 256, "Windows", "Black", "Dell"));
        notebooks.add(new Notebook("HP", 12, 512, "Linux", "Blue", "HP"));
        // Добавьте еще ноутбуки по необходимости

        // Вызов метода для фильтрации ноутбуков
        Map<String, Object> filterCriteria = getFilterCriteriaFromUser();
        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);

        // Выводим отфильтрованные ноутбуки
        for (Notebook notebook : filteredNotebooks) {
            System.out.println("Модель: " + notebook.getModel() +
                    ", RAM: " + notebook.getRAM() +
                    ", HDD: " + notebook.getHDD() +
                    ", Операционная система: " + notebook.getOperationSystem() +
                    ", Цвет: " + notebook.getColor() +
                    ", Производитель: " + notebook.getVendor());
        }
    }

    // Метод для получения критериев фильтрации от пользователя
    private static Map<String, Object> getFilterCriteriaFromUser() {
        Scanner Scanner = new Scanner(System.in);
        Map<String, Object> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - RAM");
        System.out.println("2 - HDD");
        System.out.println("3 - Operation System");
        System.out.println("4 - Color");
        System.out.println("5 - Vendor");

        int choice = Scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Введите минимальное значение RAM:");
                int minRAM = Scanner.nextInt();
                filterCriteria.put("RAM", minRAM);
                break;
            case 2:
                System.out.println("Введите минимальное значение HDD:");
                int minHDD = Scanner.nextInt();
                filterCriteria.put("HDD", minHDD);
                break;
            case 3:
                System.out.println("Введите операционную систему:");
                String os = Scanner.next();
                filterCriteria.put("Operation System", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = Scanner.next();
                filterCriteria.put("Color", color);
                break;
            case 5:
                System.out.println("Введите производителя:");
                String vendor = Scanner.next();
                filterCriteria.put("Vendor", vendor);
                break;
            default:
                System.out.println("Некорректный выбор критерия.");
        }
        return filterCriteria;
    }

    // Метод для фильтрации ноутбуков по заданным критериям
    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            boolean meetsCriteria = true;
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key.equals("RAM")) {
                    int minRAM = (int) value;
                    if (notebook.getRAM() < minRAM) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (key.equals("HDD")) {
                    int minHDD = (int) value;
                    if (notebook.getHDD() < minHDD) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (key.equals("Operation System")) {
                    String os = (String) value;
                    if (!notebook.getOperationSystem().equals(os)) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (key.equals("Color")) {
                    String color = (String) value;
                    if (!notebook.getColor().equals(color)) {
                        meetsCriteria = false;
                        break;
                    }
                } else if (key.equals("Vendor")) {
                    String vendor = (String) value;
                    if (!notebook.getVendor().equals(vendor)) {
                        meetsCriteria = false;
                        break;
                    }
                }
            }
            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}