package hw2;

public class PayStation {

	private TimeClock clock;
	private boolean inProgress;
	private ParkingCard card;
	private double totalPayment;
	private double paymentDue;

	
	public PayStation(TimeClock givenClock) {
		clock = givenClock;
		totalPayment=0.0;
	}
	
	public void insertCard(ParkingCard t) {
		card = t;
		inProgress =true;
	}
	
	public ParkingCard getCurrentCard() {
		if(inProgress == true ) {
			return card;
		}
		return null;
	
	}
	
	public boolean inProgress() {
		if(inProgress == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getPaymentDue() {
		if(inProgress()==false) {
			return 0.0;
		}else {
			 if(card.getPaymentTime() == 0) {
				 paymentDue = RateUtil.calculateCost(clock.getTime() - card.getStartTime()); 
			 }else{
				 paymentDue = RateUtil.calculateCost(clock.getTime() - card.getStartTime()) - 
						 RateUtil.calculateCost(card.getPaymentTime() - card.getStartTime());
			 }
		}
		return paymentDue;
	}
	
	public void makePayment() {
		totalPayment += getPaymentDue();	
		card.setPaymentTime(clock.getTime());
	}	
	
	public void ejectCard() {
		inProgress = false;
	}
	
	public double getTotalPayments() {
		return totalPayment;
	}
}
