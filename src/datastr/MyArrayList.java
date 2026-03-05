package datastr;

import java.util.ArrayList;

public class MyArrayList {
	//mainigie
	private char[] list;
	private int howManyElements = 0;
	private final int DEFAULT_SIZE = 8;
	private int size = DEFAULT_SIZE;
	
	//konstruktori
	public MyArrayList() {
		list = new char[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0 && inputSize < 100000) {
			size = inputSize;
		}
		list = new char[size];
	}
	
	//funckijas
	private boolean isEmpty() {
		return (howManyElements == 0);
	}
	llegalArgumentE
	private boolean isFull() {
		return (howManyElements == size);
	}

	//resize
	private void resize() {
		int newSize = (howManyElements < 200) ? (size * 2) : (int)(size * 1.5);
		char[] newList = new char[newSize];
		
		for(int i = 0; i < howManyElements; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		size = newSize;
		System.gc();
	}
	
	public void add(char element) {
		if(isFull()) {
			resize();
		}
		list[howManyElements] = element;
		howManyElements++;
		
		if(isFull()) resize();
	}
	
	public void add(char element, int index) throws IllegalArgumentException {
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams pievienot elementu, jo indekss ir negativs");
		}
		if(index > howManyElements) {
			throw new IllegalArgumentException("Nav iespejams pieveinot elementu, jo indekss parsniedz elementu skaitu");
		}
		if(isFull()) resize();
		
		if(index == howManyElements) {
			add(element);
			return;
		}
		
		for(int i = howManyElements; i > index; i--) {
			list[i] = list[i - 1];
		}
		
		list[index] = element;
		howManyElements++;
	}
	
	public void remove(int index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Nav iespejams dzest elementu, jo saraksts ir tukss");
		}
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams dzest elementu, jo indekss ir negativs");
		}
		if(index >=  howManyElements) {
			throw new IllegalArgumentException("Nav iespejams dzest elementu, jo indekss parsniedz elementu skaitu");
		}
		
		for(int i = index; i < howManyElements - 1; i++) {
			list[i] = list[i + 1];
		}
		
		list[--howManyElements] = ' ';
	}
	
	public char get(int index) throws Exception {
		if(isEmpty()) {
			throw new Exception("Nav iespejams iegut elementu, jo saraksts ir tukss");
		}
		if(index < 0) {
			throw new IllegalArgumentException("Nav iespejams iegut elementu, jo indekss ir negativs");
		}
		if(index >=  howManyElements) {
			throw new IllegalArgumentException("Nav iespejams iegut elementu, jo indekss parsniedz elementu skaitu");
		}
		return list[index];
	}
	
	public int[] find(char element) throws Exception{
		if(isEmpty()) {
			throw new Exception("Nav iespejams iegut elementu, jo saraksts ir tukss");
		}
		
		int howManyIndexes = 0;
		for(var i : list) {
			if(i == element) {
				howManyIndexes++;
			}
		}
		
		int index = 0;
		int[] indexArray = new int[howManyIndexes];
		int first = 0;
		int second = howManyElements - 1;
		
		while(first <= second) {
			if(list[first] == element) indexArray[index++] = first;
			if(list[second] == element) indexArray[index++] = second;
			first++;
			second = howManyElements - 1 - first;
		}
		if(index == 0) {
			throw new Exception("Elements netika atrasts");
		}
		return indexArray;
	}
	
	public char getNext(char element) throws Exception {
		if(find(element) == -1) {
			throw new Exception("Padotais elements netika atrasts");
		}
		if(find(element) == howManyElements - 1) {
			throw new IllegalArgumentException("Nakamais elements neeksiste");
		}
		return list[find(element) + 1];
	}
	
	public void sort() {
		char temp;
		for(int i = 0; i < howManyElements; i++) {
			for(int j = i; j < howManyElements; j++) {
				if(list[i] > list[j]) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	
	public int getHowManyElements() {
		return howManyElements;
	}
	
	public void print() {
		System.out.print("[");
		for(int i = 0; i < howManyElements; i++) {
			if(i == howManyElements - 1) {
				System.out.print(get(i));
			} else {
				System.out.print(get(i) + ", ");
			}
		}
		System.out.print("]");
	}
}
