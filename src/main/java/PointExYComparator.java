import java.util.Comparator;

public class PointExYComparator implements Comparator<PointEx> {
	public int compare(PointEx a, PointEx b) {
		return Double.compare(a.getY(), b.getY());
	}
}
