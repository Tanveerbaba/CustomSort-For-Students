//@author: Tanveer Baba
//@created: 29/06/2018
//@subject: Comparing the Students by their different types of properties using comparator interface

package comparator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.List;

// class StudentId {
// 	private int id;

// 	public int getId() {
// 		return this.id;
// 	}	
// }

class Student {
	private String name;
	private int age;
	private int id;
	// Student(int id) {
		
	// }
	Student(int id, String name, int age) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	//Define the getters
	public String getName() {
		return this.name;
	}
	public Integer getAge() {
		return this.age;
	}
	public Integer getId() {
		return this.id;
	}


	@Override
	public String toString(){
		return " Id : " + this.getId() +
			   " Name : " + this.getName() +
			   " Age : " + this.getAge();
	}
}

public class CustomSortDemo {
	public static void main(String[] args) {
		int choice,id = 0,age = 0;
		String name = null;
		char more;
		ArrayList list = new ArrayList();
		// String more;
		Scanner scan = new Scanner(System.in);
		do {
			// System.out.flush();
			System.out.println("\nEnter the Name: ");
			// if (scan.hasNext())
			// System.out.flush();
			name = scan.nextLine();
			System.out.println("\nEnter the Id: ");
			id = scan.nextInt();
			System.out.println("\nEnter the Age: ");
			age = scan.nextInt();
			
			// if (scan.hasNextInt())
				
			list.add(new Student(id,name,age));
			name = null;
			System.out.println("Enter More: ");
			 more = scan.next().charAt(0); 
		}while(more == 'y' || more == 'Y');


		System.out.println("Before Sort : ");

		displayList(list);
		// System.out.println("List :" + list );

		while(true) {

			// System.("cls");
			System.out.println("1. Sort By First Name");
			System.out.println("2. Sort By Last Name");
			System.out.println("3. Sort By ID");
			System.out.println("4. Sort By Age");
			System.out.println("5. Display the List");
			System.out.println("6. Exit");

			System.out.println("\nEnter the Choice : ");
			choice = scan.nextInt();

			switch(choice) {

				case 1:
					// java.util.Collections.sort(list,new SortByFirstName());
					break;
				case 2:
					break;
				case 3:
					java.util.Collections.sort(list,new SortById());
					break;
				case 4:
					java.util.Collections.sort(list,new SortByAge());
					break;
				case 5:
					displayList(list);
					break;
				case 6:
					System.exit(0);
				default:
					System.out.println("Invalid Choice");
			}
		}

		

		// System.out.println("After Sort");

		// System.out.println("List :" + list );		

	}

	public static void displayList(List list) {
		for(Object o : list) {
			System.out.println(o);
		}
	}
}

class SortByFirstName implements Comparator {
	@Override
	public int compare(Object ref1, Object ref2) {
		if(ref1 instanceof Student && ref2 instanceof Student) {
			String []s1 = ((Student)ref1).getName().split(" ");
			String []s2 = ((Student)ref2).getName().split(" ");
			return s1[0].compareTo(s2[0]);
		}
		else {
			return -1;
		}

	}
}
class SortByLastName { //implements Comparator {
	// @Override
	// public int compare(Object ref1, Object ref2) {
		
	// }
}
class SortById implements Comparator {
	@Override
	public int compare(Object ref1, Object ref2) {
		if(ref1 instanceof Student && ref2 instanceof Student) {
			return ((Student)ref1).getId().compareTo(((Student)ref2).getId());
		}
		else {
			return -1;
		}
	}
}

class SortByAge implements Comparator  {
	@Override
	public int compare(Object ref1, Object ref2) {
		if(ref1 instanceof Student && ref2 instanceof Student) {
			return ((Student)ref1).getAge().compareTo(((Student)ref2).getAge());
		}
		else {
			return -1;
		}
	}
}