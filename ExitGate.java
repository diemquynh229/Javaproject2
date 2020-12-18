package hw2;

public class ExitGate {
	
	private TimeClock clock;
	private int exitCount;
	;
	
	public ExitGate(TimeClock givenClock) {
		clock = givenClock;
		exitCount = 0;
		
	}
	
	public boolean insertCard(ParkingCard c) {
		boolean canExit = false;
		int a = clock.getTime() - c.getPaymentTime();
		
		if(c.getPaymentTime()==0) {
			return false;
		}
		
		if(a>RateUtil.EXIT_TIME_LIMIT || a <=0) {
			canExit=false;
			
		}
		if(a<=RateUtil.EXIT_TIME_LIMIT && a >0) {
			exitCount++;
			canExit= true;
		}
		return canExit;
	}
	
	public int getExitCount() {
//		if(true) {
//			exitCount++;
//		}
		return exitCount;
	}
	
}
