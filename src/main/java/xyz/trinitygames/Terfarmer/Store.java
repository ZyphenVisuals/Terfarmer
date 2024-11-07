package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.animals.Animal;
import xyz.trinitygames.Terfarmer.animals.Chicken;
import xyz.trinitygames.Terfarmer.animals.Cow;
import xyz.trinitygames.Terfarmer.animals.Pig;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<Animal> stock = new ArrayList<>();
    private int size;

    public void refresh(){
        stock.clear();

        for(int i = 0; i < this.size; i++){
            Animal a;
            int c = (int) (Math.random() * 3);

            a = switch (c) {
                case 0 -> new Chicken();
                case 1 -> new Pig();
                case 2 -> new Cow();
                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

            stock.add(a);
        }
        stock.sort(null);
    }

    public Store() {
        this.size = 5;
        this.refresh();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i=0; i < this.size; i++) {
            s.append(i+1);
            s.append(". ");
            s.append(stock.get(i));
            s.append("\n");
        }
        return s.toString();
    }
}
