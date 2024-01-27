package greedyAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class knapSack {

    private static class Item{
        int value;
        int weight;

        public String toString(){ //for custom objects we have to write the toString function for printing object.
            return (value + " " + weight);
        }
    }

    private static class ItemComparator implements Comparator<Item>{
        public int compare(Item i1,Item i2){
            if((i1.value/i1.weight) < (i2.value/i2.weight)){
                return 1;
            }
            else if((i1.value/i1.weight) > (i2.value/i2.weight)){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> value = List.of(60,100,150,120);
        List<Integer> weights = List.of(10,20,50,15);
        List<Item> itemsList = new ArrayList<>();
        for(int i=0;i<value.size();i++){
            Item item = new Item();
            item.value = value.get(i);
            item.weight = weights.get(i);
            itemsList.add(item);
        }
        itemsList.sort(new ItemComparator());
        System.out.println(itemsList);
        int w = 30;
        int profit = 0;

        for(int i=0;i<itemsList.size() && w>0;i++){
            Item item = itemsList.get(i);
            if(item.weight<=w){
                profit += item.value;
                w -= item.weight;
            }
            else{
                profit += (item.value) / item.weight * w;
                w=0; // as weight is full 
            }
        }
        System.out.println(profit);
    }
}
