package br.com.estruturaDados.model.util;

import br.com.estruturaDados.model.exception.CompareException;

public class Compare {

	private static Class<?> type = null;

	public static int compare(Object o1, Object o2){
		if(o1.getClass() == o2.getClass())
			type = o1.getClass();
		else
			throw new CompareException("Os elementos não são do mesmo tipo");
		
		if(type == Integer.class){
			Integer i1 = (Integer) type.cast(o1);
			Integer i2 = (Integer) type.cast(o2);
			return compareToInteger(i1, i2);
		}else if(type == Double.class){
			Double d1 = (Double) type.cast(o1);
			Double d2 = (Double) type.cast(o2);
			return compareToDouble(d1, d2);
		}else if(type == String.class){
			String s1 = (String) type.cast(o1);
			String s2 = (String) type.cast(o2);
			return compareToString(s1, s2);
		}else if(type == Float.class){
			Float f1 = (Float) type.cast(o1);
			Float f2 = (Float) type.cast(o2);
			return compareToFloat(f1, f2);
		}else if (type == Character.class){
			Character c1 = (Character) type.cast(o1);
			Character c2 = (Character) type.cast(o2);
			return compareToCharacter(c1, c2);
		}else{
			return -1;
		}
	}

	private static int compareToInteger(final Integer i1, final Integer i2) {
		return i1.compareTo(i2);
	}

	private static int compareToDouble(final Double d1, final Double d2) {
		return d1.compareTo(d2);
	}

	private static int compareToString(final String s1, final String s2) {
		return s1.compareTo(s2);
	}

	private static int compareToFloat(final Float f1, final Float f2) {
		return f1.compareTo(f2);
	}

	private static int compareToCharacter(final Character c1, final Character c2) {
		return c1.compareTo(c2);
	}

}
