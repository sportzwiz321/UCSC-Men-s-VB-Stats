import java.text.DecimalFormat;

public class PlayerList {

	private class Node {

		String nickName;
		String name;
		Player person;
		Node next;

		Node(String nickName, String name, String position) {
			this.nickName = nickName;
			this.name = name;
			person = new Player(name, position);
		}

	}

	private Node head;
	private Node tail;
	private int size;
	private int digs;
	private int kills;
	private int hittingErrors;
	private int hittingAttempts;
	private double hittingPercentage;
	private int[] serveReceivePasses;
	private int passingPoints;
	private int passingAttempts;
	private double receivingAverage;
	private int ballHandlingErrors;
	private int[] serving;
	private int servingPoints;
	private int servingAttempts;
	private double servingAverage;
	private int soloBlocks;
	private int blockAssists;
	private int blockingErrors;
	private double blockPoints;
	private double totalPoints;
	private int totalErrors;
	private int assists;
	private int outsides;
	private int opposites;
	private int setters;
	private int middles;
	private int liberos;

	// returns the Node, if it exists, given its String key
	private Node findKey(String nickName) {
		Node n = head;
		while(n != null) {
			if (n.nickName.equals(nickName)) {
				return n;
			} else {
				n = n.next;
			}
		}
		return null;
	}

	private Node findKeyByName(String name) {
		Node n = head;
		while(n != null) {
			if (n.name.equals(name)) {
				return n;
			} else {
				n = n.next;
			}
		}
		return null;
	}

	public PlayerList() {
		head = null;
		size = 0;
		tail = null;
		digs = 0;
		kills = 0;
		hittingErrors = 0;
		hittingAttempts = 0;
		hittingPercentage = 0;
		serveReceivePasses = new int[4];
		for (int i = 0; i < 4; i++) {
			serveReceivePasses[i] = 0;
		}
		passingPoints = 0;
		passingAttempts = 0;
		receivingAverage = 0;
		serving = new int[5];
		for (int i = 0; i < 5; i++) {
			serving[i] = 0;
		}
		servingPoints = 0;
		servingAttempts = 0;
		servingAverage = 0;
		soloBlocks = 0;
		blockAssists = 0;
		blockingErrors = 0;
		blockPoints = 0;
		totalPoints = 0;
		totalErrors = 0;
		assists = 0;
		outsides = 0;
		opposites = 0;
		setters = 0;
		middles = 0;
		liberos = 0;
	}

	public int digs() {
		return digs;
	}

	public int kills() {
		return kills;
	}

	public int hittingErrors() {
		return hittingErrors;
	}

	public int hittingAttempts() {
		return hittingAttempts;
	}

	public double hittingPercentage() {
		return hittingPercentage;
	}

	public int threePasses() {
		return serveReceivePasses[0];
	}

	public int twoPasses() {
		return serveReceivePasses[1];
	}

	public int onePasses() {
		return serveReceivePasses[2];
	}

	public int zeroPasses() {
		return serveReceivePasses[3];
	}

	public int passingPoints() {
		return passingPoints;
	}

	public int passingAttempts() {
		return passingAttempts;
	}

	public double receivingAverage() {
		return receivingAverage;
	}

	public int ballHandlingErrors() {
		return ballHandlingErrors;
	}

	public int serviceAces() {
		return serving[0];
	}

	public int onePassServes() {
		return serving[1];
	}

	public int twoPassServes() {
		return serving[2];
	}

	public int threePassServes() {
		return serving[3];
	}

	public int serviceErrors() {
		return serving[4];
	}

	public int servingPoints() {
		return servingPoints;
	}

	public int servingAttempts() {
		return servingAttempts;
	}

	public double servingAverage() {
		return servingAverage;
	}

	public int soloBlocks() {
		return soloBlocks;
	}

	public int blockAssists() {
		return blockAssists;
	}

	public int blockingErrors() {
		return blockingErrors;
	}

	public double blockPoints() {
		return blockPoints;
	}

	public double totalPoints() {
		return totalPoints;
	}

	public int totalErrors() {
		return totalErrors;
	}

	public int assists() {
		return assists;
	}

	public int outsides() {
		return outsides;
	}

	public int opposites() {
		return opposites;
	}

	public int setters() {
		return setters;
	}

	public int middles() {
		return middles;
	}

	public int liberos() {
		return liberos;
	}

	public String[] teamNames() {
		String[] roster = new String[size];
		Node p = head;
		for (int i = size - 1; i >= 0; i--) {
			roster[i] = p.person.name();
			p = p.next;
		}
		return roster;
	}

	public String[] passingPlayers() {

		String[] roster = new String[outsides + liberos + 1];
		Node p = head;
		int i = outsides + liberos;
		while(p != null && i >= 0) {
			if (p.person.position().equals("OH") || p.person.position().equals("L") || p.person.name().equals("Micky")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] nonPassingPlayers() {

		String[] roster = new String[opposites + setters + middles - 1];
		Node p = head;
		int i = opposites + setters + middles - 2;
		while(p != null && i >= 0) {
			if (!(p.person.position().equals("OH") || p.person.position().equals("L")) && !p.person.name().equals("Micky")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] primaryFrontRowPlayers() {

		String[] roster = new String[outsides + middles + opposites];
		Node p = head;
		int i = outsides + middles + opposites - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("OH") || p.person.position().equals("MB") || p.person.position().equals("OPP")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] secondaryFrontRowPlayers() {

		String[] roster = new String[setters + liberos];
		Node p = head;
		int i = setters + liberos - 1;
		while(p != null && i >= 0) {
			if (!(p.person.position().equals("OH") || p.person.position().equals("MB") || p.person.position().equals("OPP"))) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] teamPartOne() {
		String[] roster = new String[outsides + liberos];
		Node p = head;
		int i = outsides + liberos - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("OH") || p.person.position().equals("L")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;
	}

	public String[] teamPartTwo() {

		String[] roster = new String[opposites + setters + middles];
		Node p = head;
		int i = opposites + setters + middles - 1;
		while(p != null && i >= 0) {
			if (!(p.person.position().equals("OH") || p.person.position().equals("L"))) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] pinList() {

		String[] roster = new String[opposites + outsides];
		Node p = head;
		int i = opposites + outsides - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("OH") || p.person.position().equals("OPP")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] middleList() {

		String[] roster = new String[middles];
		Node p = head;
		int i = middles - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("MB")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] setterList() {

		String[] roster = new String[setters];
		Node p = head;
		int i = setters - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("S")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public String[] liberoList() {

		String[] roster = new String[liberos];
		Node p = head;
		int i = liberos - 1;
		while(p != null && i >= 0) {
			if (p.person.position().equals("L")) {
				roster[i] = p.person.name();
				i--;
			}
			p = p.next;
		}
		return roster;

	}

	public void addPass(Player p, int x) {
		serveReceivePasses[3 - x] += 1;
		passingPoints += x;
		passingAttempts += 1;
		receivingAverage = Math.round((double)passingPoints/(double)passingAttempts * 100.0) / 100.0;
		p.addPass(x);
	}

	public void addServe(Player p, int x) {
		if (x == 0) {
			totalErrors += 1;
		}
		if (x == 4) {
			totalPoints += 1;
		}
		serving[4 - x] += 1;
		servingPoints += x;
		servingAttempts += 1;
		servingAverage = Math.round((double)servingPoints/(double)servingAttempts * 100.0) / 100.0;
		p.addServe(x);
	}

	public void addAssist(Player p) {
		assists += 1;
		p.addAssist();
	}

	public void addDig(Player p) {
		digs += 1;
		p.addDig();
	}

	public void addKill(Player p) {
		kills += 1;
		hittingAttempts += 1;
		totalPoints += 1;
		updateHittingPercentage();
		p.addKill();
	}

	public void addHittingError(Player p) {
		hittingErrors += 1;
		hittingAttempts += 1;
		totalErrors += 1;
		updateHittingPercentage();
		p.addHittingError();
	}

	public void addHittingAttempt(Player p) {
		hittingAttempts += 1;
		updateHittingPercentage();
		p.addHittingAttempt();
	}

	public void addSoloBlock(Player p) {
		soloBlocks += 1;
		blockPoints += 1;
		totalPoints += 1;
		p.addSoloBlock();
	}

	public void addBlockAssist(Player p) {
		blockAssists += 1;
		blockPoints += 0.5;
		totalPoints += 0.5;
		p.addBlockAssist();
	}

	public void addBlockingError(Player p) {
		blockingErrors += 1;
		totalErrors += 1;
		p.addBlockingError();
	}

	public void addBallHandlingError(Player p) {
		ballHandlingErrors += 1;
		totalErrors += 1;
		p.addBallHandlingError();
	}

	private void updateHittingPercentage() {
		hittingPercentage = Math.round((double)(kills - hittingErrors)/(double)hittingAttempts*1000.0)/1000.0;
	}


	// returns true or false whethere the list is empty or not
	public boolean isEmpty() {

		return (size == 0);

	}

	// returns the number of items in the list
	public int size() {

		return size;

	}

	// returns the value of an entry given its key, if it exists
	public Player lookup(String nickName) {

		Node n = findKey(nickName);

		if(n != null) {
			return n.person;
		} else {
			return null;
		}

	}

	public Player lookupByName(String name) {

		Node n = findKeyByName(name);

		if(n != null) {
			return n.person;
		} else {
			return null;
		}

	}

	// inserts a new Node entry at the end of the list if, that key is not already in the list
	public void insert(String nickName, String name, String position) throws DuplicateKeyException {

		if (findKey(nickName) != null) {
			throw new DuplicateKeyException("insert() called on already existing key");
		} else if (size == 0) {
			head = new Node(nickName, name, position);
			tail = head;
			size++;
		} else {
			tail.next = new Node(nickName, name, position);
			tail = tail.next;
			size++;
		}

		switch(position) {
			case "OH":	outsides++;
						break;
			case "OPP": opposites++;
						break;
			case "S":	setters++;
						break;
			case "MB":	middles++;
						break;
			case "L":	liberos++;
						break;
			default:
						break;
		}

	}

	// removes all pointers to a given Node, if it exists in the list already
	public void delete(String nickName) throws KeyNotFoundException {

		Node c = findKey(nickName);
		if (c == null) {
			throw new KeyNotFoundException("delete() called on a non-existent key");
		} else {
			Node p = head;
			if(p == c) {

				head = p.next;

			} else if (tail == c) {

				while(p.next != tail) {
					p = p.next;
				}
				tail = p;
				p.next = null;

			} else {

				while(p.next != c) {
					p = p.next;
				}
				p.next = c.next;
				c.next = null;

			}
			size--;
		}

	}

	// makes the list empty, the new head and tail state does not point to anything and there are now 0 items in the list
	public void makeEmpty() {

		head = null;
		size = 0;
		tail = null;

	}

	public String roster() {

		Node p = head;
		StringBuffer roster = new StringBuffer();
		int i = 1;
		while(p != null) {
			roster.append(i + ". " + p.person.name() + " (" + p.nickName + ")\n");
			p = p.next;
			i++;
		}

		return new String(roster);

	}

	public String extendedServeReceive() {

		StringBuffer sb = new StringBuffer();

		sb.append(threePasses() + " " + twoPasses() + " " + onePasses() + " " + zeroPasses() + " ");

		sb.append("| " + passingPoints + " " + passingAttempts + " " + twoDecimalConvert(receivingAverage));

		return new String(sb);

	}

	public String serveReceive() {

		StringBuffer sb = new StringBuffer();

		sb.append(threePasses() + " " + twoPasses() + " " + onePasses() + " " + zeroPasses() + " ");

		sb.append("| " + twoDecimalConvert(receivingAverage));

		return new String(sb);

	}

	public String passingLeaders() {

		Leaderboard passing = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.totalAttempts() != 0) {
				if (passing.length() == 0) {
					passing.append(p.person);
				} else {
					passing.moveFront();
					while(passing.index() >= 0 && p.person.passingAverage() < passing.get().passingAverage()) {
						passing.moveNext();
					}
					if (passing.index() == -1) {
						passing.append(p.person);
					} else if (p.person.passingAverage() == passing.get().passingAverage()) {
						if (p.person.zeroPasses() > passing.get().zeroPasses()) {
							passing.insertAfter(p.person);
						} else {
							passing.insertBefore(p.person);
						}
					} else {
						passing.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return passing.toString();

	}

	public String servingAverageLeaders() {
		Leaderboard passing = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.servingAttempts() != 0) {
				if (passing.length() == 0) {
					passing.append(p.person);
				} else {
					passing.moveFront();
					while(passing.index() >= 0 && p.person.servingAverage() < passing.get().servingAverage()) {
						passing.moveNext();
					}
					if (passing.index() == -1) {
						passing.append(p.person);
					} else if (p.person.servingAverage() == passing.get().servingAverage()) {
						if (p.person.serviceErrors() > passing.get().serviceErrors()) {
							passing.insertAfter(p.person);
						} else {
							passing.insertBefore(p.person);
						}
					} else {
						passing.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return passing.servingLine();
	}

	public String servingTotalLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.servingAttempts() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.servingAttempts() < hitting.get().servingAttempts()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else if (p.person.servingAttempts() == hitting.get().servingAttempts()) {
						while(hitting.index() >= 0 && p.person.servingAverage() < hitting.get().servingAverage()) {
							hitting.moveNext();
						}
						if (hitting.index() == -1) {
							hitting.append(p.person);
						} else {
							hitting.insertBefore(p.person);
						}
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.servingTotalLine();
	}

	public String hittingLeaders() {

		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.hittingAttempts() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.hittingPercentage() < hitting.get().hittingPercentage()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else if (p.person.hittingPercentage() == hitting.get().hittingPercentage()) {
						if (p.person.hittingErrors() > hitting.get().hittingErrors()) {
							hitting.insertAfter(p.person);
						} else {
							hitting.insertBefore(p.person);
						}
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.hittingLine();

	}

	public String blockingLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.blockPoints() != 0 || p.person.blockingErrors() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.blockPoints() < hitting.get().blockPoints()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else if (p.person.blockPoints() == hitting.get().blockPoints()) {
						if (p.person.blockingErrors() > hitting.get().blockingErrors()) {
							hitting.insertAfter(p.person);
						} else {
							hitting.insertBefore(p.person);
						}
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.blockingLine();
	}

	public String diggingLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.digs() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.digs() <= hitting.get().digs()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.diggingLine();
	}

	public String assistLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.assists() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.assists() <= hitting.get().assists()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.assistLine();
	}

	public String ballHandlingErrorLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.ballHandlingErrors() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.ballHandlingErrors() <= hitting.get().ballHandlingErrors()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.ballHandlingErrorLine();
	}

	public String totalPointLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.totalPoints() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.totalPoints() <= hitting.get().totalPoints()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.totalPointsLine();
	}

	public String totalErrorLeaders() {
		Leaderboard hitting = new Leaderboard();
		Node p = head;
		while(p != null) {
			if (p.person.totalErrors() != 0) {
				if (hitting.length() == 0) {
					hitting.append(p.person);
				} else {
					hitting.moveFront();
					while(hitting.index() >= 0 && p.person.totalErrors() <= hitting.get().totalErrors()) {
						hitting.moveNext();
					}
					if (hitting.index() == -1) {
						hitting.append(p.person);
					} else {
						hitting.insertBefore(p.person);
					}
				}
			}
			
			p = p.next;
		}
		return hitting.totalErrorsLine();
	}

	public String hittingLine() {
		Node p = head;
		StringBuffer dictionary = new StringBuffer();
		while(p != null) {
			dictionary.append(p.person.name() + " (" + p.nickName + ") " + p.person.hittingLine() + "\n");
			p = p.next;
		}
		return new String(dictionary);
	}

	public String extendedHittingLine() {

		StringBuffer sb = new StringBuffer();

		sb.append("Team Total ");

		sb.append(kills + " " + hittingErrors + " " + hittingAttempts + " | " + threeDecimalConvert(hittingPercentage));

		return new String(sb);

	}

	public String extendedToString() {
		Node p = head;
		StringBuffer dictionary = new StringBuffer();
		while(p != null) {
			dictionary.append(p.person.name() + " (" + p.nickName + ") " + p.person.extendedServeReceive() + "\n");
			p = p.next;
		}

		return new String(dictionary);
	}

	// appends all the keys and values of each node into a StringBuffer which is then returned as a String when completed
	public String toString() {

		Node p = head;
		StringBuffer dictionary = new StringBuffer();
		while(p != null) {
			dictionary.append(p.person.name() + " (" + p.nickName + ") " + p.person.serveReceive() + "\n");
			p = p.next;
		}

		return new String(dictionary);
	}

	public String statLine() {

		Node p = head;
		StringBuffer dictionary = new StringBuffer();
		while(p != null) {
			dictionary.append(p.person.name() + " (" + p.nickName + ")\t" + p.person.statLine() + "\n");
			p = p.next;
		}

		return new String(dictionary);

	}

	public String serveAndPassLine() {
		StringBuffer sb = new StringBuffer();
		Node p = head;
		Player cal;
		while(p != null) {
			cal = p.person;
			sb.append(cal.name() + "(" + p.nickName + ")\t");
			if (cal.name().length() < 4) {
				sb.append("\t");
			}
			sb.append(cal.servingLine());
			if (cal.position().equals("OH") || cal.position().equals("L") || cal.name().equals("Micky")) {
				sb.append(" || " + cal.serveReceive());
			}
			if (p.next != null) {
				sb.append("\n");
			}
			p = p.next;
		}
		return new String(sb);
	}

	public String servingLine() {
		return new String(serviceAces() + " " + onePassServes() + " " + twoPassServes() + " " + threePassServes() + " " + serviceErrors() + " | " + twoDecimalConvert(servingAverage()));
	}

	public String teamServeAndPassLine() {
		return new String("Passing: " + serveReceive() + "\nServing: " + servingLine());
	}

	public String teamStatLine() {

		StringBuffer sb = new StringBuffer();
		sb.append("K/E/TA/K%: " + kills + "/" + hittingErrors + "/" + hittingAttempts + "/" + threeDecimalConvert(hittingPercentage) + "\n");
		sb.append("Receive(3/2/1/0/avg): " + threePasses() + "/" + twoPasses() + "/" + onePasses() + "/" + zeroPasses() + "/" + twoDecimalConvert(receivingAverage()) + "\n");
		sb.append("BS/BA/BE/TB: " + soloBlocks + "/" + blockAssists + "/" + blockingErrors + "/" + blockPoints + "\n");
		sb.append("SA/3/2/1/SE: " + serviceAces() + "/" + onePassServes() + "/" + twoPassServes() + "/" + threePassServes() + "/" + serviceErrors() + "/" + twoDecimalConvert(servingAverage()) + "\n");
		sb.append("Digs: " + digs + "\n");
		sb.append("Assists: " + assists + "\n");
		sb.append("Ball Handling Errors: " + ballHandlingErrors + "\n");
		sb.append("Total Points: " + totalPoints + "\n");
		sb.append("Total Errors: " + totalErrors + "\n");
		return new String(sb);

	}

	public String totalStatLine() {
		StringBuffer sb = new StringBuffer();
		Node p = head;
		Player cal;
		while(p != null) {
			cal = p.person;
			sb.append(cal.name() + "\t");
			if (cal.name().length() < 4) {
				sb.append("\t");
			}
			sb.append(cal.totalStatLine() + "\n");
			p = p.next;
		}
		sb.append("K/E/TA/K%: " + kills + "/" + hittingErrors + "/" + hittingAttempts + "/" + threeDecimalConvert(hittingPercentage) + "\n");
		sb.append("Receive(3/2/1/0/avg): " + threePasses() + "/" + twoPasses() + "/" + onePasses() + "/" + zeroPasses() + "/" + twoDecimalConvert(receivingAverage()) + "\n");
		sb.append("BS/BA/BE/TB: " + soloBlocks + "/" + blockAssists + "/" + blockingErrors + "/" + blockPoints + "\n");
		sb.append("SA/3/2/1/SE/avg: " + serviceAces() + "/" + onePassServes() + "/" + twoPassServes() + "/" + threePassServes() + "/" + serviceErrors() + "/" + twoDecimalConvert(servingAverage()) + "\n");
		sb.append("Digs: " + digs + "\n");
		sb.append("Assists: " + assists + "\n");
		sb.append("Ball Handling Errors: " + ballHandlingErrors + "\n");
		sb.append("Total Points: " + totalPoints + "\n");
		sb.append("Total Errors: " + totalErrors + "\n");
		return new String(sb);
	}

	private String twoDecimalConvert(double x) {
		DecimalFormat twoD = new DecimalFormat("#0.00");
		return new String(twoD.format(x));
	}

	private String threeDecimalConvert(double x) {
		DecimalFormat threeD = new DecimalFormat("#.000");
		return new String(threeD.format(x));
	}

}