public class infinite_Array {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,12,13,45,67,89,97,105,153,198};
        int target=89;
        System.out.println(ans(arr,target));
    }
    static int ans(int[] arr,int target){
        //first find the range
        //we start with the size of  box 2
        int start=0;
        int end =1;

        //condition for the target to lie in the range i.e target<end
        //while target > end keep doubling
        while(target>arr[end]){
            int temp=end+1;// temp is new start
            //double the box value
            //end is = previous end +sizeof box *2;
            end=end+ (end-start +1)*2;
            start=temp;
        }
        return binarysearch(arr,target,start,end);


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
}
