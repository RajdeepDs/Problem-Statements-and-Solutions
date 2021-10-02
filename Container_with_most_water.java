public class Solution{
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0; i<height.length; i++)
        	for(int j=0; j<height.length; j++)
        		if(Math.min(height[i],height[j])*Math.abs(i-j)>=max)
        		max = Math.min(height[i],height[j])*Math.abs(i-j);
        
        return max;
    }
}