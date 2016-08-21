package test_main;

public class VerifyPreorderSerialization {
	String[] preorders = null;
    public boolean isValidSerialization(String preorder) {
    	this.preorders = preorder.split(",");
    	int num = 0;
    	for(int i = 0; i < preorders.length; i++){
    		if(preorders[i].equals("#"))
    			num ++;
    	}
    	if(num*2 - 1 != preorders.length)
    		return false;
    	String c = preorders[0];
    	int index = 0;
        int can = canInsert(c, index);
        return can == -1 ? true : false;
    }
	
	private int canInsert(String c, int index) {
		if(index == preorders.length - 1)
			return -1;
		if(c.equals("#"))
			return index;
		else{
			int n = 1;
			while(n <= 2){
				index = canInsert(preorders[index + 1], index + 1);
				if(index != -1){
					n++;
				}else
					return -1;
			}
			return index;
		}
	}

	public static void main(String[] args) {
		String preorder = "3,1,#,6,#,5,#,#,5,3,#,#";
		//String preorder = "9,#,92,#,#";
		System.out.println(new VerifyPreorderSerialization().isValidSerialization(preorder));
	}

}
