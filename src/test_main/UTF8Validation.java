package test_main;

public class UTF8Validation {

    public boolean validUtf8(int[] data) {
        boolean isFirst = true;
        int needN = 0;
        for(int i = 0, j = data.length; i < j; i ++){
        	int x = getOne(data[i]);
        	if(x > 4)
        		return false;
        	if(isFirst){
        		if(x == 1)
        			return false;
        		if(x == 0)
        			continue;
    			needN = x - 1;
    			isFirst = false;
        	}else{
        		if(x != 1)
        			return false;
        		needN --;
        		if(needN == 0)
        			isFirst = true;
        	}
        }
        if(needN != 0)
        	return false;
        return true;
    }
    
    private int getOne(int n){
    	int r = 0;
    	for(int i = 7; i >= 0; i --){
    		if(n >>> i == Math.pow(2, 8 - i) - 1)
    			r ++;
    		else
    			break;
    	}
    	return r;
    }
	
	public static void main(String[] args) {
		int[] data = {197, 130, 1};
		System.out.println(new UTF8Validation().validUtf8(data));
	}

}
