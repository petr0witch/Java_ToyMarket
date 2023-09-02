import java.util.HashMap;

public class Toys {
    ReadFile readFile = new ReadFile();
    HashMap<Integer, Toys> toysMap;
    private int id;
    private String name;
    private int count;
    private int randomValue;

    public Toys(int id, String name, int count, int randomValue) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.randomValue = randomValue;
    }


    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Count: " + this.getCount() + ", Random Value: " + this.getRandomValue();
    }


    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public int getRandomValue() {
        return randomValue;
    }
    public void setRandomValue(int randomValue) {
        this.randomValue = randomValue;
    }
}


