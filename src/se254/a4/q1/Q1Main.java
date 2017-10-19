package se254.a4.q1;
import java.lang.reflect.*;
import java.util.Scanner;
/**
 * SE254 Assignment 4 Question 1 Main. This class should be implemented to contain the functionality described in the
 * assignment handout. you may implement additional classes if you wish, but this class should be the main program entry
 * point.
 */
public class Q1Main {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String mName = "";
			System.out.print("Enter the name of a class: ");
			String cName = sc.nextLine();
			Class<?> c = Class.forName(cName);
			Object obj = c.newInstance();
			while(true) {
				System.out.println("Fields:");
				for(Field f : c.getFields()) {
					System.out.println(f.getName()+" = "+f.get(obj).toString());
				}
				System.out.println("");
				System.out.println("Methods:");
				for(Method m: c.getMethods()) {
					if(m.getParameterCount()==0) {
						System.out.println(m.getName());					
					}
				}
				System.out.println("");
				System.out.print("Choose a method to execute (or q to quit): ");
				mName = sc.nextLine();
				if(mName.equals("q")) {
					break;
				}
				Method toInvoke = c.getMethod(mName);
				toInvoke.invoke(obj);
			}
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
