import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java. Generic
 *
 * @author Mikhail Polyakov
 * @version dated Jun 10th, 2019
 */

public class J3hw1Generics {
    public static void main(String[] args) {
        Integer b[] = {1, 2, 3, 4, 5, 6, 7};
        String s[] = {"uno", "momento", "secondo", "kvinteto"};
        Array<Integer> arrInt = new Array<Integer>(b);
        Array<String> arrStr = new Array<String>(s);
        arrInt.change(4, 5);
        arrStr.change(0, 2);

    }


    public static <T> ArrayList<T> changing(T[] msv) {
        return new ArrayList<T>(Arrays.asList(msv));
    }

}

class Array<T> {
    private T[] obj;

    public Array(T[] obj) {
        this.obj = obj;
    }

    public void change(int first, int second) {
        T shelf;
        shelf = obj[first];
        obj[first] = obj[second];
        obj[second] = shelf;
        System.out.println(Arrays.toString(obj));

    }
}

abstract class Fruit {
    float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    private float weight = 1.0f;

    public Apple(float weight) {
        super(weight);
    }

}

class Orange extends Fruit {
    private float weight = 1.5f;

    public Orange(float weight) {
        super(weight);
    }
}

class Box<T extends Fruit> {
    private ArrayList<T> bx;

    public void addFruit(T fruit) {
        bx.add(fruit);
    }

    public float getWeight() {
        if (bx.size() == 0) {
            return 0.0f;
        }
        return bx.get(0).getWeight() * bx.size();
    }

    public Box(T... args) {
        bx = new ArrayList<T>(Arrays.asList(args));
    }

    public boolean sravn(Box another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.000001;
    }

    public void change(Box<T> another) {
        another.bx.addAll(this.bx);
        this.bx.clear();
    }


}

























