class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //add wordlist to set
        Set<String> set = new HashSet<>(wordList);

        //if no endword then 0
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();

        //add first word to queue
        q.offer(beginWord);  

        int level = 1;

        //bfs
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                String word = q.poll();

                //if we find the end word in queue we stop
                if(word.equals(endWord)) return level;

                //make an array of the word like 'h','i','t'

                char[] arr = word.toCharArray();
                for(int j=0; j<arr.length;j++) {

                    //save the character like 'h'
                    char original = arr[j];

                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        arr[j] = ch;  //replace that character with a-z letters 
                        String newWord = new String(arr); //make a new word of that replaced word 
                        if(set.contains(newWord)) {  //check if set/wordlist contains it
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    arr[j] = original;
                }
            }
            level++;
        }
        return 0;
    }
}