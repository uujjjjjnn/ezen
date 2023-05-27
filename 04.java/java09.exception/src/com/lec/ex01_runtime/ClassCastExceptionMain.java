package com.lec.ex01_runtime;

public class ClassCastExceptionMain {

	public static void main(String[] args) {
		Dog dog = new Dog();
		changeDog(dog);
	}

	private static void changeDog(Animal animal) {
		System.out.println(animal.getClass());
		Dog dog = (Dog) animal;
		System.out.println(dog);
		
		changeDog(new Cat());
		
	}

}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}