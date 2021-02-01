class Solution {
    public int[][] findContinuousSequence(int target) {
        
        if (target < 5)
            return new int[0][0];

        List<List<Integer>> list = new ArrayList<>();
        int start = 1, end = 2, curSum = 3;
        int p = target%2==0?target/2:target/2+1;

        while (end <= p) {
            if (curSum > target) {
                curSum -= start;
                start++;
            } else if (curSum < target) {
                end++;
                curSum += end;
            } else {
                List<Integer> temp = new ArrayList<>();
                for (int i = start; i <= end; i ++) {
                    temp.add(i);
                }

                list.add(temp);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }

        int[][] results = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            results[i] = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j ++) {
                results[i][j] = list.get(i).get(j);
            }
        }

        return results;
    }
}
