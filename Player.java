import java.text.DecimalFormat;

public class Player {

	private String name;
	private int[] serveReceive;
	private int totalPassingPoints;
	private int totalPassingAttempts;
	private int ballHandlingErrors;
	private int kills;
	private int hittingErrors;
	private int hittingAttempts;
	private int soloBlocks;
	private int blockAssists;
	private int blockingErrors;
	private int assists;
	private int digs;
	private double hittingPercentage;
	private double passingAverage;
	private double blockPoints;
	private int[] serving;
	private int servingPoints;
	private int servingAttempts;
	private double servingAverage;
	private double totalPoints;
	private int totalErrors;
	private String position;

	public Player(String name, String position) {
		this.name = name;
		serveReceive = new int[4];
		for (int i = 0; i < 4; i++) {
			serveReceive[i] = 0;
		}
		totalPassingPoints = 0;
		totalPassingAttempts = 0;
		passingAverage = 0;
		assists = 0;
		kills = 0;
		hittingErrors = 0;
		hittingAttempts = 0;
		soloBlocks = 0;
		blockAssists = 0;
		blockPoints = 0;
		blockingErrors = 0;
		serving = new int[5];
		for (int i = 0; i < 5; i++) {
			serving[i] = 0;
		}
		servingPoints = 0;
		servingAttempts = 0;
		servingAverage = 0;
		totalPoints = 0;
		totalErrors = 0;
		this.position = position;
	}

	public boolean equals(Player p) {
		if (name().equals(p.name())) {
			return true;
		} else {
			return false;
		}
	}

	public String name() {
		return name;
	}

	public String position() {
		return position;
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

	public int assists() {
		return assists;
	}

	public int digs() {
		return digs;
	}

	public int threePasses() {
		return serveReceive[0];
	}

	public int twoPasses() {
		return serveReceive[1];
	}

	public int onePasses() {
		return serveReceive[2];
	}

	public int zeroPasses() {
		return serveReceive[3];
	}

	public int ballHandlingErrors() {
		return ballHandlingErrors;
	}

	public int passingPoints() {
		return totalPassingPoints;
	}

	public int totalAttempts() {
		return totalPassingAttempts;
	}

	public double passingAverage() {
		return passingAverage;
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

	public double totalPoints() {
		return totalPoints;
	}

	public int totalErrors() {
		return totalErrors;
	}

	public String passingTotals() {
		return new String(totalPassingPoints + " " + totalPassingAttempts + " " + twoDecimalConvert(passingAverage));
	}

	public String servingTotals() {
		return new String(servingPoints + " " + servingAttempts + " " + twoDecimalConvert(servingAverage));
	}

	public void addPass(int x) {
		serveReceive[3 - x] += 1;
		totalPassingPoints += x;
		totalPassingAttempts += 1;
		passingAverage = Math.round((double)totalPassingPoints/(double)totalPassingAttempts * 100.0) / 100.0;

	}

	public void addServe(int x) {
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
	}

	public void addAssist() {
		assists += 1;
	}

	public void addDig() {
		digs += 1;
	}

	public void addKill() {
		kills += 1;
		hittingAttempts += 1;
		totalPoints += 1;
		updateHittingPercentage();
	}

	public void addHittingError() {
		hittingErrors += 1;
		hittingAttempts += 1;
		totalErrors += 1;
		updateHittingPercentage();
	}

	public void addHittingAttempt() {
		hittingAttempts += 1;
		updateHittingPercentage();
	}

	public void addSoloBlock() {
		soloBlocks += 1;
		blockPoints += 1;
		totalPoints += 1;
	}

	public void addBlockAssist() {
		blockAssists += 1;
		blockPoints += 0.5;
		totalPoints += 0.5;
	}

	public void addBlockingError() {
		blockingErrors += 1;
		totalErrors += 1;
	}

	public void addBallHandlingError() {
		ballHandlingErrors += 1;
		totalErrors += 1;
	}

	private void updateHittingPercentage() {
		hittingPercentage = Math.round((double)(kills - hittingErrors)/(double)hittingAttempts*1000.0)/1000.0;
	}

	public String hittingLine() {
		return new String(kills + " " + hittingErrors + " " + hittingAttempts + " " + threeDecimalConvert(hittingPercentage));
	}

	public String blockLine() {
		return new String(soloBlocks + " " + blockAssists + " " + blockingErrors + " " + blockPoints);
	}

	public String servingLine() {
		return new String(serviceAces() + " " + onePassServes() + " " + twoPassServes() + " " + threePassServes() + " " + serviceErrors() + " | " + twoDecimalConvert(servingAverage()));
	}

	public String extendedServingLine() {
		return new String(serviceAces() + " " + onePassServes() + " " + twoPassServes() + " " + threePassServes() + " " + serviceErrors() + " | " + servingTotals());
	}

	public String serveReceive() {

		StringBuffer sb = new StringBuffer();
		sb.append(threePasses() + " " + twoPasses() + " " + onePasses() + " " + zeroPasses() + " | " + twoDecimalConvert(passingAverage) + " ");
		return new String(sb);
	}

	public String extendedServeReceive() {

		StringBuffer sb = new StringBuffer();
		sb.append(threePasses() + " " + twoPasses() + " " + onePasses() + " " + zeroPasses() + " | " + passingTotals());
		return new String(sb);

	}

	public String statLine() {
		StringBuffer sb = new StringBuffer();
		switch(position) {
			case "OH": sb.append(hittingLine() + " || " + serveReceive());
						break;
			case "S": sb.append(assists + " || " + digs + " || " + blockLine());
						break;
			case "MB": sb.append(hittingLine() + " || " + blockLine());
						break;
			case "L": sb.append(serveReceive() + " || " + digs);
						break;
			case "OPP": sb.append(hittingLine() + " || " + blockLine());
						break;
			default:
						break;
		}
		return new String(sb);
	}

	public String totalStatLine() {
		StringBuffer sb = new StringBuffer();
		sb.append(hittingLine() + " || " + serveReceive() + " || " + blockLine() + " || " + servingLine() + " || " + digs + " || " + assists + " || " + ballHandlingErrors + " || " + totalPoints + " || " + totalErrors);
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