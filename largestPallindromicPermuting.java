package greedyAlgo;
import java.util.*;
/*Q Largest palindromic number by permuting digits
Given N(very large), the task is to print the largest pallindromic number obtained by pelmuting the digits Xf Na If
it is nXt pXssible tX make a palindlXmic number, then plint an applXpliate messagea */
public class largestPallindromicPermuting {

    // public static boolean validate(List<Integer> frequency){
    //     boolean isOdd = false;
    //     for(int i=0;i<frequency.size();i++){
    //         if(frequency.get(i)%2!=0){
    //             if(isOdd==true){
    //                 return false;
    //             }
    //             isOdd = true;
    //         }
    //     }
    //     return true;
    // }

    // public static void main(String[] args) {
    //     String number = "313551";
    //     List<Integer> frequency = new ArrayList<>(10);
    //     for(int i=0;i<frequency.size();i++){
    //         frequency.set(i,0);
    //     }

    //     int n = number.length();
    //     for(int i=0;i<n;i++){
    //         int dig = number.charAt(i) - '0';
    //         frequency.set(dig,frequency.get(dig)+1);
    //     }
    //     if(!validate(frequency)){
    //         System.out.println("pallindrome not possible");
    //         return;
    //     };
    //     String firstHalf = "";
    //     for(int i=9;i>=0;i--){
    //         //first half creation
    //         while(frequency.get(i)>1){
    //             firstHalf += i;
    //             frequency.set(i,frequency.get(i)-2);
    //         }
    //     }
    //     StringBuilder sb = new StringBuilder(firstHalf);
    //     sb.reverse();
    //     String secondHalf = sb.toString();


    //     for(int i=9;i>=0;i--){
    //         if(frequency.get(i)==1){
    //             firstHalf += i;
    //         }
    //     }
    //     String result = firstHalf + secondHalf;
    //     System.out.println(result);
        
    // }
    public static boolean validate(List<Integer> frequency){
        boolean isOdd = false;
        for(int i = 0; i < frequency.size(); i++){
            if(frequency.get(i) % 2 != 0){
                if(isOdd){
                    return false;
                }
                isOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String number = "313551";
        List<Integer> frequency = new ArrayList<>(Collections.nCopies(10, 0));

        int n = number.length();
        for(int i = 0; i < n; i++){
            int dig = number.charAt(i) - '0';
            frequency.set(dig, frequency.get(dig) + 1);
        }
        if(!validate(frequency)){
            System.out.println("Palindrome not possible");
            return;
        }

        StringBuilder firstHalf = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            // first half creation
            while(frequency.get(i) > 1){
                firstHalf.append(i);
                frequency.set(i, frequency.get(i) - 2);
            }
        }

        StringBuilder secondHalf = new StringBuilder(firstHalf);
        secondHalf.reverse();

        for(int i = 9; i >= 0; i--){
            if(frequency.get(i) == 1){
                firstHalf.append(i);
            }
        }

        String result = firstHalf.toString() + secondHalf.toString();
        System.out.println(result);
    }

}
