package hw2;

public class RateUtil {
	
	private RateUtil() {}
	
	public static final int EXIT_TIME_LIMIT = 15;
	
	public static double calculateCost(int minutes) {
		double cost=0;
		if(minutes<=30) {
			cost =1.00;
		}else if(minutes >30 && minutes <= 300) {
			cost = 2.00 + Math.ceil((minutes/60.00)-1) * 1.50;
		}else if(minutes >=301 && minutes<=480) {
			cost = 8.00 + Math.ceil((minutes/60.00)-5) * 1.25;
		}else if(minutes>480 && minutes<=1440) {
			cost = 13;
		}else if(minutes>1440) {
			double days = Math.ceil(minutes/1440);
			double remain = days*60.00;
			
			if(remain<=30) {
				cost =(days*13)+1.00;
			}else if(remain >30 && remain <= 300) {
				cost = (days*13)+(2.00 + Math.ceil((remain/60.00)-1) * 1.50);
			}else if(remain >=301 && remain<=480) {
				cost = (days*13)+(8.00 + Math.ceil((remain/60.00)-5) * 1.25);
			}else if(remain>480 && remain<=1440) {
				cost = (days*13)+13;
			}
		}
		
		return cost;
		}
}
