package stacksAndQueues;

import java.util.LinkedList;


interface IDogCatStack {
	boolean enqueue(IAnimal animal);
	IAnimal dequeueAny();
	IDog dequeueDog();
	ICat dequeueCat();
}

public class DogCatShelter implements IDogCatStack {
	

	LinkedList<IAnimal> animals;

	public DogCatShelter() {
		animals = new LinkedList<IAnimal>();
	}

	public boolean enqueue(IAnimal animal) {
		return animals.add(animal);
	}

	
	public IAnimal dequeueAny() {
		return animals.poll();
	}
	
	public IDog dequeueDog() {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i) instanceof IDog) {
				IDog dog = (IDog)animals.remove(i);
				return dog;
			}
		} 
		return null;
	}
	
	public ICat dequeueCat() {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i) instanceof ICat) {
				ICat cat = (ICat)animals.remove(i);
				return cat;
			}
		}
		return null;
	}

}

class Dog implements IAnimal, IDog {

}

class Cat implements IAnimal, ICat {

}

 interface IDog {

}

 interface ICat {

}

interface IAnimal {

}
