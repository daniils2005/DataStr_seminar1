package service;

import java.util.Arrays;

import datastr.MyArrayList;

public class MainService {

	public static void main(String[] args) {
		MyArrayList symbols = new MyArrayList(3);
		symbols.add('a');
		symbols.add('b');
		symbols.add('c');
		symbols.add('a');
		
		try {
			symbols.print();
			System.out.println();
			symbols.add('Z', 1);
			symbols.print();
			System.out.println();
			symbols.remove(2);
			symbols.print();
			System.out.println();
			
			System.out.println(symbols.get(1));
			System.out.println(symbols.find('a'));
			
			System.out.println(Arrays.toString(symbols.getNextElements('a')));
			
		} catch(Exception e) {
			System.out.println(e);
		}

	}
}
