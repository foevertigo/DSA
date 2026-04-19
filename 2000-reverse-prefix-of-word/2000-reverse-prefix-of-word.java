class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int idx = -1;

        for(int i=0; i<arr.length;i++) {
            if(arr[i]==ch) {
                idx = i;
                break;
            }
        }

        if(idx==-1) return word;
        int l=0, r=idx;
        while(l<r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return new String(arr);
    }
}