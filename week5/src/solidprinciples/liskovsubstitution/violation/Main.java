package solidprinciples.liskovsubstitution.violation;

public class Main {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(10, 20);
		System.out.println(rectangle.computeArea());
		
		Square square = new Square(10);
		System.out.println(square.computeArea());
		
		useRectangle(rectangle);
		
		useRectangle(square);

	}

	private static void useRectangle(Rectangle rectangle) {
		rectangle.setHeight(20);
		rectangle.setWidth(30);
		if(rectangle.getHeight() != 20) 
			System.out.println("Height Not equal to 20");
		else
			System.out.println("Height equal to 20");
	}
}
