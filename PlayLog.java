// List.java
// Nikolai Chen
// nmchen
// pa1
// List.java is a doubly linked list implementation of a linked list
// This stores integers and can itterate forwards and backwards through the list

public class PlayLog {

	private class Node {

		private Node previous;
		private Node next;
		private Player p;
		private String statistic;
		private int passValue;
		private Player[] blockingPartners;
		private Player associate;

		public Node(Player p, String statistic, int passValue, Player[] blockingPartners, Player associate) {
			previous = null;
			next = null;
			this.p = p;
			this.statistic = statistic;
			this.passValue = passValue;
			this.blockingPartners = blockingPartners;
			this.associate = associate;
		}

		public String playerName() {
			return p.name();
		}

		public int passValue() {
			return passValue;
		}

		public String blockingPartners() {
			StringBuffer sb = new StringBuffer("");
			if (blockingPartners !=  null) {
				if (blockingPartners.length == 1) {
					sb.append("and " + blockingPartners[0].name() + " ");
				} else {
					sb.append(blockingPartners[0].name() + ", and " + blockingPartners[1].name() + " ");
				}
			}
			return new String(sb);
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			switch(statistic) {
				case "serve": 	if (passValue == 4) {
									sb.append(playerName() + " missed his serve");
								} else if (associate != null) {
									if (passValue == 0) {
										sb.append(playerName() + " aced " + associate.name());
									} else {
										sb.append(p.name() + " served " + associate.name() + " and he passed a " + passValue + " ball");
									}									
								} else {
									if (passValue == 0) {
										sb.append(playerName() + " served an ace");
									} else {
										sb.append(p.name() + "'s serve got a " + passValue + " pass");
									}	
								}
								break;
				case "pass":	sb.append(playerName() + " passed a " + passValue + " ball");
								break;
				case "kill":	if (associate != null) {
									sb.append(playerName() + " got a kill off of an assist from " + associate.name());
								} else {
									sb.append(playerName() + " got a kill");
								}
								break;
				case "hitting error":	sb.append(playerName() + " had a hitting error");
								break;
				case "hitting attempt":	if (associate != null) {
											sb.append(playerName() + " took a hitting attempt and got dug by " + associate.name());
										} else {
											sb.append(playerName() + " took a hitting attempt");
										}
								break;
				case "dig":	if (associate != null) {
								sb.append(playerName() + " dug " + associate.name());
							} else {
								sb.append(playerName() + " got a dig");
							}
							break;
				case "solo block":	if (associate != null) {
										sb.append(playerName() + " solo blocked " + associate.name());
									} else {
										sb.append(playerName() + " got a solo block");
									}
								break;
				case "block assist":	if (associate != null) {
											sb.append(playerName() + " " + blockingPartners() + "blocked " + associate.name());
										} else {
											sb.append(playerName() + " " + blockingPartners() + "all got block assists");
										}
								break;
				case "blocking error":	sb.append(playerName() + " had a blocking error");
								break;
				case "ball handling error": sb.append(playerName() + " had a ball handling error");
								break;
				default:	System.out.println(statistic);
							System.out.println("PlayLog: history save failed");
							break;
				
			}
			return new String(sb);
		}

	}

	private Node front;
	private Node back;
	private Node cursor;
	private int size;
	private int index;

	// List()
	// Creates a new empty list.
	public PlayLog() {

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
	public String front() {

		if (size == 0) {
			throw new RuntimeException("List Error: front() called on empty list");
		} else {
			return front.toString();
		}

	}

	// back()
	// returns back element.
	// Pre: length() > 0
	public String back() {

		if (size == 0) {
			throw new RuntimeException("List Error: back() called on empty list");
		} else {
			return back.toString();
		}

	}


	// get()
	// returns cursor element.
	// Pre: length() > 0, index() >= 0
	public String get() {

		if (size == 0) {
			throw new RuntimeException("List Error: get() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("List Error: get() called with no item selected");
		} else {
			return cursor.toString();
		}

	}


	// equals()
	// returns true if this List and L are the same integer sequence.
	// The cursor is ignored in both lists.
	// public boolean equals(List L) {

	// 	boolean eq = false;
	// 	Node a = this.front;
	// 	Node b = L.front;
	// 	eq = (this.length() == L.length());

	// 	while(eq && a != null){
	// 		eq = (a.data == b.data);
	// 		a = a.next;
	// 		b = b.next;
	// 	}

	// 	return eq;

	// }


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
	public void prepend(Player p, String statistic, int passValue, Player[] blockingPartners, Player associate) {

		Node n = new Node(p, statistic, passValue, blockingPartners, associate);
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
	public void append(Player p, String statistic, int passValue, Player[] blockingPartners, Player associate) {

		Node n = new Node(p, statistic, passValue, blockingPartners, associate);
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
	public void insertBefore(Player p, String statistic, int passValue, Player[] blockingPartners, Player associate) {

		if (size == 0) {
			throw new RuntimeException("List Error: insertBefore() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("List Error: insertBefore() called with no item selected");
		} else {
			Node n = new Node(p, statistic, passValue, blockingPartners, associate);
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
	public void insertAfter(Player p, String statistic, int passValue, Player[] blockingPartners, Player associate) {

		if (size == 0) {
			throw new RuntimeException("List Error: insertAfter() called on empty list");
		} else if (index < 0) {
			throw new RuntimeException("List Error: insertAfter() called with no item selected");
		} else {
			Node n = new Node(p, statistic, passValue, blockingPartners, associate);
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
			throw new RuntimeException("List Error: deleteFront() called on empty list");
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
			throw new RuntimeException("List Error: back() called on empty list");
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
			throw new RuntimeException("List Error: delete() called on empty List");
		} else if (index == -1) {
			throw new RuntimeException("List Error: delete() called with no cursor selection");
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
			sb.append(a);
			if (a.next != null) {
				sb.append("\n");
			}
			a = a.next;
		}
		return new String(sb);

	}

	// copy()
	// Returns a new List representing the same integer sequence as this
	// List. The cursor in the new list is undefined, regardless of the
	// state of the cursor in this List. This List is unchanged.
	// public List copy() {

	// 	List l = new List();
	// 	Node a = front;
	// 	while(a != null) {
	// 		l.append(a.item);
	// 		a = a.next;
	// 	}
	// 	return l;

	// }

}