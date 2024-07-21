package day12;

public class CircularQueueBinarySearch {
	public static int search(int[] arr,int target) {
		int left=0,right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/ 2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[left]<=arr[mid]) {
				if(target>=arr[left]&& target<arr[mid]) {
					right =mid-1;
				}else {
					left=mid+1;
				}
			}else {
				if(target>arr[mid]&&target<=arr[right]) {
					left=mid+1;
				}else {
					right=mid-1;
				}
			}
		}
		return-1;
	}

	public static void main(String[] args) {
		int[] circularQueue= {4,5,6,7,0,1,2};
		int target=0;
		int result=search(circularQueue,target);
		if(result!=-1) {
			System.out.println("Element"+target+"found at index"+result);
			
		}else {
			System.out.println("Element"+target+"not found in the circular queue");
		// TODO Auto-generated method stub

	}
		target=3;
		result=search(circularQueue, target);
      if(result!=-1) {
    	  System.out.println("Element"+target+"found at index"+result);
      }else {
    	  System.out.println("Element"+target+"not found in the circular queue");
      }
}
}
