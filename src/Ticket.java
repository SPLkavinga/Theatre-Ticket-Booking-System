public class Ticket {
		
	 int row;
	 int seat;
	double price;
	Person person;

	public int getRow() {
		return row;
	}

	public int getSeat() {
		return seat;
	}

	public double getPrice() {
		return price;
	}

	public Person getPerson() {
		return person;
	}
	public Ticket(int row, int seat, double price, Person person) {
		this.row = row;
		this.seat = seat;
		this.price = price;
		this.person = person;
	}
	public void print() {
		System.out.println("Name : " + person.getName());
		System.out.println("Surname : " + person.getSurname());
		System.out.println("Email : " + person.getEmail());
		System.out.println("Row Number: " + getRow());
		System.out.println("Seat Number: " + getSeat());
		System.out.println("your ticket Price : " + getPrice());
		System.out.println("");
	}

	
}
