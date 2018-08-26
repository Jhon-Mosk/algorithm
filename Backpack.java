package Lesson_5;

import java.util.ArrayList;

public class Backpack {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, 3));
        items.add(new Item(2, 10));
        items.add(new Item(3, 3));
        items.add(new Item(4, 7));
        maxCostOfItems(3, new ArrayList<Integer>(), items, items);
    }

    private static class Item {
        private int weight;
        private int cost;

        private Item(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        public int getWeight() {
            return weight;
        }

        public int getCost() {
            return cost;
        }
    }

    private static void maxCostOfItems(int maxWeight, ArrayList<Integer> integers, ArrayList<Item> items,
                                      ArrayList<Item> origItems) {
        int maxCost=0;
        if (items.isEmpty()) {
            int x = 0;
            for (int i = 0; i < integers.size(); i++) {
                x += integers.get(i);
            }
            if (x <= maxWeight) {
                System.out.println(integers.toString());
                System.out.println(x);
                int returnCost = cost(integers, origItems);
                if (returnCost>maxCost){
                    maxCost += returnCost;
                }

                System.out.println("Максимальная стоимость с максимальным весом " + maxWeight + " равна: " + maxCost);

            }


        } else {
            for (int i = 0; i < items.size(); i++) {
                ArrayList<Integer> newConstItem = new ArrayList<>(integers);
                newConstItem.add(items.get(i).weight);
                ArrayList<Item> newLast = new ArrayList<>(items);
                newLast.remove(newLast.get(i));
                maxCostOfItems(maxWeight, newConstItem, newLast, origItems);
                maxCostOfItems(maxWeight, integers, newLast, origItems);
            }
        }
    }

    private static int cost(ArrayList<Integer> integers, ArrayList<Item> items) {
        int costIntegers = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.isEmpty()) continue;
            costIntegers += items.get(integers.get(i) - 1).cost;
        }
        System.out.println("Стоимость: " + costIntegers);
        return costIntegers;
    }
}
