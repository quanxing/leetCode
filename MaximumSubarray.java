package LeetCodeOJ;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		//O(n^2)
		int Max = Integer.MIN_VALUE;
	    for (int i=0;i< nums.length;i++){
	    	//记录每次从i开始的，j结束的 连续和
	    	int tmpMax = 0;
	    	for (int j=i;j<nums.length;j++){
	    		tmpMax += nums[j];
	    		//每做一次加法，与max比较，并取最大值
	    		if (tmpMax > Max){
	    			Max = tmpMax;
	    		}
	    	}
	    }
	    return Max;
	}	
	
	public static void main(String[] args) {
		MaximumSubarray max = new MaximumSubarray();
		int[]nums = {1};//{ -2,1,-3,4,-1,2,1,-5,4};
		System.out.println(max.maxSubArray(nums));
	}
}
