package com.test.tree;

import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> list;
	
	public Stack() {
		list = new ArrayList<T>();
	}

	public T pop() {
		T val = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return val;
	}
	
	public T getVal() {
		T val = list.get(list.size() - 1);
		return val;
	}
	
	public void push(T val) {
		list.add(val);
	}
	
	public int getSize() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
}
