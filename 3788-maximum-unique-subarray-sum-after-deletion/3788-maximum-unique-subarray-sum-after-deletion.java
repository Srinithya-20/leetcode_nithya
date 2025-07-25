import java.util.Arrays;

class Solution {
    public int maxSum(int[] numbers) {
        Arrays.sort(numbers); 
        int previous = numbers[numbers.length - 1]; 
        int result = previous; 
        for (int index = numbers.length - 2; index >= 0; index--) {
            int currentValue = numbers[index];
            if (currentValue <= 0) return result; 
            if (currentValue != previous) result += currentValue; 
            previous = currentValue; 
        }
        return result; 
    }
}