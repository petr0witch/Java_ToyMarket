import java.util.List;

/*
    Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ReadFile reader = new ReadFile();
        List<Toys> toysList = reader.showAllToys();

        ViewUser uv = new ViewUser();
        uv.start();
    }
}


