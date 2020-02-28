package cse360assign2;
/**
 *
 * @author Hang Qu SimpleList for CSE 360 Assignment 1.
 *
 */
public class SimpleList {
	private int[] list; // - list : int[];
	private int count; // - count : int;

	public SimpleList() // + SimpleList();
	{
		this.list = new int[10]; // set the size to 10;
		this.count = 0; // initial count set to 0;
	}

	public void add(int element) // + add(int) : void
	{
		// int n = 10;
		if (this.count == list.length) {
			int h = this.count / 2;
			resize(count + h);
		}

//		if (this.count == 0)
//		{
//			list[0] = element; 
//			this.count++;   // count the number of the elements;
//		}

		for (int i = this.count - 1; i > 0; i--) {
			list[i] = list[i - 1]; // move element to the back

		}
		list[0] = element; // put the element at first position
		this.count++; // count the number of the elements;
	}

	public void remove(int element) // + remove (int): void
	{

		int n = list.length;
		int rmEle = search(element);

//		if(list[n] == 0)
//		for (int i = 0; i < n; i++) 
//		{
//			if (list[i] == element) 
//			{
//				rmEle = i;         // found element, set the rmEle to the position in the list
//				this.count--;
//			}
//		}
		if (rmEle != -1) // remove found element
		{
			for (int i = rmEle; i < n - 1; i++) {
				list[i] = list[i + 1]; // Move elements which after the target element
			}
			this.count--;
			list[n - 1] = 0; // set the last element to 0
		} else {
			System.out.println("There is no such element."); // element not found
		}

		// find 75% location
		int l = 3 * list.length / 4;
		if (this.count < l) {
			resize(this.count);
		}

	}

	public int count() // + count (): int
	{
		return this.count;
	}

	public String toString() // + toString (): String
	{
		String listStr = "";

		for (int i = 0; i < 10; i++) {
			listStr += list[i] + " "; // print elements one by one
		}

		return listStr.trim();
	}

	public int search(int element) // + search (): int
	{
		int n = 10;

		int found = -1;
		for (int i = 0; i < n; i++) {
			if (list[i] == element) {
				found = i;
			}
		}
		if (found != -1) {
			return found; // return the position in the list
		} else {
			System.out.println("There is no such element.");
			return found;
		}
	}
	
	// add a new method to change the size of the list
		public void resize(int s) {
			int array[] = new int[s];

			// copy the list elements to the new array
			for (int i = 0; i < s && i < this.count; i++) {
				array[i] = list[i];
			}

			list = array;

			if (s < this.count) {
				this.count = s;
			}
		}
		
		public void append(int element) {

			// increasing size if full
			if (this.count == list.length) {

				int h = this.count / 2;

				resize(this.count + h);

			}

			// adding at count index
			list[this.count] = element;
			this.count++;

		}

		// returns the first element

		public int first() {

			// throw the exception (change to return -1 if you dont want to use
			// exceptions) if there is no first element
			if (this.count == 0) {

				throw new RuntimeException("list is empty!");

			}

			// otherwise returning first element

			return list[0];
			

		}
		public int last() {

			// throw the exception (change to return -1 if you dont want to use
			// exceptions) if there is no first element
			if (this.count == 0) {

				throw new RuntimeException("list is empty!");

			}

			// otherwise returning first element

			return list[this.count];
		}

		// returns the current capacity (might not be the same as count)

		public int size() {

			return list.length;

		}

}

