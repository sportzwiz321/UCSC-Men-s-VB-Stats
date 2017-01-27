import javax.swing.*;
import java.io.*;

public class VBStats {

	public static void main(String[] args) throws IOException {

		String answer;
		PlayerList team = new PlayerList();
		int teamSize = 15;
		team.insert("mc", "Micky", "S");
		team.insert("sh", "Shad", "S");
		team.insert("ma", "Manley", "OH");
		team.insert("lm", "Lake", "OH");
		team.insert("kd", "Kyle D.", "OH");
		// team.insert("gg", "Gino", "OH");
		team.insert("jh", "Howard", "OPP");
		team.insert("jf", "Fort", "MB");
		team.insert("rc", "Ray", "MB");
		team.insert("cb", "Cam", "L");
		team.insert("ch", "Cody H.", "L");
		team.insert("js", "Santos", "L");
		team.insert("cc", "Cody C.", "L");
		// team.insert("kl", "Lutz", "MB");
		// team.insert("ek", "Kittle", "S");
		team.insert("cs", "Shane", "OPP");
		team.insert("cj", "Landel", "OH");
		team.insert("cm", "Mauro", "OH");
		// team.insert("cp", "Paul", "S");

		answer = "";

		if (args.length < 1) {
			System.out.println("Usage: Simulation <input file>");
			System.exit(1);
		}

		int choice;

		do {

			while(!tryParseInt(answer)) {
				answer = JOptionPane.showInputDialog(null, team.roster() + "What are you tracking today?\n1. Passing\n2. Serving and Passing\n3. Everything\n4. Pass Testing");
			}

			choice = Integer.parseInt(answer);

		} while(choice != 1 && choice != 2 && choice != 3 && choice != 4);

		if (choice == 1) {
			passStats(team, args[0] + "passing.txt");
		} else if (choice == 2) {
			serveAndPass(team, args[0] + "serveAndPass.txt");
		} else if (choice == 3) {
			allStats(team, args[0] + "game.txt");
		} else {
			passStatsTest(team);
		}

		

		// PrintWriter statSheet = new PrintWriter(new FileWriter(args[0] + ".txt"));

		// do {

		// 	answer = JOptionPane.showInputDialog(null, team.roster() + "Would you like to make any changes to the current roster?\n1. Yes\n2. No");


		// } while ((!answer.equals("1")) && (!answer.equals("2")));

		// int ans = Integer.parseInt(answer);

		// if (ans == 1) {
			
		// 	do {

		// 		answer = "";

		// 		while (!tryParseInt(answer)) {
		// 			answer = JOptionPane.showInputDialog(null, "How many players are we statting today?");
		// 		}

		// 		teamSize = Integer.parseInt(answer);

		// 		System.out.println(teamSize);

		// 	} while (teamSize <= 0);

		// 	team = new PlayerList();

		// 	String name, nickname, response;

		// 	for (int i = 0; i < teamSize; i++) {

		// 		do {

		// 			name = "";
		// 			nickname = "";

		// 			name = JOptionPane.showInputDialog(null, team.roster() + "Enter another player's name");

		// 			nickname = JOptionPane.showInputDialog(null, team.roster() + "What shall " + name + "'s nickname be?");

		// 		} while(name.equals("") || nickname.equals(""));

		// 		do {

		// 			response = JOptionPane.showInputDialog(null, team.roster() + "Are you sure you want to input " + name + " with nickname: " + nickname + " ?\n1. Yes\n2. No");

		// 		} while((!response.equals("1")) && (!response.equals("2")));

		// 		team.insert(nickname, name);

		// 	}

		// } else {

			// boolean done = false;

			// while(!done) {

			// 	answer = "";
			// 	int l;

			// 	boolean found = false;

			// 	do {
			// 		answer = "";
			// 		while(answer.equals("")) {
			// 			answer = JOptionPane.showInputDialog(null, "Name, (nickname), 3, 2, 1, 0, average\n" + team + team.serveReceive() + "\nInput the Player's Code (Nickname):");
			// 		}

			// 		if(team.lookup(answer) != null) {
			// 			found = true;
			// 		}

			// 	} while(!found && !answer.equals("q"));

			// 	if (answer.equals("q")) {
			// 		JOptionPane.showMessageDialog(null, "Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + team.extendedToString() + team.extendedServeReceive());
			// 		System.out.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + team.extendedToString() + team.extendedServeReceive());
			// 		statSheet.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + team.extendedToString() + team.extendedServeReceive());
			// 		statSheet.close();
			// 		return;
			// 	}

			// 	Player p = team.lookup(answer);
			// 	answer = "";
			// 	int pass;

			// 	do {

			// 		while(!tryParseInt(answer)) {
			// 			answer = JOptionPane.showInputDialog(null, "Name, (nickname), 3, 2, 1, 0, average\n" + team + team.serveReceive() + "\nWhat did " + p.name() + " pass? (3,2,1,0)");
			// 		}

			// 		pass = Integer.parseInt(answer);
					
			// 	} while(pass > 3 && pass < 0);

			// 	p.addPass(pass);

			// 	statSheet = new PrintWriter(new FileWriter(args[0] + ".txt"));

			// 	statSheet.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + team.extendedToString() + team.extendedServeReceive());

			// 	answer = "";

				// do {

				// 	while(!tryParseInt(answer)) {
				// 		answer = JOptionPane.showInputDialog(null, "Would you like to keep taking stats?\n1. Yes\n2. No");
				// 	}
					
				// 	l = Integer.parseInt(answer);

				// } while (l != 1 && l != 2);

				// if (l == 2) {
				// 	done = true;
				// }
			// }
		// }
	}

	public static boolean tryParseInt(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void passStats(PlayerList team, String fileName) throws IOException {

		String answer;
		PlayerList passTeam = team;

		answer = "";

		PrintWriter statSheet = new PrintWriter(new FileWriter(fileName));

		boolean done = false;

		while(!done) {

			answer = "";
			int l;

			boolean found = false;

			do {
				answer = "";
				while(answer.equals("")) {
					answer = JOptionPane.showInputDialog(null, "Name, (nickname), 3, 2, 1, 0, average\n" + passTeam + "Team: " + passTeam.serveReceive() + "\nInput the Player's Code (Nickname):");
				}

				if(team.lookup(answer) != null) {
					found = true;
				}

			} while(!found && !answer.equals("q"));

			if (answer.equals("q")) {
				JOptionPane.showMessageDialog(null, "Here are your passing leaders for the day\nName (nickname), 3, 2, 1, 0, total, attempts, average\n" + passTeam.passingLeaders() + "Team: " + passTeam.extendedServeReceive());
				System.out.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + passTeam.passingLeaders() + "Team: " + passTeam.extendedServeReceive());
				statSheet = new PrintWriter(new FileWriter(fileName));
				statSheet.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + passTeam.extendedToString() + "Team: " + passTeam.extendedServeReceive() + "\n\nAnd here are the passing leaders\n\n" + passTeam.passingLeaders());
				statSheet.close();
				return;
			}

			Player p = passTeam.lookup(answer);
			answer = "";
			int pass;

			do {

				while(!tryParseInt(answer)) {
					answer = JOptionPane.showInputDialog(null, "Name, (nickname), 3, 2, 1, 0, average\n" + passTeam + "Team: " + passTeam.serveReceive() + "\nWhat did " + p.name() + " pass? (3,2,1,0)");
				}

				pass = Integer.parseInt(answer);
				
			} while(pass > 3 && pass < 0);

			team.addPass(p, pass);

			statSheet = new PrintWriter(new FileWriter(fileName));

			statSheet.println("Name (nickname), 3, 2, 1, 0, total, attempts, average\n" + passTeam.extendedToString() + "Team: " + passTeam.extendedServeReceive() + "\n\nAnd here are the passing leaders\n\n" + passTeam.passingLeaders());

			answer = "";
		}

	}

	public static void allStats(PlayerList team, String fileName) throws IOException {

		String answer;
		PlayerList hitTeam = team;
		PlayLog history = new PlayLog();

		answer = "";

		PrintWriter statSheet = new PrintWriter(new FileWriter(fileName));
		PrintWriter shortSheet = new PrintWriter(new FileWriter("short" + fileName));
		PrintWriter logSheet = new PrintWriter(new FileWriter("playHistory" + fileName));
		String lastPlay = "";
		boolean done = false;

		while(!done) {

			answer = "";
			String stat;
			int l;

			boolean found;
			boolean valid = false;

			do {

				answer = JOptionPane.showInputDialog(null, basicStatPage(team) + lastPlay + "\nAre you statting a kill(k), error(e), hitting attempt(ta), dig(d),\nsolo block(bs), block assist(ba), blocking error(be),\nserve(s), pass(p), or ball handling error(bhe)?\nOr do you want to view all stats(STAT)?");

				switch(answer) {
					case "k": case "e": case "ta": case "d": case "bs": case "ba": case "be": case "s": case "p": case "bhe": case "STAT": case "q": valid = true;
						break;
					default: valid = false;
						break;
				}

			} while (!valid);

			if (answer.equals("q")) {
				JOptionPane.showMessageDialog(null, "Name (nickname), kills, serve receive, blocking, serving, digs, assists, ball handling errors, total points, total errors\n" + hitTeam.totalStatLine());
				JOptionPane.showMessageDialog(null, statsPartOne(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartTwo(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartThree(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartFour(hitTeam));
				System.out.println("Here are the abbreviated stats:\n" + hitTeam.totalStatLine());
				statSheet = new PrintWriter(new FileWriter(fileName));
				// shortSheet = new PrintWriter(new FileWriter("short" + fileName));
				logSheet = new PrintWriter(new FileWriter("playHistory" + fileName));
				statSheet.println("Name (nickname), kills, serve receive, blocking, serving, digs, assists, ball handling errors, total points, total errors\n" + hitTeam.totalStatLine() + "Here are your statistical leaders for the day\n\n"  + statLeaders(hitTeam));
				// shortSheet.println("Here are the abbreviated stats:\n" + basicStatPage(team) + "\n" + hitTeam.totalStatLine());
				logSheet.print(history);
				statSheet.close();
				// shortSheet.close();
				logSheet.close();
				return;
			}

			if (answer.equals("STAT")) {
				// JOptionPane.showMessageDialog(null, "Here are your statistical leaders for the day\nPassing:\n"  + hitTeam.passingLeaders() + "\nHitting:\n" + hitTeam.hittingLeaders() + "\nBlocking:\n" + hitTeam.blockingLeaders() + "\nServing:\n" + hitTeam.servingLeaders() + "\nDigs:\n" + hitTeam.diggingLeaders() + "\nAssists:\n" + hitTeam.assistLeaders() + "\nTotal Points:\n" + hitTeam.totalPointLeaders() + "\nTotal Errors:\n" + hitTeam.totalErrorLeaders());
				JOptionPane.showMessageDialog(null, statsPartOne(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartTwo(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartThree(hitTeam));
				JOptionPane.showMessageDialog(null, statsPartFour(hitTeam));
			} else {

				switch (answer) {
					case "k": 	stat = "kill";
								break;
					case "e":	stat = "hitting error";
								break;
					case "ta":	stat = "hitting attempt";
								break;
					case "d":	stat = "dig";
								break;
					case "bs":	stat = "solo block";
								break;
					case "ba":	stat = "block assist";
								break;
					case "be":	stat = "blocking error";
								break;
					case "s":	stat = "serve";
								break;
					case "p":	stat = "pass";
								break;
					case "bhe": stat = "ball handling error";
								break;
					default:	stat = "";
								break;
				}

				do {
					found = false;
					answer = "";
					while(answer.equals("")) {
						answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho recorded the " + stat + "?\nInput the Player's Code (Nickname):");
					}

					if(hitTeam.lookup(answer) != null) {
						found = true;
					}

				} while(!found);

				Player p = hitTeam.lookup(answer);
				Player a = null;
				Player b = null;
				Player c = null;
				int pass = -1;
				Player[] blockSquad = null;

				if (stat.equals("kill")) {
					do {
						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\n" + p.name() + " got a kill" + "\nWho assisted on the kill?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							a = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);
				} else if (stat.equals("dig")) {
					do {
						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho did " + p.name() + " dig?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							a = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);
				} else if (stat.equals("solo block")) {
					do {
						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho did " + p.name() + " block?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							a = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);
				} else if (stat.equals("block assist")) {
					int blockers = 1;
					do {
						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho else assisted " + p.name() + " on the block?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							blockers++;
							b = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);

					if(b != null) {
						do {
							found = false;
							answer = "";
							while(answer.equals("")) {
								answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho else assisted " + p.name() + " and " + b.name() + " on the block?\nInput the Player's Code (Nickname):");
							}

							if(hitTeam.lookup(answer) != null) {
								blockers++;
								c = hitTeam.lookup(answer);
								found = true;
							} else if (answer.equals("0")) {
								found = true;
							}

						} while(!found);
					}

					String blockingTeam;

					switch(blockers) {
						case 3: blockingTeam = p.name() + ", " + b.name() + ", and " + c.name();
								blockSquad = new Player[2];
								blockSquad[0] = b;
								blockSquad[1] = c;
								break;
						case 2: blockingTeam = p.name() + " and " +  b.name();
								blockSquad = new Player[1];
								blockSquad[0] = b;
								break;
						case 1: blockingTeam = p.name();
								break;
						default: blockingTeam = "";
								break;
					}

					do {

						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho did " + blockingTeam + " block?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							a = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);

				} else if (stat.equals("serve")) {

					do {

						do {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWhat kind of pass did " + p.name() + "'s serve get? (3,2,1,0)\n(m = SE)");
							if (answer.equals("m")) {
								found = true;
							} else {
								found = tryParseInt(answer);
							}
						} while (!found);

						if (answer.equals("m")) {
							pass = 4;
						} else {
							pass = Integer.parseInt(answer);
						}
						
					} while(pass > 4 && pass < 0);

					if (pass != 4) {
						do {
							found = false;
							answer = "";
							while(answer.equals("")) {
								answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\n" + p.name() + "'s serve got a " + pass + " pass." + "\nWho passed the ball?\nInput the Player's Code (Nickname):");
							}

							if(hitTeam.lookup(answer) != null) {
								a = hitTeam.lookup(answer);
								found = true;
							} else if (answer.equals("0")) {
								found = true;
							}

						} while(!found);
					}

				} else if (stat.equals("pass")) {

					do {

						while(!tryParseInt(answer)) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWhat kind of pass did " + p.name() + "'s' pass? (3,2,1,0)");
						}

						pass = Integer.parseInt(answer);
						
					} while(pass > 3 && pass < 0);

				} else if (stat.equals("hitting attempt")) {
					do {
						found = false;
						answer = "";
						while(answer.equals("")) {
							answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho dug " + p.name() + "'s swing?\nInput the Player's Code (Nickname):");
						}

						if(hitTeam.lookup(answer) != null) {
							a = hitTeam.lookup(answer);
							found = true;
						} else if (answer.equals("0")) {
							found = true;
						}

					} while(!found);
				}

				switch (stat) {
					case "kill": 	team.addKill(p);
									if (a != null) {
										team.addAssist(a);
									}
									// history.append(p, "kill", -1, null, a);
								break;
					case "hitting error":	team.addHittingError(p);
											// history.append(p, "htting error", -1, null, null);
								break;
					case "hitting attempt":	team.addHittingAttempt(p);
											if (a != null) {
												team.addDig(a);
											}
								break;
					case "dig":	team.addDig(p);
								if (a != null) {
									team.addHittingAttempt(a);	
								}
								break;
					case "solo block":		team.addSoloBlock(p);
											if (a != null) {
												team.addHittingError(a);
											}
								break;
					case "block assist":	team.addBlockAssist(p);
											if (b != null) {
												team.addBlockAssist(b);
											}
											if (c != null) {
												team.addBlockAssist(c);
											}
											if (a != null) {
												team.addHittingError(a);
											}
								break;
					case "blocking error":	team.addBlockingError(p);
											// history.append(p, "blocking error", -1, null, null);
								break;
					case "serve":			team.addServe(p, 4 - pass);
											if (a != null) {
												team.addPass(a, pass);
												// history.append(p, "serve", pass, null, a);
											} else {
												// history.append(p, "serve", pass, null, null);
											}
								break;
					case "pass":			team.addPass(p, pass);
											// history.append(p, "pass", pass, null, null);
								break;
					case "ball handling error": team.addBallHandlingError(p);
								break;
					default:	System.out.println(stat + " VBStat: and no play was registered");
								break;
				}
				history.append(p, stat, pass, blockSquad, a);

				lastPlay = "\n" + history.back() + "\n";
				System.out.println(history.back());

				statSheet = new PrintWriter(new FileWriter(fileName));
				// shortSheet = new PrintWriter(new FileWriter("short" + fileName));
				logSheet = new PrintWriter(new FileWriter("playHistory" + fileName));

				statSheet.println("Name (nickname), kills, serve receive, blocking, serving, digs, assists, ball handling errors, total points, total errors\n" + hitTeam.totalStatLine() + "Here are your statistical leaders for the day\n\n"  + statLeaders(hitTeam));
				shortSheet.println("Here are the abbreviated stats:\n" + basicStatPage(team) + "\n" + hitTeam.totalStatLine());
				logSheet.print(history);
				statSheet.close();
				// shortSheet.close();
				logSheet.close();

				answer = "";
			}
		}

	}

	public static void serveAndPass(PlayerList team, String fileName) throws IOException {

		String answer;
		PlayerList passTeam = team;

		answer = "";
		int ans;

		PrintWriter statSheet = new PrintWriter(new FileWriter(fileName));

		boolean done = false;
		boolean valid;

		while(!done) {

			do {

				// answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nAre you statting a serve(s) or a pass(p) or do you want (STATS)?");
				
				ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nAre you statting a serve(s) or a pass(p) or do you want (STATS)?", "Pick a stat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Quit", "Stats", "Pass", "Serve"}, null);

				switch(ans) {
					case 3: answer = "s";
							break;
					case 2: answer = "p";
							break;
					case 1: answer = "STAT";
							break;
					case 0: answer = "q";
							break;
				}

				switch(answer) {
					case "s": case "p": case "q": case "STAT": valid = true;
						break;
					default: valid = false;
						break;
				}

			} while (!valid);

			if (answer.equals("STAT")) {
				JOptionPane.showMessageDialog(null, passTeam.teamServeAndPassLine() + "\nHere are your statistical leaders for the day\nServing:\n"  + passTeam.servingAverageLeaders() + "\nPassing\n" + passTeam.passingLeaders());
			} else {

				if (answer.equals("q")) {
					JOptionPane.showMessageDialog(null, "Name (nickname), serve receive, serving\n" + passTeam.serveAndPassLine() + "\n" + passTeam.teamServeAndPassLine() + "\nHere are your statistical leaders for the day\nServing:\n"  + passTeam.servingAverageLeaders() + "\nPassing\n" + passTeam.passingLeaders());
					System.out.println("Here are the serving and passing stats:\n" + passTeam.serveAndPassLine() + "\n" + passTeam.teamServeAndPassLine());
					statSheet = new PrintWriter(new FileWriter(fileName));
					statSheet.println("Name (nickname), serve receive, serving\n" + passTeam.serveAndPassLine() + "\n" + passTeam.teamServeAndPassLine() + "\nHere are your statistical leaders for the day\nServing:\n"  + passTeam.servingAverageLeaders() + "\nPassing\n" + passTeam.passingLeaders());
					statSheet.close();
					return;
				}

				String stat;

				switch(answer) {
					case "s": stat = "serve";
								break;
					case "p": stat = "pass";
								break;
					default: stat = "";
								break;
				}

				boolean found = false;
				Player p = null;
				Player a = null;
				int pass;

				String[] roster;
				String[] positions = new String[]{"L/DS", "S", "MB", "OH/OPP"};

				do {
					found = false;
					answer = "";
					// roster = addNextOption(team.teamPartOne());
					// while(answer.equals("")) {
					// 	answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWho recorded the " + stat + "?\nInput the Player's Code (Nickname):");
					// }

					ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWhat position recorded the " + stat + "?", "Choose the position", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, positions, null);

					switch(ans) {
						case 3: roster = addNextOption(team.pinList());
								break;
						case 2:	roster = addNextOption(team.middleList());
								break;
						case 1: roster = addNextOption(team.setterList());
								break;
						case 0: roster = addNextOption(team.liberoList());
								break;
						default: roster = new String[1];
								break;
					}

					do {
						ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWho recorded the " + stat + "?", "Choose the player", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, roster, null);
						if (ans != 0 && passTeam.lookupByName(roster[ans]) != null) {
							found = true;
						}
						System.out.println(roster[ans]);
						System.out.println(found);
					} while(!found && ans != 0);

					// if(ans == 0) {
					// 	do {

					// 		roster = addNextOption(team.teamPartTwo());
					// 		ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWho recorded the " + stat + "?", "Choose the player", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, roster, null);

					// 		if(passTeam.lookup(roster[ans]) != null) {
					// 			found = true;
					// 		}

					// 	} while (!found && ans != 0);
					// } else if(passTeam.lookup(roster[ans]) != null) {

					// 	found = true;

					// }
					
				} while(!found);

				p = passTeam.lookupByName(roster[ans]);

				if (stat.equals("serve")) {
					do {

						do {
							// answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWhat kind of pass did " + p.name() + "'s serve get? (3,2,1,0)\n(m = SE)");
							// if (answer.equals("m")) {
							// 	found = true;
							// } else {
							// 	found = tryParseInt(answer);
							// }

							ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nHow did " + p.name() + "'s the serve turn out?", "Rate the pass", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Miss", "1", "2", "3", "Ace"}, null);

							System.out.println(ans);

							if (!(ans < 0) && !(ans > 4)) {
								found = true;
							}


						} while (!found);

						// if (answer.equals("m")) {
						// 	pass = 4;
						// } else {
						// 	pass = Integer.parseInt(answer);
						// }

						if (ans == 4) {
							pass = 0;
						} else if (ans == 0) {
							pass = 4;
						} else {
							pass = ans;
						}

					} while(pass > 4 || pass < 0);

					if (pass != 4) {
						do {
							found = false;
							answer = "";
							// while(answer.equals("")) {
							// 	answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\n" + p.name() + "'s serve got a " + pass + " pass." + "\nWho passed the ball?\nInput the Player's Code (Nickname):");
							// }

							ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\n" + p.name() + "'s serve got a " + pass + " pass." + "\nWho passed the ball? (What position)", "Name the Position", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, positions, null);

							switch(ans) {
								case 3: roster = addNextAndInvalidOption(team.pinList());
										break;
								case 2:	roster = addNextAndInvalidOption(team.middleList());
										break;
								case 1: roster = addNextAndInvalidOption(team.setterList());
										break;
								case 0: roster = addNextAndInvalidOption(team.liberoList());
										break;
								default: roster = new String[1];
										break;
							}

							do {
								ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWho recorded the " + stat + "?", "Choose the player", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, roster, null);
								if (ans != 0 && ans != 1 && passTeam.lookupByName(roster[ans]) != null) {
									a = passTeam.lookupByName(roster[ans]);
									found = true;
								}
								System.out.println(roster[ans]);
								System.out.println(found);
							} while(!found && ans != 0 && ans != 1);

							if (ans == 0) {
								found = true;
							}

							// if(passTeam.lookup(answer) != null) {
							// 	a = passTeam.lookup(answer);
							// 	found = true;
							// } else if (answer.equals("0")) {
							// 	found = true;
							// }

						} while(!found);
					}
				} else {

					do {
						// answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWhat kind of pass did " + p.name() + "'s serve get? (3,2,1,0)\n(m = SE)");
						// if (answer.equals("m")) {
						// 	found = true;
						// } else {
						// 	found = tryParseInt(answer);
						// }

						ans = JOptionPane.showOptionDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nHow did " + p.name() + "'s pass turn out?", "Rate the pass", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"0", "1", "2", "3"}, null);

						System.out.println(ans);

						if (!(ans < 0) && !(ans > 3)) {
							found = true;
						}


					} while (!found);

					pass = ans;

					// do {

					// 	while(!tryParseInt(answer)) {
					// 		answer = JOptionPane.showInputDialog(null, team.serveAndPassLine() + "\n" + team.teamServeAndPassLine() + "\nWhat kind of pass was " + p.name() + "'s pass? (3,2,1,0)");
					// 	}

					// 	pass = Integer.parseInt(answer);
						
					// } while(pass > 3 && pass < 0);
				}

				switch(stat) {
					case "serve": team.addServe(p, 4-pass);
									if (a != null) {
										team.addPass(a, pass);
									}
									break;
					case "pass": team.addPass(p, pass);
									break;
					default:
									break;
				}

				statSheet = new PrintWriter(new FileWriter(fileName));

				statSheet.println("Name (nickname), serve receive, serving\n" + passTeam.serveAndPassLine() + "\n" + passTeam.teamServeAndPassLine() + "\nHere are your statistical leaders for the day\nServing:\n"  + passTeam.servingAverageLeaders() + "\nPassing\n" + passTeam.passingLeaders());

				answer = "";

			}

		}

	}

	private static String basicStatPage(PlayerList team) {

		return new String("Name, (nickname)\nS: A || D || BS/BA/BE/BT \nOH: K/E/TA/K% || 3/2/1/0/Avg\nMB: K/E/TA/K% || BS/BA/BT\nL: 3/2/1/0/Avg || D\n" + team.statLine() + "\n" + team.teamStatLine());

	}

	private static String statLeaders(PlayerList team) {
		StringBuffer sb = new StringBuffer();
		sb.append("Passing:\n"  + team.passingLeaders());
		sb.append("\nHitting:\n" + team.hittingLeaders());
		sb.append("\nBlocking:\n" + team.blockingLeaders());
		sb.append("\nServing Average:\n" + team.servingAverageLeaders());
		sb.append("\nServing Total:\n" + team.servingTotalLeaders());
		sb.append("\nDigging:\n" + team.diggingLeaders());
		sb.append("\nAssists:\n" + team.assistLeaders());
		sb.append("\nBall Handling Errors:\n" + team.ballHandlingErrorLeaders());
		sb.append("\nTotal Points:\n" + team.totalPointLeaders());
		sb.append("\nTotal Errors:\n" + team.totalErrorLeaders());
		return new String(sb);
	}

	private static String statsPartOne(PlayerList team) {
		StringBuffer sb = new StringBuffer();
		sb.append("Passing:\n"  + team.passingLeaders());
		sb.append("\nHitting:\n" + team.hittingLeaders());
		sb.append("\nBlocking:\n" + team.blockingLeaders());
		return new String(sb);
	}

	private static String statsPartTwo(PlayerList team) {
		StringBuffer sb = new StringBuffer();
		sb.append("\nServing Average:\n" + team.servingAverageLeaders());
		sb.append("\nServing Total:\n" + team.servingTotalLeaders());
		return new String(sb);
	}

	private static String statsPartThree(PlayerList team) {
		StringBuffer sb = new StringBuffer();
		sb.append("\nDigging:\n" + team.diggingLeaders());
		sb.append("\nAssists:\n" + team.assistLeaders());
		sb.append("\nBall Handling Errors:\n" + team.ballHandlingErrorLeaders());
		return new String(sb);
	}

	private static String statsPartFour(PlayerList team) {
		StringBuffer sb = new StringBuffer();
		sb.append("\nTotal Points:\n" + team.totalPointLeaders());
		sb.append("\nTotal Errors:\n" + team.totalErrorLeaders());
		return new String(sb);
	}

	private static String[] addNextOption(String[] list) {
		String[] newList = new String[list.length + 1];
		newList[0] = "Other";
		for (int i = 1; i < list.length + 1; i++) {
			newList[i] = list[i - 1];
		}
		return newList;
	}

	private static String[] addInvalidOption(String[] list) {
		String[] newList = new String[list.length + 1];
		newList[0] = "N/A";
		for (int i = 1; i < list.length + 1; i++) {
			newList[i] = list[i - 1];
		}
		return newList;
	}

	private static String[] addNextAndInvalidOption(String[] list) {
		return addInvalidOption(addNextOption(list));
	}

	// private static Player findPlayer(PlayerList team) {

	// 	Player p = null;
	// 	boolean found;
	// 	String answer;

	// 	do {

	// 		found = false;
	// 		answer = "";
	// 		while(answer.equals("")) {
	// 			answer = JOptionPane.showInputDialog(null, team.roster() + "\nChoose a Player\nInput the Player's Code (Nickname):");
	// 		}

	// 		if(team.lookup(answer) != null) {
	// 			p = team.lookup(answer);
	// 			found = true;
	// 		} else if (answer.equals("0")) {
	// 			found = true;
	// 		}

	// 	} while(!found);

	// 	return p;

	// }

	private static Player getPlayer(PlayerList team, String stat) {

		Player p = null;

		switch (stat) {
			case "k": 	stat = "kill";
						break;
			case "e":	stat = "hitting error";
						break;
			case "ta":	stat = "hitting attempt";
						break;
			case "d":	stat = "dig";
						break;
			case "bs":	stat = "solo block";
						break;
			case "ba":	stat = "block assist";
						break;
			case "be":	stat = "blocking error";
						break;
			case "s":	stat = "serve";
						break;
			case "p":	stat = "pass";
						break;
			default:	stat = "";
						break;
		}

		boolean found;
		String answer;

		do {

			found = false;
			answer = "";
			while(answer.equals("")) {
				answer = JOptionPane.showInputDialog(null, basicStatPage(team) + "\nWho recorded the " + stat + "?\nInput the Player's Code (Nickname):");
			}

			if(team.lookup(answer) != null) {
				p = team.lookup(answer);
				found = true;
			} else if (answer.equals("0")) {
				found = true;
			}

		} while(!found);

		return p;

	}

	private static int getPassQuality(PlayerList team, Player p) {

		int ans;
		boolean found = false;

		do {

			ans = JOptionPane.showOptionDialog(null, team + "\n" + team.serveReceive() + "\nHow did " + p.name() + "'s pass turn out?", "Rate the pass", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"0", "1", "2", "3"}, null);

			if (!(ans < 0) && !(ans > 3)) {
				found = true;
			}

		} while (!found);

		return ans;

	}

	private static boolean addPass(PlayerList team) {

		Player p = getPlayer(team, "p");
		int pass;

		if (p != null) {
			pass = getPassQuality(team, p);
			team.addPass(p, pass);
			return false;
		}
		return true;

	}

	private static void passStatsTest(PlayerList team) {
		boolean done = false;
		while(!done) {
			done = addPass(team);
		}
		System.out.println("The program has finished");
	}



}