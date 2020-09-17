package src;

public class prob26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0}));
    }
    static public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        
        int count = 1;

        for(int index = 1;index<nums.length;index++){
            if(nums[index-1]!=nums[index]){
                nums[count] = nums[index];
                //System.out.println(count+" "+index);
                count++;

            }
        }
        /*for(int a = 0;a<count;a++){
            System.out.print(nums[a]+" ");
        }
        System.out.println("");*/
        return count;
    }
}
