class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int mex = 0;
        int[] arr = new int[value];
        int n = nums.length;
        for(int i =0;i<n;i++){
            int temp = ((nums[i]%value)+value)%value;
            arr[temp]++;
        }
        while(true){
            int r = mex%value;
            if(arr[r]>0){
                arr[r]--;
                mex++;
            }
            else{
                break;
            }
        }
        return mex;
    }
}