public class rotated_BS {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(findthepivot(arr));
    }

    static int search(int[] nums,int target){
        int pivot=findthepivot(nums);
        //if you do not find a pivot that means array is not rotated
        if(pivot==-1){
            // just do normal binary search
            return binarysearch(nums,target,0, nums.length-1);
        }
        //if pivot is found ,you have found 2 asc sorted array

        if(nums[pivot]==target){
            return pivot;
        }if(target>nums[0]){
            return binarysearch(nums,target,0,pivot-1);
        }
        return binarysearch(nums,target,pivot+1,nums.length-1);
    }
    static int binarysearch(int[] arr, int target,int start,int end){

        while(start<=end){
            //find the middle element
            //int mid=(start+end)/2; // might possible that(start+end) exceed the range of int in java
            int mid=start +(end-start)/2;
            if (target<arr[mid]){
                end =mid -1;
            }else if(target>arr[mid]){
                start=mid +1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    // this will not work for duplicate values
    static int findthepivot(int[] arr){
        int start=0;
        int end = arr.length-1;
        while(start<end){
            //4 case over here
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start &&arr[mid]<arr[mid-1]){
                return mid-1;
            }if (arr[start]>=arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
   // with duplicate elements
    static int findthepivotwithduplicates(int[] arr){
        int start=0;
        int end = arr.length-1;
        while(start<end){
            //4 case over here
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start &&arr[mid]<arr[mid-1]){
                return mid-1;
            }
            //if elements at start , mid,end are equal then skip the duplicates
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
               //skip the duplicates

                // NOTE: what if elements at start or end are pivot??
                // check if pivot
                if( arr[start]>arr[start+1]){
                    return start;
                }
                start++;

                //check end is pivot
                if(arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //left is sorted ,so pivot should be in right
            else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]){
                start=mid +1;
            }else {
                end =mid-1;
            }
        }
        return -1;
    }
}

