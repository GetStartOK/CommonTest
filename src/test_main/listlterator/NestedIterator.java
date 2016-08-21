package test_main.listlterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
	
	private List<NestedInteger> nestedList;
	private int index;
	private HashMap<Integer, NestedIterator> map;

	public NestedIterator(List<NestedInteger> nestedList) {
		this.nestedList = nestedList;
		this.map = new HashMap<Integer, NestedIterator>();
		index = 0;
    }
	
	@Override
	public boolean hasNext() {
		if(index >= nestedList.size())
			return false;
		NestedInteger ni = nestedList.get(index);
		if(ni.isInteger())
			return true;
		else{
			NestedIterator ni2 = null;
			ni2 = map.get(index);
			if(ni2 == null){
				ni2 = new NestedIterator(ni.getList());
				map.put(index, ni2);
			}
			if(ni2.hasNext())
				return true;
			else{
				index ++;
				return this.hasNext();
			}
		}
	}

	@Override
	public Integer next() {
		if(index < nestedList.size()){
			NestedInteger ni = nestedList.get(index);
			if(ni.isInteger()){
				index ++;
				return ni.getInteger();
			}else{
				NestedIterator ni2 = null;
				ni2 = map.get(index);
				if(ni2 == null){
					ni2 = new NestedIterator(ni.getList());
					map.put(index, ni2);
				}
				if(ni2.hasNext()){
					return ni2.next();
				}else{
					index ++;
					this.next();
				}
			}
		}
		return null;
	}

	@Override
	public void remove() {
		
	}

}
