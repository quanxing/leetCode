package LeetCodeOJ;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		//O(n^2)
//		int Max = Integer.MIN_VALUE;
//	    for (int i=0;i< nums.length;i++){
//	    	//记录每次从i开始的，j结束的 连续和
//	    	int tmpMax = 0;
//	    	for (int j=i;j<nums.length;j++){
//	    		tmpMax += nums[j];
//	    		//每做一次加法，与max比较，并取最大值
//	    		if (tmpMax > Max){
//	    			Max = tmpMax;
//	    		}
//	    	}
//	    }
//		reutrn Max;
		
		if (nums.length == 0){
			return 0;
		}
		int Max = nums[0];
		int conSum = Max;
		
		for (int i=1; i< nums.length;i++){
			//如果  conSum + nums[i] 比 nums[i] 还要小, 说明前面的和可以丢弃,直接使用nums[i]  
			conSum = conSum + nums[i] > nums[i]?  conSum + nums[i]:nums[i];
			if (conSum > Max){
				Max = conSum;
			}
		}
		
	    return Max;
	}
	
	
	public static void main(String[] args) {
		MaximumSubarray max = new MaximumSubarray();
		int[]nums = { -2,1,-3,4,-1,2,1,-5,4};
		System.out.println(max.maxSubArray(nums));
	}
}
