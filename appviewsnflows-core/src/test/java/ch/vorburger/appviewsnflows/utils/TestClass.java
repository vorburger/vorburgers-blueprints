package ch.vorburger.appviewsnflows.utils;

import java.util.List;

public class TestClass {
	
	private final String firstString;
	
	public TestClass(List<String> strings) {
		this.firstString = strings.get(0);
	}

	public String getFirstString() {
		return firstString;
	}
}
