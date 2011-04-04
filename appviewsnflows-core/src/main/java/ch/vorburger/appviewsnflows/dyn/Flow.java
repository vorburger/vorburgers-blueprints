package ch.vorburger.appviewsnflows.dyn;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import ch.vorburger.appviewsnflows.Event;
import ch.vorburger.appviewsnflows.AbstractFlow;
import ch.vorburger.appviewsnflows.FlowException;
import ch.vorburger.appviewsnflows.View;
import ch.vorburger.appviewsnflows.util.ReflectionUtil;

/**
 * Flow implementation which can be configured dynamically at run-time.
 * 
 * @author Michael Vorburger
 */
public class Flow extends AbstractFlow {

	private final String flowId;
	private Map<Class<View>, Map<String, Class<View>>> map = new HashMap<Class<View>, Map<String,Class<View>>>();

	public Flow(String flowId) {
		this.flowId = flowId;
	}


	public <T extends View> OnEvent<T> onView(Class<T> viewClass) {
		return new OnEvent<T>(viewClass);
	}
	public class OnEvent<T extends View> {
		private final Class<T> currentViewClass;
		private OnEvent(Class<T> viewClass) {
			this.currentViewClass = viewClass;
		}
		public GoTo<T> onEvent(String eventId) {
			return new GoTo<T>(currentViewClass, eventId);
		}
	}
	public class GoTo<T extends View> {
		private final Class<T> currentViewClass;
		private final String eventId;
		private GoTo(Class<T> viewClass, String eventId) {
			this.currentViewClass = viewClass;
			this.eventId = eventId;
		}
		@SuppressWarnings("unchecked")
		public <TT extends View> void goTo(Class<TT> nextViewClass) {
			Map<String, Class<View>> subMap = map.get(currentViewClass);
			if (subMap == null) {
				subMap = new HashMap<String, Class<View>>();
				map.put((Class<View>) currentViewClass, subMap);
			}
			subMap.put(eventId, (Class<View>) nextViewClass);
		}
	}
	
	@Override
	protected View handleEvent(Event event) {
		Class<View> viewClass = findViewClass(event);
		View nextView = createNewView(viewClass, event.getData());
		return nextView;
	}

	private View createNewView(Class<View> viewClass, Object[] params) {
		Class<?>[] viewConstructorParameterTypes = new Class<?>[params.length + 1];
		viewConstructorParameterTypes[0] = Flow.class;
		for (int i = 1; i < viewConstructorParameterTypes.length; i++) {
			Class<?> paramType = params[i - 1].getClass();
			viewConstructorParameterTypes[i] = paramType;
		}
		
		Constructor<View> c;
		try {
			c = ReflectionUtil.findConstructor(viewClass, viewConstructorParameterTypes);
		} catch (NoSuchMethodException e) {
			throw new FlowException("NoSuchMethodException while finding Constructor to create next View; available constructors are: " + Arrays.asList(viewClass.getConstructors()), e);
		}
		
		Object[] constructorParameters = new Object[params.length + 1];
		constructorParameters[0] = this;
		for (int i = 1; i < viewConstructorParameterTypes.length; i++) {
			constructorParameters[i] = params[i - 1];
		}
		
		try {
			return c.newInstance(constructorParameters);
		} catch (IllegalArgumentException e) {
			throw new FlowException("IllegalArgumentException from newInstance() for next View with constructor " + c + " for args " + Arrays.asList(params) + ", types: " + Arrays.asList(viewConstructorParameterTypes), e);
		} catch (InstantiationException e) {
			throw new FlowException("InstantiationException from newInstance() for next View" , e);
		} catch (IllegalAccessException e) {
			throw new FlowException("IllegalAccessException from newInstance() for next View" , e);
		} catch (InvocationTargetException e) {
			throw new FlowException("InvocationTargetException from newInstance() for next View" , e);
		}
	}


	private Class<View> findViewClass(Event event) {
		Map<String, Class<View>> subMap = map.get(getCurrentView().getClass());
		if (subMap == null)
			throw new FlowException(message(event) + " but no rules whatsoever for that view have been configured, I only know these views: " + map.keySet());
		Class<View> viewClass = subMap.get(event.getEventId());
		if (viewClass == null)
			throw new FlowException(message(event) + " but no matching rules for that event have been configured, only: " + subMap.keySet());
		return viewClass;
	}

	
	@Override
	public String getFlowId() {
		return flowId;
	}
	
	@Override
	public String toString() {
		return "DynFlow:" + flowId;
	}
}
