package module5;

import java.util.Arrays;

public class SquareMatrix {
	private double[][] matrix;
		
	public SquareMatrix(double[][] elements) throws Exception{
		for (int i = 0; i<elements.length; i++) {
			if (elements[i].length != elements.length) {throw new Exception("ERROR: Rows and Columns are different lengths in the supplied matrix");}
		}
		matrix = elements;
	}
	
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
	
	public static SquareMatrix unitMatrix(int size) throws Exception {
		double[][] zeros = new double[size][size];
		SquareMatrix unit = new SquareMatrix(zeros);
		for (int i = 0; i<size; i++) {
			unit.matrix[i][i] = 1;			
		}
		return unit;	
	}
	
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
			//Catches missmatched matrix size
			return false;
		}
		return true;
	}
	
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
	public SquareMatrix add(SquareMatrix arg) throws Exception {
		return add(this, arg);
	}
	
	
	
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
	public SquareMatrix subtract(SquareMatrix arg) throws Exception {
		return subtract(this,arg);
	}
	
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws Exception {
		double[][] elements = new double[sm1.matrix.length][sm1.matrix.length];
		SquareMatrix product = new SquareMatrix(elements);
		for (int i=0;i<sm1.matrix.length;i++){
			for (int j=0;j<sm1.matrix.length;j++) {
				double sum = 0;
				for (int k=0;k<sm1.matrix.length;k++) {
					sum += sm1.matrix[i][k] * sm2.matrix[k][j];
				}
				elements[i][j] = sum;
			}
		}
		return product;		
	}
	public SquareMatrix multiply(SquareMatrix arg) throws Exception {
		return multiply(this, arg);
	}
}
