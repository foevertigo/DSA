class Solution {
    public int minPartitions(String n) {
        int maxnum = 0;

        for(char c:n.toCharArray()){
            maxnum=Math.max(maxnum, c-'0');
        }
        return maxnum;
    }
}