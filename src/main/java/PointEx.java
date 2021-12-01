import java.awt.*;
import java.util.Comparator;

public class PointEx extends Point implements Comparable<PointEx> {

	public static OriginComparator SORT_ORIGIN = new OriginComparator();

	public PointEx(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(PointEx pointEx) {
		return this.x - pointEx.x;
	}

	public static class OriginComparator implements Comparator<PointEx> {
		public int compare(PointEx a, PointEx b) {
			return java.lang.Double.compare(a.distance(0,0),b.distance(0,0));
		}
	}

}
