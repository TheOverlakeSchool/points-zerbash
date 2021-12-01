import java.io.File;
import java.util.List;

public class PointsClient {
	public static void main(String[] args) {
		File file = new File(args[0]);
		// TODO: get file contents into a collection of PointEx objects
		List points = null;

		// Check if a sorting flag was passed
		String sortMethod = args.length == 1 ? "" : args[1];

		switch (sortMethod) {
			case "y":
				sortY(points);
				break;
			case "origin":
				sortOrigin(points);
				break;
			default:
				sortX(points);
		}
		System.out.println();
	}

	private static void sortOrigin(List points) {
		System.out.println("Points, sorted by distance from origin:");
		// TODO: sort points
		System.out.println(points);
	}

	private static void sortY(List points) {
		System.out.println("Points, sorted by y:");
		// TODO: sort points
		System.out.println(points);
	}

	private static void sortX(List points) {
		System.out.println("Points, sorted by x:");
		// TODO: sort points
		System.out.println(points);
	}
}