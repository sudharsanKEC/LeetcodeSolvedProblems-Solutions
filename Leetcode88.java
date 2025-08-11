class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int midx=m-1;
        int nidx=n-1;
        int total=m+n-1;
        while(total>=0){
            if((nidx>=0&&midx>=0) && nums1[midx]>nums2[nidx]){
                nums1[total]=nums1[midx--];
            }
            else {
                if(nidx>=0)
                nums1[total]=nums2[nidx--];
            }
            total=total-1;
        }
    }
}
