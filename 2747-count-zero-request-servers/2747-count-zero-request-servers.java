import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort queries by time
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int[] result = new int[m];
        int left = 0, right = 0;
        int activeServersCount = 0;
        int[] serverCount = new int[n + 1];
        
        for (int i = 0; i < m; i++) {
            int qTime = sortedQueries[i][0];
            int qIndex = sortedQueries[i][1];
            int windowStart = qTime - x;
            int windowEnd = qTime;
            
            // Add logs that fall within or before windowEnd
            while (right < logs.length && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServersCount++;
                }
                serverCount[serverId]++;
                right++;
            }
            
            // Remove logs that fall before windowStart
            while (left < logs.length && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServersCount--;
                }
                left++;
            }
            
            result[qIndex] = n - activeServersCount;
        }
        
        return result;
    }
}