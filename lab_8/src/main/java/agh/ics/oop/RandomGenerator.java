package agh.ics.oop;

import java.util.*;

public class RandomGenerator {
    public static Random rng = new Random();

    public static void setSeed(int seed){
        rng = new Random(seed);
    }

    public static void getSeed(){
        long seed = rng.nextInt();
        System.out.println(seed);
    }

    public static int randint(int min, int max){
        return (int) ((rng.nextDouble() * (max - min) + min));
    }
}
