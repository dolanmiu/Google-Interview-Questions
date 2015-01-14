package sorting;

import java.util.ArrayList;

public class PersonInsertionSort {
	class Person {
		public int weight;
		public int height;

		public Person() {

		}

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
		
		public Integer compareTo(Person p) {
			if (weight > p.weight && height > p.height) {
				return 1;
			}
			
			if (weight < p.weight && height < p.height) {
				return -1;
			}
			
			if (weight == p.weight && height == p.height) {
				return 0;
			}
			
			return null;
			
		}
	}

	public static Person[] modifiedInsertionSort(Person[] persons) {
		ArrayList<Person> sortedPersons = new ArrayList<Person>();

		for (Person person : persons) {
			for (int i = 0; i < sortedPersons.size(); i++) {
				Integer compareValue = person.compareTo(sortedPersons.get(i));
				if (compareValue == null) break;
				
				if (compareValue > 0) {
					sortedPersons.add(i + 1, person);
					break;
				}

				sortedPersons.add(i, person);
			}
			
			if (sortedPersons.size() == 0) {
				sortedPersons.add(person);
			}
		}

		return (Person[]) sortedPersons.toArray();
	}
}
