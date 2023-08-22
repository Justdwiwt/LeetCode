package main.java;

public class Solution_443 {
    public int compress(char[] chars) {
        int ans=0,count=1;
        for(int i=1;i<=chars.length;i++){
            if(i<chars.length&&chars[i]==chars[i-1]){count++;}
            else{
                chars[ans]=chars[i-1];
                ans++;
                if(count>1){
                    for(char c:String.valueOf(count).toCharArray()){
                        chars[ans]=c;
                        ans++;
                    }
                }
                count=1;
            }
        }
        return ans;
    }
}
