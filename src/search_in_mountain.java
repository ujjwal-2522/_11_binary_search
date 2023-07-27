public class search_in_mountain {
    public static void main(String[] args) {
     int[] arr={1,2,3,4,5,4,3,2};
     int target=3;
     int ans=search(arr,target);
    }
    static int search(int[] arr, int target){
        int peak=peakIndexInMountainArray(arr);
        int firstTry=orderagnosticBS(arr,target,0,peak);
        if(firstTry!=-1){
            return firstTry;
        }
        //try to search in second half
        return orderagnosticBS(arr,target,peak+1,arr.length-1);

    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in decreasing part of the array
                // this may be the answer, but look at left
                //this is why end != mid-1
                end =mid;
            }else {
                // you are accessding part of array
                start=mid+1;//beacause we know that mid +1 is > than mid
            }
        }
        // in the end , start == end will pointing to the same element and largest element becoz of 2 upper case
        //start and end will always try to find max element in the above 2 cases
        //hence we are pointing to just one element, that is the max one
        return start;//or you can return end , becoz it both are pointing to same element
    }
    static int orderagnosticBS(int[] arr, int target,int start,int end){
        // find whether the sorted array is ascending or descending
//        boolean isAsc;
//        if(arr[start]<arr[end]){
//            isAsc=true;
//        }else {
//            isAsc=false;
//        }
        //OR
        boolean isAsc=arr[start]<arr[end];

        while(start<=end){
            //find the middle element
            //int mid=(start+end)/2; // might possible that(start+end) exceed the range of int in java
            int mid=start +(end-start)/2;

            if(target==arr[mid]){
                return mid;
            }
            if(isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }else{
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
