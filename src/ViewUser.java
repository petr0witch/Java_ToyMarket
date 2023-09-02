import java.util.List;
import java.util.Scanner;

public class ViewUser {
    AllFunctions allFunctions = new AllFunctions();

    public void start(){
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Hello, welcome to the ToysMarket! \nSelect your choice: \n" +
                    "1. Show all toys in Game \n2. Add new toy in list \n3. Change toy's % of the win \n" +
                    "4. Try to win the toy");
            short choice = sc.nextShort();

            switch (choice) {
                case 1 -> {
                    // Получаем список игрушек
                    ReadFile reader = new ReadFile();
                    reader.getToysList();
                }
                case 2 -> allFunctions.addNew();
                case 3 -> allFunctions.changeToy();
                case 4 -> allFunctions.playGame();
//
                default -> start();
            }
        }
    }

}
