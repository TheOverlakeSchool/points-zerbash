import java.util.Comparator;

public class PointExOriginComparator implements Comparator<PointEx> {
	public int compare(PointEx a, PointEx b) {
		return Double.compare(a.distance(0,0),b.distance(0,0));
	}
}
