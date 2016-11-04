package com.book.chap3.animal.shelter;

import java.util.LinkedList;
import java.util.ListIterator;

public class AnimalShelter<T extends Animal> {
	
	LinkedList<Animal> list = null;
	
	public AnimalShelter() {
		list = new LinkedList<Animal>();
	}
	
	public void enqueue(T animal) {
		list.addLast(animal);
	}
	
	public Animal dequeueAny() {
		return list.removeFirst();
	}
	
	public Dog dequeueDog() {
		ListIterator<Animal> iterator = list.listIterator();
		Animal animal = null;
		int index=0;
		boolean found = false;
		while(iterator.hasNext()) {
			animal = iterator.next();
			if(animal instanceof Dog) {
				found = true;
				break;
			}
			index += 1;
		}
		if(!found)
			throw new RuntimeException("No more Dogs in the Animal Shelter!");
		list.remove(index);
		return (Dog) animal;
	}
	
	public Cat dequeueCat() {
		ListIterator<Animal> iterator = list.listIterator();
		Animal animal = null;
		int index=0;
		boolean found = false;
		while(iterator.hasNext()) {
			animal = iterator.next();
			if(animal instanceof Cat) {
				found = true;
				break;
			}
			index += 1;
		}
		if(!found)
			throw new RuntimeException("No more Cats in the Animal Shelter!");
		list.remove(index);
		return (Cat) animal;
	}
}
