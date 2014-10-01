package module1;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double doubVar = 10.0;
		System.out.println("doubVar = "+doubVar);
		
		float floatVar = 10;
		int intVar = 10;
		long longVar = 10;
		byte byteVar = 10;
		System.out.println("floatVar = "+floatVar);
		System.out.println("intVar = "+intVar);
		System.out.println("longVar = "+longVar);
		System.out.println("byteVar = "+byteVar+"\n");
		
		//Multiply section
		doubVar = doubVar * doubVar;
		floatVar = floatVar * floatVar;
		intVar = intVar * intVar;
		longVar = longVar * longVar;
		byteVar = (byte)(byteVar * byteVar);
		System.out.println("doubVar = "+doubVar);
		System.out.println("floatVar = "+floatVar);
		System.out.println("intVar = "+intVar);
		System.out.println("longVar = "+longVar);
		System.out.println("byteVar = "+byteVar);
		
		//DataType mixing
		System.out.println("'c'+10 = is a char with an int added. The char is converted to an int for the addition.");
		System.out.println('c'+10);
		System.out.println("10.11 + 10 = is a float with an int added. The int is converted to a float for the addition");
		System.out.println(10.11+10);
		System.out.println("\"c\" + 10 = is a string with an int added. The int is converted into a string and then are concat into a single string.");
		System.out.println("c"+10+"\n");
		
		//int j=1; int i; j=i+1;
		//This gives an error for not initialising the variable i
		//int j=1; int i=0; j=i+1; 
		//This fixes the problem by assigning the value
		
		//investigating double to int
		double conversionVariable = 4.99;
		conversionVariable = (int)(conversionVariable);
		System.out.println("Converting 4.99 as a double to an int gives 4.0");
		System.out.println(conversionVariable);
		
				
				
		
	}

}
