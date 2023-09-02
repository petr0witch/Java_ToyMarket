import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class WriteToFile {
    String filePath = "C:\\Users\\Kirill\\Desktop\\GeekBrains\\Итоговый проект по Java\\Toys\\src\\allToys.txt";
    // Метод для добавления данных в конец файла
    public void appendToFile(List<Toys> toysList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Toys toys : toysList) {
                writer.write(toyToString(toys));
                writer.newLine(); // Переходим на новую строку
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    // Метод для перезаписи файла данными из списка
    public void overwriteFile(List<Toys> toysList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Iterator<Toys> iterator = toysList.iterator();
            while (iterator.hasNext()) {
                Toys toys = iterator.next();
                if (toys.getCount() == 0) {
                    iterator.remove();
                } else {
                    writer.write(toyToString(toys));
                    writer.newLine(); // Переходим на новую строку
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    private String toyToString(Toys toy) {
        return toy.getId() + " " + toy.getName() + " " + toy.getCount() + " " + toy.getRandomValue();
    }

}



