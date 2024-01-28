package greedyAlgo;

public class surviveOnIsland {
    public static void main(String[] args) {
        int s = 10; //no of days to survive.
        int n = 16; // max unit you can buy from mon-sat.
        int m = 2; // har din consume (sunday ko hm ni jaa skte kharidne)

        int total_food_required = s*m;
        int result;

        //1 week consumption > 1 week buying ->  to mar jaoge bhai
        if(m>n || 7*m > 6*n){
            result = -1;
        }
        else{
            result = (int) Math.ceil((double) total_food_required / n);
            //ceil - rounding off to upper number.
        }
        System.out.println(result);
    }
}
