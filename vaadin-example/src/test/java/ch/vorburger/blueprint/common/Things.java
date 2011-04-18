package ch.vorburger.blueprint.common;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * TODO Doc!
 * 
 * @author Michael Vorburger
 */
public class Things {

	static interface Thing<T> {
	}
	
	static interface OneThing<T> extends Thing<T> {
	}
	OneThing<Integer> theIntegerOneThing;
	OneThing<String> theFirstStringOneThing;
	OneThing<String> theOtherStringOneThing;

	static interface AnotherThing<T> extends Thing<T> {
	}
	AnotherThing<String> theStringAnotherThing;

	@Test
	public void testTheThing() {
		setOneThing(theIntegerOneThing, 27);
		setOneThing(theFirstStringOneThing, "ABC");
		setOneThing(theOtherStringOneThing, "DEF");
		
		// can't do: setOneThing(theOtherStringOneThing, 13);
		
		setAnotherThing(theStringAnotherThing, "XYZ");
		
		// can't do: setAnotherThing(theFirstStringOneThing, "noops");
		
		// can't do: Double d = getTheAnotherThing(theIntegerOneThing);
		// can't do: Double d = getTheAnotherThing(theStringAnotherThing);
	}
	
	<T> void setOneThing(OneThing<T> thing, T model) {
	}

	<T> void setAnotherThing(AnotherThing<T> thing, T model) {
	}

	<T> T getTheAnotherThing(AnotherThing<T> thing) {
		return null;
	}
}
