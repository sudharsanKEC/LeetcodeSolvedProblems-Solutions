class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first=0,last=numbers.length-1;
        int[] arr=new int[2];
        while(first<last){
            if((numbers[first]+numbers[last])==target){
                arr[0]=first+1;
                arr[1]=last+1;
                return arr;
            }
            else if((numbers[first]+numbers[last])>target){
                last--;
            }else if((numbers[first]+numbers[last])<target){
                first++;
            }
        }   
        return arr;
    }
}
