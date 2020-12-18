package hw2;


public class CardDispenser {
	private TimeClock clock;
	public CardDispenser(TimeClock givenClock) {
		clock = givenClock;
	}
	public ParkingCard takeCard() {
		ParkingCard card = new ParkingCard(clock.getTime());
		card.setPaymentTime(0);
		return card;		
	}
}
