package module5;


public class SquareMatrix {
	// Variable used to hold the matrix
	private double[][] matrix;
	
	// Square matrix constuctor which also checks to see if the matrix is phyical ie width = height
	public SquareMatrix(double[][] elements) throws Exception{
		for (int i = 0; i<elements.length; i++) {
			if (elements[i].length != elements.length) {throw new Exception("ERROR: Rows and Columns are different lengths in the supplied matrix");}
		}
		matrix = elements;
	}
	
	// Define how to display a matrix to the user by looping through each column and row outputting the value in a set format {{#,#},{#,#}}
	public String toString() {
		String output = "{";
		for (int i = 0; i<matrix.length; i++) {
			//Each row
			output += "{";
			for (int j = 0; j<matrix[i].length; j++) {
				//Each column
				output += matrix[i][j];
				if(j+1!=matrix[i].length) {output += ",";}
			}
			output += "}";
			if(i+1!=matrix.length) {output += ",";}
			
		}
		output += "}";
		return output;
	}
	
	// Method which creates an idenity matrix of a specified size
	public static SquareMatrix unitMatrix(int size) throws Exception {
		// First make a matrix of zeros of the right size an then fill in the 1's along te diagnonal
		double[][] zeros = new double[size][size];
		SquareMatrix unit = new SquareMatrix(zeros);
		for (int i = 0; i<size; i++) {
			unit.matrix[i][i] = 1;			
		}
		return unit;	
	}
	
	// Method defines how to compare two square matrix
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SquareMatrix other = (SquareMatrix) obj;
		try {
			for (int i = 0; i<matrix.length; i++) {
				//Each row
				for (int j = 0; j<matrix[i].length; j++) {
					//Each column
					if(matrix[i][j] != other.matrix[i][j]){return false;}
				}
			}
		}
		catch(Exception e) {
			//Catches mismatched matrix size
			return false;
		}
		return true;
	}
	
	// Method which adds two square matrix by looping through each column and row as seen above
	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		double[][] elements = new double[sm1.matrix.length][sm1.matrix.length];
		SquareMatrix sum = new SquareMatrix(elements);
		for (int i=0;i<sm1.matrix.length;i++){
			for (int j=0;j<sm1.matrix.length;j++) {
				elements[i][j] = sm1.matrix[i][j] + sm2.matrix[i][j];
			}
		}
		return sum;		
	}
	// Non-static wrapper for the add method
	public SquareMatrix add(SquareMatrix arg) throws Exception {
		return add(this, arg);
	}
	
	
	// Method which subtracts two square matrix by looping through each column and row as seen above
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		double[][] elements = new double[sm1.matrix.length][sm1.matrix.length];
		SquareMatrix sub = new SquareMatrix(elements);
		for (int i=0;i<sm1.matrix.length;i++){
			for (int j=0;j<sm1.matrix.length;j++) {
				elements[i][j] = sm1.matrix[i][j] - sm2.matrix[i][j];
			}
		}
		return sub;		
	}
	// non-static wrapper for the subtract method
	public SquareMatrix subtract(SquareMatrix arg) throws Exception {
		return subtract(this,arg);
	}
	
	// Metho which multiplies two square matrix again by looping, however this time three loops are used to use a standard multiplication formula
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		// First make an empty matrix that will hold the result
		double[][] elements = new double[sm1.matrix.length][sm1.matrix.length];
		SquareMatrix product = new SquareMatrix(elements);
		
		for (int i=0;i<sm1.matrix.length;i++){
			for (int j=0;j<sm1.matrix.length;j++) {
				double sum = 0;
				for (int k=0;k<sm1.matrix.length;k++) {
					// ACTUAL MULTIPLICATION HAPPENS HERE; i = first loop, j = second loop, k = final loop caculating a sum
					sum += sm1.matrix[i][k] * sm2.matrix[k][j];
				}
				// fill in the result one element at a time
				elements[i][j] = sum;
			}
		}
		return product;		
	}
	// non-staic wrapper for the multiply method
	public SquareMatrix multiply(SquareMatrix arg) throws Exception {
		return multiply(this, arg);
	}
}
