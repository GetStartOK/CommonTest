package test_main;

public class EliminationGame {

	public int lastRemaining(int n) {
		int size = n;
    	boolean l2r = true;
    	int start = 0;
    	int end = n - 1;
    	int step = 2;
    	int num = 0;
    	while(size > 1){
    		int mns = 0;
        	if(size % 2 == 1){
        		for(int i = start; i <= end; i += step){
        			mns ++;
        		}
        		start += Math.pow(2, num);
        		end -= Math.pow(2, num);
        		step += Math.pow(2, num + 1);
        		num ++;
        		l2r = l2r ? false : true;
        	}else if(l2r){
        		for(int i = start; i <= end; i += step){
        			mns ++;
        		}
        		start += Math.pow(2, num);
        		step += Math.pow(2, num + 1);
        		num ++;
        		l2r = false;
        	}else if(!l2r){
        		for(int i = end; i >= start; i -= step){
        			mns ++;
        		}
        		end -= Math.pow(2, num);
        		step += Math.pow(2, num + 1);
        		num ++;
        		l2r = true;
        	}
        	size -= mns;
        }
        return start + 1;
	}
	
    public int lastRemaining2(int n) {
    	int size = n;
    	boolean l2r = true;
    	int[] ondexs = new int[n];
    	for(int i = 0; i < n; i++){
    		ondexs[i] = i;
    	}
        while(size > 1){
        	int[] indexs = null;
        	int l = size / 2;
        	indexs = new int[l];
        	if(size % 2 == 1){
        		for(int i = 0; i < l; i++){
        			indexs[i] = ondexs[i * 2 + 1];
        		}
        		l2r = l2r ? false : true;
        	}else if(l2r){
        		for(int i = 0; i < l; i++){
        			indexs[i] = ondexs[i * 2 + 1];
        		}
        		l2r = false;
        	}else if(!l2r){
        		for(int i = 0; i < l; i++){
        			indexs[i] = ondexs[i * 2];
        		}
        		l2r = true;
        	}
        	size = l;
        	ondexs = indexs;
        }
        return ondexs[0] + 1;
    }
	
	public static void main(String[] args) {
		System.out.println(new EliminationGame().lastRemaining(19));
	}

}
