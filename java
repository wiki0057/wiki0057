import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLista Zadań:");
            displayTasks();
            System.out.println("\nWybierz opcję:");
            System.out.println("1. Dodaj zadanie");
            System.out.println("2. Usuń zadanie");
            System.out.println("3. Wyświetl wszystkie zadania");
            System.out.println("4. Wyjdź");
            System.out.print("Twój wybór: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumowanie nowej linii

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
        System.out.println("Koniec programu.");
    }

    private static void addTask() {
        System.out.print("Wpisz nowe zadanie: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Zadanie dodane.");
    }

    private static void removeTask() {
        displayTasks();
        System.out.print("Wpisz numer zadania do usunięcia: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Konsumowanie nowej linii
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Zadanie usunięte.");
        } else {
            System.out.println("Nieprawidłowy numer zadania.");
        }
    }

    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Brak zadań.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
