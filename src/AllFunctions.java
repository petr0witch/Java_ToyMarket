import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AllFunctions {
    String filePath = "C:\\Users\\Kirill\\Desktop\\GeekBrains\\Итоговый проект по Java\\Toys\\src\\allToys.txt";
    List <Toys> toysList = new ArrayList<>();
    private WriteToFile writer = new WriteToFile();
    private ReadFile readFile = new ReadFile();

    public void addNew() {
        System.out.println("Введите через пробел все параметры игрушки: id, name, count, randValue ");
        Scanner sc = new Scanner(System.in);
        String newData = sc.nextLine();
        String [] splitData = newData.split(" ");

        if (splitData.length == 4) {
            int id = Integer.parseInt(splitData[0]);
            String name = splitData[1];
            int count = Integer.parseInt(splitData[2]);
            int randomValue = Integer.parseInt(splitData[3]);

            Toys newToy = new Toys(id, name, count, randomValue);
            toysList.add(newToy);

            writer.appendToFile(toysList);
        } else {
            System.out.println("Неверный формат данных. Пожалуйста, введите данные в формате: id name count randValue");
        }
    }
    public void changeToy() {
        List<Toys> toysList = readFile.getToysList();

        System.out.println("Введите ID игрушки, для которой нужно изменить RandomValue:");
        Scanner sc = new Scanner(System.in);
        int idToChange = sc.nextInt();

        for (Toys toys : toysList) {
            if (toys.getId() == idToChange) {

                System.out.println("Введите новое значение RandomValue:");
                int newRandomValue = sc.nextInt();
                toys.setRandomValue(newRandomValue);
                System.out.println("RandomValue для игрушки с ID " + idToChange + " успешно изменено.");

                // После изменения в памяти, вызываем метод для записи обновленного списка в файл
                writer.overwriteFile(toysList);
                break;

            }
        }

    }
    public void playGame() {
        List<Toys> toysList = readFile.getToysList();

        System.out.println("Введите ID игрушки, которую хотели бы выиграть: ");
        Scanner sc = new Scanner(System.in);
        int idToWin = sc.nextInt();

        for (Toys toys : toysList) {
            if (toys.getId() == idToWin) {

                Random random = new Random();
                int randNumber = random.nextInt(100);

                if (randNumber <= toys.getRandomValue()) {
                    toys.setCount(toys.getCount() - 1);
                    System.out.printf("Число = %s, Вы выиграли %s%n", randNumber, toys.getName());
                }
                else System.out.println("Попробуйте еще раз :с " + randNumber);

//              После изменения в памяти, вызываем метод для записи обновленного списка в файл
                writer.overwriteFile(toysList);
                break;

            }
        }
    }
}


