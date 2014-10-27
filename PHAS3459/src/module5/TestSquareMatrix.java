package module5;
import module5.SquareMatrix;

public class TestSquareMatrix {

	public static void main(String[] args) {
		double[][] A = {{1,0,2},{0,1,0},{-3,0,-1}};
		double[][] B = {{0,0,1},{0,1,0},{-1,0,1}};
		double[][] C = {{4,3},{3,2}};
		double[][] D = {{-2,3},{3,-4}};
		SquareMatrix I = new SquareMatrix.unitMatrix(2);
		
	
		try {
			SquareMatrix a = new SquareMatrix(A);
			SquareMatrix b = new SquareMatrix(B);
			SquareMatrix c = new SquareMatrix(C);
			SquareMatrix d = new SquareMatrix(D);
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
}