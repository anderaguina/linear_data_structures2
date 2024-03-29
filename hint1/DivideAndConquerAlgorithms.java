package hint1;
import java.math.*;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){
		
		int maxItem;
		
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}
		
		int length = m.length();
		
		if (m.length() == 0) {
			return -1;
		}
		
		if (m1.length() == 1) {
			// System.out.println("PATH 1");
			maxItem = m1.getElement(0);
			// System.out.println("PATH 1.5: " + maxItem);
		} else {
			int aux = m1.getElement(m1.length()-1);
			m1.removeElement(m1.length()-1);
			return Math.max(aux, maxInt(m1)); 
		}
		
		return maxItem;
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
		boolean isReverse = false;
		
		int previousNumber;
		
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}
		
		if (m1.length() == 0) {
			return true;
		}
			
		previousNumber = m.getElement(0);	
		
		if (m1.length() == 1) {
			return true;
		} else {
			int aux = m1.getElement(m1.length() - 1);
			boolean a = m1.getElement(m1.length() - 2)  > m1.getElement(m1.length() - 1);
			m1.removeElement(m1.length()-1);
			return (a && isReverse(m1));
		}
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){
			 // TO-DO
		if (m.length() == 0) {
			return 0;
		}
		
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		for (int i=0; i<m.length(); i++) {
			m1.addElement(m1.length(), m.getElement(i));
		}
		
		
		int appearances = 0;
		
		if (m1.getElement(0) == n) {
			appearances++;
		} else {
			
		}
		
		//System.out.println("PATH 3: " + m.length());
		//System.out.println("PATH 3.5: " + m1.length());
		// m1.addElement(m1.length(), m.getElement(0));
		m1.removeElement(0);
		//System.out.println("PATH 4: " + m.length());
		//System.out.println("PATH 5: " + m1.length());
		/*if (m.length() == 0) {
			m = m1;
		}*/
		return appearances + getNumAppearances(m1, n);
		
		// m = m1;
		// return appearances;
		
	}
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
		if (m == 0) {
			return 1;
		} else {
			return power(n, m-1) * n;
			// return Math.pow((n), (power(n, m-1)));
		}
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		// Following the recursive equation
		if (n == 0) {
			return 2;
		} else if (n == 1) {
			return 1;
		} else {
			return (lucas(n-1) + lucas(n-2));
		}
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
			 // TO-DO
		if (n < 1) {
			System.out.println(); 
		} else {
			System.out.print("* "); 
			drawImage(n - 1); 
		}
		
	}
		
}
