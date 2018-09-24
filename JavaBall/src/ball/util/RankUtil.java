package ball.util;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import ball.bean.Results;

public class RankUtil implements Comparator<Map.Entry<String,Results>> {

	@Override
	public int compare(Entry<String, Results> o1, Entry<String, Results> o2) {
		// TODO Auto-generated method stub
		return o2.getValue().getMatchPoints()-o1.getValue().getMatchPoints();
	}
	


}
