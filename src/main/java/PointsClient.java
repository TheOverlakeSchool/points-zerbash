import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PointsClient {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner scanner = new Scanner(file);
		List<PointEx> points = new ArrayList<>();
		while (scanner.hasNextLine()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			points.add(new PointEx(x,y));
		}
		scanner.close();
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

	private static void sortOrigin(List<PointEx> points) {
		System.out.println("Points, sorted by distance from origin:");
		points.sort(PointEx.SORT_ORIGIN);
		System.out.println(points);
	}

	private static void sortY(List<PointEx> points) {
		System.out.println("Points, sorted by y:");
		points.sort(new PointExYComparator());
		System.out.println(points);
	}

	private static void sortX(List<PointEx> points) {
		System.out.println("Points, sorted by x:");
		Collections.sort(points);
		System.out.println(points);
	}
}