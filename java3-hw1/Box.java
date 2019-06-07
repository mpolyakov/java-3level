import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box1;


    public Box (ArrayList<T> o){
        this.box1 = o;
    }

    public int getWeight(){
        int weight = 0;
        for (int i = 0; i < box1.size(); i++) {
            weight = weight + box1.get(i).getWEIGHT();

        }
        return weight;
    }
}
