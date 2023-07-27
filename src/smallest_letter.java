public class smallest_letter {
   // https://leetcode.com/problems/find-smallest-letter-greater-than-target/

    public static void main(String[] args) {
    }

    // return the index: smallest number greater than = target
    static int ceiling(int[] letters, int target){
        // but what if the target is greater than the greatest number in the array
        if(target>letters[letters.length-1]){
            return -1;
        }

        int start =0;
        int end= letters.length-1;
        while(start<=end){
            //find the middle element
            //int mid=(start+end)/2; // might possible that(start+end) exceed the range of int in java
            int mid=start +(end-start)/2;
            if (target<letters[mid]){
                end =mid -1;
            }else if(target>letters[mid]){
                start=mid +1;
            }else {
                return mid;
            }
        }
        return start;
    }
}
