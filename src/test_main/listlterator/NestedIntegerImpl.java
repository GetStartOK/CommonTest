package test_main.listlterator;

import java.util.List;

public class NestedIntegerImpl implements NestedInteger {

	private boolean isInteger;
	private Object value;
	
	@Override
	public boolean isInteger() {
		return isInteger;
	}

	@Override
	public Integer getInteger() {
		if(isInteger)
			return (Integer)value;
		return null;
	}

	@Override
	public List<NestedInteger> getList() {
		if(!isInteger)
			return (List<NestedInteger>)value;
		return null;
	}

}
