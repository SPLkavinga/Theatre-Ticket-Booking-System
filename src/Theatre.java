import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
import java.util.Scanner;

public class Theatre {
	static int row1[]= new int[12]; // creating arry for row 1
	static int row2[]= new int[16]; // creating arry for row 2
	static int row3[]= new int[20]; // creating arry for row 3
	static ArrayList <Ticket> ticket = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("********** Welcome to the New Theatre **********");
		
		for (int i=0;i<row1.length;i++) {
			row1[i]=0;
		}
		for (int i=0;i<row2.length;i++) {
			row2[i]=0;
		}
		for (int i=0;i<row3.length;i++) {
			row3[i]=0;
		}

		while(true) {
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Please Select an Option :");
			System.out.println("\t1) Buy a ticket ");
			System.out.println("\t2) Print seating area ");
			System.out.println("\t3) Cancel ticket");
			System.out.println("\t4) List available seats ");
			System.out.println("\t5) Save to file  ");
			System.out.println("\t6) Load from file ");
			System.out.println("\t7) Print ticket information and total price ");
			System.out.println("\t8) Sort tickets by price ");
			System.out.println("\t\t0) Quit");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("\nEnter option: ");
			String option=sc.next();
			switch(option) {
				case "0":
					Exit();
					break;
			
				case "1":
					buy_ticket();
					break;
				case "2":
					print_seating_area();
					break;
				case "3":
					cancel_ticket();
					break;
				case "4":
					show_available();
					break;
				case "5":
					save();
					break;
				case "6":
					load();
					break;
				case "7":
					show_tickets_info();
					break;
				case "8":
					sort_tickets();
					for (Ticket mergedArray : ticket) {
						mergedArray.print();
						System.out.print("\n");
					}
          			break;

				default:
					System.out.println("invalid option ");
					break;

			}
		}
	}
	
	public static void buy_ticket() {
		//Buy ticket method.
		//which will book the seats and make it occupied.As well as the seat number according to row .
		while (true) {
			try {
				System.out.println("****** Buy Ticket ******\n");
				Scanner sc = new Scanner(System.in);
				double price = 0;

				System.out.println("Enter Row Number ");
				int row = sc.nextInt();
				System.out.println("Enter Seat Number ");
				int seat = sc.nextInt();

				if (row == 1 && seat >= 0 && seat <= 12) { //check row1 information
					if (row1[seat - 1] == 0) {
						row1[seat - 1] = 1; // make seat available
						price = 1500;
					} else {
						System.out.println("Seat is not avalible");
					}

				} else if (row == 2 && seat >= 0 && seat <= 16) { //check row2 information
					if (row2[seat - 1] == 0) {
						row2[seat - 1] = 1; // make seat available
						price = 2000;
					} else {
						System.out.println("Seat is not avalible");
					}
				} else if (row == 3 && seat >= 0 && seat <= 20) { //check row3 information
					if (row3[seat - 1] == 0) {
						row3[seat - 1] = 1; // make seat available
						price = 3000;
					} else {
						System.out.println("Seat is not avalible");
					}
				} else {
					System.out.println("Invalid Row Or Seat Number");
					continue;
				}
				System.out.println("Enter Name : ");
				String name = sc.next();
				System.out.println("Enter Surname : ");
				String surname = sc.next();
				System.out.println("Enter email : ");
				String email = sc.next();

				Person person1 = new Person(name, surname, email); // pass name,surname,email to the person class
				Ticket ticket1 = new Ticket(row, seat, price, person1); //pass row nuber,seat number,price ans person 1 information to the ticket class
				ticket.add(ticket1);
				for (Ticket ticketData : ticket) { //accessing the ticket class and calling the print method
					ticketData.print();
				}

			}catch (Exception e){
				System.out.println("Invalid Row Or Seat number");
				continue;
			}
			break;
		}
		
	}
	public static void print_seating_area() {
		//printing seating area method.
		//show-case the seating area & stage.
		System.out.println("****** Seating Area ******\n");
		
		System.out.printf("%5s\n","***********");
		System.out.printf("%5s\n","*  STAGE  *");
		System.out.printf("%5s\n","***********");
		for (int i=0;i<row1.length;i++) {
			if(row1[i]==0) { // checking whether row1 seat empty or not,if empty print "0"
				System.out.print("O");
			}
			else {
				System.out.print("X");
			}
		}
		System.out.println(" ");
		for (int i=0;i<row2.length;i++) {
			if(row2[i]==0) { // checking whether row2 seat empty or not,if empty print "0"
				System.out.print("O");
			}
			else {
				System.out.print("X");
			}
		}
		System.out.println(" ");
		for (int i=0;i<row3.length;i++) { // checking whether row3 seat empty or not,if empty print "0"
			if(row3[i]==0) {
				System.out.print("O");
			}
			else {
				System.out.print("X");
			}
		}
		System.out.println(" \n");
	}
	public static void cancel_ticket() {
		//Cancel Ticket method.
		//which will cancel the particular ticket from the user input.
		while (true) {
			try {
				System.out.println("****** Cancel Ticket ******\n");

				Scanner sc = new Scanner(System.in);

				System.out.println("Enter Row Number ");
				int row = sc.nextInt();
				System.out.println("Enter Seat Number ");
				int seat = sc.nextInt();

				if (row == 1 && seat >= 0 && seat <= 12 && row1[seat - 1] == 1) {
					row1[seat - 1] = 0;
				} else if (row == 2 && seat >= 0 && seat <= 16 && row2[seat - 1] == 1) {
					row2[seat - 1] = 0;
				} else if (row == 3 && seat >= 0 && seat <= 20 && row3[seat - 1] == 1) {
					row3[seat - 1] = 0;
				} else {
					System.out.println("Invalid Row Or Seat Number\n");
				}

				for (Ticket i : ticket) {
					int j;
					if (i.seat == seat && i.row == row) {
						j = ticket.indexOf(i);
						ticket.remove(j);
						System.out.println("index is " + j);
						break;

					}
				}
			}catch (Exception e){
				System.out.println("Invalid Row Or Seat Number");
				continue;
			}
			break;
		}
	}
	
	public static void show_available() {
		//Show available method.
		//which will show-case the available seats row wise.
		System.out.println("****** Available Ticket ******\n");
		System.out.print("Seats available in row 1: ");
		for (int i=0;i<row1.length;i++) {
			if(row1[i]==0) {
				System.out.print(i+1 + ", ");
			}
		}
		System.out.println();
		System.out.print("Seats available in row 2: ");
		for (int i=0;i<row2.length;i++) {
			if(row2[i]==0) {
				System.out.print(i+1 + ", ");
			}
		}
		System.out.println();
		System.out.print("Seats available in row 3: ");
		for (int i=0;i<row3.length;i++) {
			if(row3[i]==0) {
				System.out.print(i+1 + ", ");
			}
		}
		System.out.println("\n");
	}
	public static void save() {
		//SAVING DATA TO File.
		//booking data will save into the Theatre.txt file.
		try {
		      FileWriter myWriter = new FileWriter("Theatre.txt");
		      
		      myWriter.write("Row 1 : ");
		      for (int i=0;i<row1.length;i++) {
		    	  myWriter.write(row1[i] + " ");
		      }
		      
		      myWriter.write("\n");
		      myWriter.write("Row 2 : ");
		      
		      for (int i=0;i<row2.length;i++) {
		    	  myWriter.write(row2[i] + " ");
		      }
		      myWriter.write("\n");
		      myWriter.write("Row 3 : ");
		      
		      for (int i=0;i<row3.length;i++) {
		    	  myWriter.write(row3[i] + " ");
		      }
		      myWriter.write("\n");
		      
		      myWriter.close();
			  System.out.print("* * * * * * * * * * * * * * * * * \n");
		      System.out.println(" Successfully wrote to the file ");
			  System.out.println("* * * * * * * * * * * * * * * * * \n");
		      
		    } catch (Exception e) {
		      System.out.println("An error occurred.\n");
		      e.printStackTrace();
		    }

	}
	public static void load() {
		//File load  Method
		//Which will load the data that we have already added to the file. As well as it will re-save the data
		System.out.println("****** Load Data from File ******\n");
		
		try {
		      File infor = new File("Theatre.txt");
		      Scanner myReader = new Scanner(infor);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data+"\n");
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.\n");
		      e.printStackTrace();
		    }
	}
	public static void show_tickets_info() {
		//show Ticket Method
		//which will showCase ticket information and total of the price.
		System.out.println("****** Ticket Information ******\n");
		
		double total=0;
		for (Ticket i : ticket) {
			i.print(); // accessing the ticket class and calling the print method
			total=total+i.price; //calculating the total price
			
		}
		System.out.println("Total cost is : " + total+"\n");
		
		
	}

	public static void sort_tickets() {
		divide(0, ticket.size() - 1);
	}
	//Used mergeSort method to get sorted array by prices

		public static void divide(int startIndex, int endIndex) {

			if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
				int mid = (endIndex + startIndex) / 2;
				divide(startIndex, mid);
				divide(mid + 1, endIndex);
				//merging Sorted array produce above into one sorted array
				merger(startIndex, mid, endIndex);
			}
		}
		public static void merger(int startIndex, int midIndex, int endIndex) {

			ArrayList<Ticket> mergedSortedArray = new ArrayList<>();


			int leftIndex = startIndex;
			int rightIndex = midIndex + 1;

			while (leftIndex <= midIndex && rightIndex <= endIndex) {
				if ((Double) ticket.get(leftIndex).getPrice() <= (Double) ticket.get(rightIndex).getPrice()) {
					mergedSortedArray.add(ticket.get(leftIndex));
					leftIndex++;
				} else {
					mergedSortedArray.add(ticket.get(rightIndex));
					rightIndex++;
				}
			}


			while (leftIndex <= midIndex) {
				mergedSortedArray.add(ticket.get(leftIndex));
				leftIndex++;
			}

			for (int i = 0; i < mergedSortedArray.size(); i++) {
				ticket.set(startIndex++, mergedSortedArray.get(i));
			}

		}
	public static void Exit(){
		System.out.println("Thank you for booking tickets.");
		System.exit(1);
	}

}
//References
//https://www.withexample.com/merge-sort-using-arraylist-java-example/
//https://www.w3schools.com/java/java_try_catch.asp
