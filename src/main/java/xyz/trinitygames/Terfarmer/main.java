package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.animals.Cow;
import xyz.trinitygames.Terfarmer.animals.Animal;

public class main {
    public static void main(String[] args) {
        Animal a = new Cow();
        while(a.getLifetime() > 0) {
            System.out.println(a);
            a.age();
        }
        System.out.println(a);
        a.age();
    }
}
