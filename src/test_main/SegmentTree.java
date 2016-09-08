package test_main;

public class SegmentTree {

	public MySTree buildTree(int[] nums){
		MySTree st = build(0, nums.length - 1, nums);
		return st;
	}
	
	private MySTree build(int i, int j, int[] nums) {
		MySTree st = new MySTree(i, j);
		if(i == j){
			st.value = nums[i];
			return st;
		}
		MySTree rt = build(i + (j - i) / 2 + 1, j, nums);
		MySTree lt = build(i, i + (j - i) / 2, nums);
		st.lt = lt;
		st.rt = rt;
		st.value = Math.max(lt.value, rt.value);
		return st;
	}

	public int findMax(int l, int r, MySTree st){
		if(l == st.l && r == st.r)
			return st.value;
		int max = Integer.MIN_VALUE;
		if(r <= st.l + (st.r - st.l) / 2)
			max = findMax(l, r, st.lt);
		else if(l >= st.l + (st.r - st.l) / 2 + 1)
			max = findMax(l, r, st.rt);
		else
			max = Math.max(findMax(l, st.l + (st.r - st.l) / 2, st.lt), findMax(st.l + (st.r - st.l) / 2 + 1, r, st));
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,23,43,54,2,32,43,23,2,43,58,6,8,9,55,7,4};
		SegmentTree st = new SegmentTree();
		MySTree mst = st.buildTree(nums);
		System.out.println(mst.value);
		System.out.println(st.findMax(0, 2, mst));
	}
	
}

class MySTree{
	int value;
	int l,r;
	MySTree lt, rt;
	public MySTree(int l, int r){
		this.l = l;
		this.r = r;
	}
}