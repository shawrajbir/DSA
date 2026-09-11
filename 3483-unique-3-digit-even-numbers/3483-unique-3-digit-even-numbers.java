class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int d : digits) {
            count[d]++;
        }
        
        int total = 0;
        
        for (int num = 100; num <= 998; num += 2) {
            int d1 = num / 100;       // Hundreds digit
            int d2 = (num / 10) % 10; // Tens digit
            int d3 = num % 10;        // Units digit
            
            int[] req = new int[10];
            req[d1]++;
            req[d2]++;
            req[d3]++;
            
            if (req[d1] <= count[d1] && req[d2] <= count[d2] && req[d3] <= count[d3]) {
                total++;
            }
        }
        
        return total;
    }
}