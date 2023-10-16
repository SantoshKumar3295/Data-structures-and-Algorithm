import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] servers, int x, int[] queries) {
        int m = servers.length;
        List<int[]> serversList = new ArrayList<>();
        
        // Convert servers array to a list of pairs: [time, serverId]
        for (int[] server : servers) {
            serversList.add(new int[]{server[1], server[0]});
        }
        
        // Sort serversList based on time
        Collections.sort(serversList, (a, b) -> a[0] - b[0]);

        int q = queries.length;
        Map<Integer, Integer> serverMap = new HashMap<>();

        int[] result = new int[q];
        List<int[]> queryTimes = new ArrayList<>();
        
        // Convert queries array to a list of pairs: [queryTime, index]
        for (int i = 0; i < q; i++) {
            queryTimes.add(new int[]{queries[i], i});
        }
        
        // Sort queryTimes based on queryTime
        Collections.sort(queryTimes, (a, b) -> a[0] - b[0]);

        int startIdx = 0; // Start of the window
        int endIdx = 0;   // End of the window
        
        for (int[] queryTime : queryTimes) {
            int curTime = queryTime[0];
            int queryIndex = queryTime[1];

            int startTime = Math.max(0, curTime - x);
            int endTime = curTime;

            // Move endIdx until the time is not greater than endTime
            while (endIdx < m && serversList.get(endIdx)[0] <= endTime) {
                int serverId = serversList.get(endIdx)[1];
                serverMap.put(serverId, serverMap.getOrDefault(serverId, 0) + 1);
                endIdx++;
            }

            // Move startIdx until the time is not greater than or equal to startTime
            while (startIdx < m && serversList.get(startIdx)[0] < startTime) {
                int serverId = serversList.get(startIdx)[1];
                if (serverMap.getOrDefault(serverId, 0) == 1) {
                    serverMap.remove(serverId);
                } else {
                    serverMap.put(serverId, serverMap.get(serverId) - 1);
                }
                startIdx++;
            }

            // Calculate the result for this query
            result[queryIndex] = n - serverMap.size();
        }

        return result;
    }
}
