package module1;

public class VectorMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VectorMethods vm = new VectorMethods();
		
		//dotProduct test
		System.out.println("The dotproduct of (6,5,1) and (2,4,3) is");
		System.out.println(vm.dotProduct(6, 5, 1, 2, 4, 3));
		
		//magnitude test
		System.out.println("The magnitude of (6,5,1) is");
		System.out.println(vm.magnitude(6, 5, 1));
		
		//angle test
		//test 1
		System.out.println("The angle between (6,5,1) and (2,4,3) is");
		System.out.println(vm.angle(6, 5, 1, 2, 4, 3));
		//test 2
		System.out.println("The angle between (1,4,1) and (0,0,0) is not a number as the second vector is a point.");
		System.out.println(vm.angle(1, 4, 1, 0, 0, 0));
		
	}
	
	double dotProduct (double x1 , double y1, double z1, double x2, double y2, double z2) {
		return (x1*x2 + y1*y2 + z1*z2);	
	}
	double magnitude (double x, double y, double z) {
		return (Math.sqrt((x*x)+(y*y)+(z*z)));
	}
	double angle (double x1 , double y1, double z1, double x2, double y2, double z2) {
		return(Math.acos(dotProduct(x1,y1,z1,x2,y2,z2)/(magnitude(x1,y1,z1)*magnitude(x2,y2,z2))));
	}
	
}
