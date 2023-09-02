import java.io.*;
import java.util.*;

public class ReadFile {
    private String filePath = "C:\\Users\\Kirill\\Desktop\\GeekBrains\\Итоговый проект по Java\\Toys\\src\\allToys.txt";
    private List<Toys> toysList = new ArrayList<>();
    private HashMap<Integer, Toys> toysHashMap = new HashMap<>();

    public List<Toys> showAllToys() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int count = Integer.parseInt(parts[2]);
                    int randomValue = Integer.parseInt(parts[3]);

                    Toys toy = new Toys(id, name, count, randomValue);

                    toysList.add(toy);
                    toysHashMap.put(id, toy);

                } else {
                    System.out.println("Ошибка в строке: " + line);
                }
            }
            //
        } catch (IOException e) {
            System.out.println("Файл не найден: " + filePath);
        }
        return toysList;

    }
    public List<Toys> getToysList() {
        ReadFile reader = new ReadFile();
        List<Toys> toysList = reader.showAllToys();
        // Выводим список игрушек на экран
        for (Toys toy : toysList) {
            System.out.println("id: " + toy.getId() + ", Name: " + toy.getName() +
                    ", Count: " + toy.getCount() + ", Random Value: " + toy.getRandomValue() + "%");
        }

        return toysList;
    }

    public static void main(String[] args) {
        ReadFile reader = new ReadFile();
        List<Toys> toysList = reader.showAllToys();

        for (Toys toys : toysList) {
            System.out.println("id: " + toys.getId() + ", toy: " + toys.toString());
        }
    }

    public HashMap<Integer, Toys> getToysHashMap() {
        return toysHashMap;
    }
}

