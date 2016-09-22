package LeetCodeOJ;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * The array may contain duplicates.
 * 
 */
public class FindMinRotatedSortArray_154 {
    /**
     * find the minimum of the array,but there are duplicate element
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            // 因为不重复所以 第一步判断起码有两个元素，
            // 否则一定是判断< ,没有=

            if (nums[low] < nums[high]) {
                return nums[low];
            } else {
                // low > high :说明在某一点翻转了数组
                int mid = low + (high - low) / 2;
                // 如果中间的比最右边的还大，那么最小的肯定在mid+1 - high
                // 否则 肯定在low,mid
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else if (nums[mid] < nums[high]) {
                    high = mid;
                } else {
                    // 如果中间值与high相等，那么high-1即可
                    high--;
                }

                /*
                 * if(nums[low] < nums[mid]){ low = mid + 1; }else if ( > ){
                 * high = mid; }else{ low +=1; }
                 */
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = { 7, 8, 9, 9, 9, 10, 2, 2, 2, 3, 4, 4, 5 }; // {1}
        System.out.println(new FindMinRotatedSortArray_154().findMin(nums));
    }
}
