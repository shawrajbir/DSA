import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Precompute number of valid j != i where factor[i] divides factor[j]
        int[] gainByFactor = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] == 0) continue;
            int totalMultiples = 0;
            for (int m = f; m <= n; m += f) {
                totalMultiples += freq[m];
            }
            gainByFactor[f] = totalMultiples - 1;
        }

        // Sort items by price ascending
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long totalItems = 0;
        long remBudget = budget;

        // Greedily buy value-2 marginal units (1 paid + 1 free)
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = gainByFactor[factor];

            if (gain == 0) continue;
            // Buying 2 of the cheapest item is better or equal if price >= 2 * minPrice
            if ((long) price >= 2L * minPrice) break;

            long canBuy = Math.min((long) gain, remBudget / price);
            totalItems += canBuy * 2;
            remBudget -= canBuy * price;
        }

        // Spend remaining budget on value-1 units using the cheapest item
        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}