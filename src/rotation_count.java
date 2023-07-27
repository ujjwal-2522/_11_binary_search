public class rotation_count {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(countrotation(arr));
    }

    private static int countrotation(int[] arr) {
        int pivot=findthepivot(arr);
//        if(pivot==-1){
//           //array is not rorated
//            return 0;
//        }
        return pivot+1;
    }
    //use this for non duplicates
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
    //use this for duplicates
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
