// List.java
// Nikolai Chen
// nmchen
// pa1
// List.java is a doubly linked list implementation of a linked list
// This stores integers and can itterate forwards and backwards through the list

public class Leaderboard {

	private class Node {

		private Node previous;
		private Node next;
		private Player person;

		public Node(Player person) {
			previous = null;
			next = null;
			this.person = person;
		}

		public String toString() {
			return person.serveReceive() + " ";
		}

	}

	private Node front;
	private Node back;
	private Node cursor;
	private int size;
	private int index;

	// List()
	// Creates a new empty list.
	public Leaderboard() {

		front = null;
		back = null;
		cursor = null;
		size = 0;
		index = -1;


	}


	// length()
	// returns the number of elements in this List
	public int length() {

		return size;

	}


	// index()
	// if cursor is define, returns the index of the cursor element, otherwise returns -1
	public int index() {

		return index;

	}


	// front()
	// returns front element.
	// Pre: length() > 0
	public Player front() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: front() called on empty list");
		} else {
			return front.person;
		}

	}

	// back()
	// returns back element.
	// Pre: length() > 0
	public Player back() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: back() called on empty list");
		} else {
			return back.person;
		}

	}


	// get()
	// returns cursor element.
	// Pre: length() > 0, index() >= 0
	public Player get() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: get() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("Leaderboard Error: get() called with no item selected");
		} else {
			return cursor.person;
		}

	}


	// equals()
	// returns true if this List and L are the same integer sequence.
	// The cursor is ignored in both lists.
	public boolean equals(Leaderboard L) {

		boolean eq = false;
		Node a = this.front;
		Node b = L.front;
		eq = (this.length() == L.length());

		while(eq && a != null){
			eq = (a.person.equals(b.person));
			a = a.next;
			b = b.next;
		}

		return eq;

	}


	// clear()
	// resets this List to its original empty state.
	public void clear() {

		front = null;
		back = null;
		cursor = null;
		size = 0;
		index = -1;

	}

	// moveFront()
	// if the list is non-empty, places the cursor under the front element,
	// otherwise does nothing
	public void moveFront() {

		if (size > 0) {
			cursor = front;
			index = 0;
		}

	}

	// moveBack()
	// if the list is non-empty, places the cursor under the Back element,
	// otherwise does nothing
	public void moveBack() {

		if (size > 0) {
			cursor = back;
			index = size - 1;
		}

	}

	// movePrev()
	// If cursor is defined and not at front, moves cursor one step toward
	// front of this List, if cursor is defined and at front, cursor becomes
	// undefined, if cursor is undefined does nothing.
	public void movePrev() {

		if (index != -1 && index != 0) {
			cursor = cursor.previous;
			index -= 1;
		} else if (index == 0) {
			index = -1;
		}

	}

	// moveNext()
	// If cursor is defined and not at back, moves cursor one step toward
	// back of this List, if cursor is defined and at back, cursor becomes
	// undefined, if cursor is undefined does nothing.
	public void moveNext() {

		if (index != -1 && index != size - 1) {
			cursor = cursor.next;
			index += 1;
		} else if (index == size - 1) {
			index = -1;
		}

	}

	// prepend()
	// Insert new element into this List. If List is non-empty,
	// insertion takes place before front element.
	public void prepend(Player person) {

		Node n = new Node(person);
		if (size == 0) {
			front = n;
			back = n;
		} else {
			n.next = front;
			front.previous = n;
			front = n;
		}
		size++;
		if (index >= 0) {
			index++;
		}

	}

	// append()
	// Insert new element into this List. If List is non-empty,
	// insertion takes place after back element.
	public void append(Player person) {

		Node n = new Node(person);
		if (size == 0) {
			front = n;
			back = n;
		} else {
			n.previous = back;
			back.next = n;
			back = n;
		}
		size++;

	}

	// insertBefore()
	// Insert new element before cursor.
	// Pre: length()>0, index()>=0
	public void insertBefore(Player person) {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: insertBefore() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("Leaderboard Error: insertBefore() called with no item selected");
		} else {
			Node n = new Node(person);
			if (index == 0) {
				n.next = front;
				front.previous = n;
				front = n;
			} else {
				Node a = cursor.previous;
				a.next = n;
				n.previous = a;
				n.next = cursor;
				cursor.previous = n;
			}
			size++;
			index++;

		}

	}

	// insertAfter()
	// Inserts new element after cursor.
	// Pre: length()>0, index()>=0
	public void insertAfter(Player person) {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: insertAfter() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("Leaderboard Error: insertAfter() called with no item selected");
		} else {
			Node n = new Node(person);
			if (index == size - 1) {
				n.previous = back;
				back.next = n;
				back = n;
			} else {
				Node a = cursor.next;
				a.previous = n;
				n.next = a;
				n.previous = cursor;
				cursor.next = n;
			}
			size++;
		}

	}

	// deleteFront()
	// Deletes the front element.
	// Pre: length()>0
	public void deleteFront() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: deleteFront() called on empty list");
		} else {
			if (size == 1) {
				front = null;
				back = null;
			} else {
				front = front.next;
				front.previous = null;
			}
			size--;

			if (index == 0) {
				cursor = null;
				index = -1;
			} else if (index > 0) {
				index -= 1;
			}

		}

	}

	// deleteBack()
	// Deletes the back element.
	// Pre: length()>0
	public void deleteBack() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: back() called on empty list");
		} else {
			if (size == 1) {
				front = null;
				back = null;
			} else {
				back = back.previous;
				back.next = null;
			}

			if (index == size - 1) {
				cursor = null;
				index = -1;
			}

			size--;

		}

	}

	// delete()
	// Deletes cursor element, making cursor undefined.
	// Pre: length()>0, index()>=0
	public void delete() {

		if (size == 0) {
			throw new RuntimeException("Leaderboard Error: delete() called on empty List");
		} else if (index == -1) {
			throw new RuntimeException("Leaderboard Error: delete() called with no cursor selection");
		}

		if (size == 1) {
			front = null;
			back = null;
		} else if (index == 0) {
			front.next.previous = null;
			front = front.next;
		} else if (index == size - 1) {
			back.previous.next = null;
			back = back.previous;
		} else {
			cursor.previous.next = cursor.next;
			cursor.next.previous = cursor.previous;
		}

		cursor = null;
		index = -1;
		size--;

	}

	// toString()
	// Overrides Object's toString method. Returns a String
	// representation of this List consisting of a space
	// separated sequence of integers, with front on left.
	public String toString() {

		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.serveReceive() + "\n");
			a = a.next;
		}
		return new String(sb);

	}

	public String hittingLine() {

		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.hittingLine() + "\n");
			a = a.next;
		}
		return new String(sb);

	}

	public String blockingLine() {

		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.blockLine() + "\n");
			a = a.next;
		}
		return new String(sb);

	}

	public String diggingLine() {

		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.digs() + "\n");
			a = a.next;
		}
		return new String(sb);

	}

	public String servingLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.servingLine() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	public String servingTotalLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.servingAttempts() + " " + a.person.servingAverage() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	public String assistLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.assists() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	public String ballHandlingErrorLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.ballHandlingErrors() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	public String totalPointsLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.totalPoints() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	public String totalErrorsLine() {
		StringBuffer sb = new StringBuffer();
		Node a = front;
		while(a != null) {
			sb.append(a.person.name() + " " + a.person.totalErrors() + "\n");
			a = a.next;
		}
		return new String(sb);
	}

	// copy()
	// Returns a new List representing the same integer sequence as this
	// List. The cursor in the new list is undefined, regardless of the
	// state of the cursor in this List. This List is unchanged.
	public Leaderboard copy() {

		Leaderboard l = new Leaderboard();
		Node a = front;
		while(a != null) {
			l.append(a.person);
			a = a.next;
		}
		return l;

	}

}