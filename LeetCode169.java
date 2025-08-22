class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length<=2) return nums[0];
        int newElement = nums[0];
        int currCount = 1;
        for(int i = 1; i < nums.length; i++){
            if(newElement==nums[i]){
                currCount++;
            }
            else{
                currCount--;
            }
            if(currCount <= 0){
                newElement = nums[i];
                currCount = 1;
            }
        }
        return newElement;
    }
}
