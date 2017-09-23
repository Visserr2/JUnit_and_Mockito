package nl.tutorial.useradmin.util;

public final class IdGenerator {
	
	static int i;
	
	public static int generateID() {
		return i++;
	}
}
