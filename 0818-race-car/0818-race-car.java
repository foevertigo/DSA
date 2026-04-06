class Solution {
    public int racecar(int target) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(new int[]{0,1});
        visited.add("0,1");

        int steps = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size;i++) {
                int[] curr = q.poll();
                int pos = curr[0];
                int speed = curr[1];

                if(pos == target) return steps;

                //A move

                int newpos = pos + speed;
                int newspeed = speed*2;

                String state1 = newpos + "," + newspeed;
                if(Math.abs(newpos)<=2*target && !visited.contains(state1)) {
                    visited.add(state1);
                    q.offer(new int[]{newpos, newspeed});
                }

                //R MOVE
                int revspeed = speed>0 ? -1 : 1;
                String state2 = pos + "," + revspeed;

                if(!visited.contains(state2)) {
                    visited.add(state2);
                    q.offer(new int[]{pos, revspeed});
                }
            }
            steps++;
        }

        return -1;
    }
}