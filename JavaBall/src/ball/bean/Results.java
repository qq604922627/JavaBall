package ball.bean;

public class Results {
	//�������
	private String Teamname;//�������
	//private int Rank;//����
	private int MatchesWon;//ʤ��
	private int MatchesDrawn;//ƽ��
	private int MatchesLost;//����	
	private int GoalsFor;//������
	private int GoalsAgainst;//������
	private int MatchPoints;//����
	private int GoalDiff;//���
	//private String Medal;//����
	public String getTeamname() {
		return Teamname;
	}
	public void setTeamname(String teamname) {
		Teamname = teamname;
	}
	/*public int getRank() {
		return Rank;
	}
	
	public void setRank(int rank) {
		Rank = rank;
	}
	*/
	public int getMatchesWon() {
		return MatchesWon;
	}
	public void setMatchesWon(int matchesWon) {
		MatchesWon = matchesWon;
	}
	public int getMatchesDrawn() {
		return MatchesDrawn;
	}
	public void setMatchesDrawn(int matchesDrawn) {
		MatchesDrawn = matchesDrawn;
	}
	public int getMatchesLost() {
		return MatchesLost;
	}
	public void setMatchesLost(int matchesLost) {
		MatchesLost = matchesLost;
	}
	public int getGoalsFor() {
		return GoalsFor;
	}
	public void setGoalsFor(int goalsFor) {
		GoalsFor = goalsFor;
	}
	public int getGoalsAgainst() {
		return GoalsAgainst;
	}
	public void setGoalsAgainst(int goalsAgainst) {
		GoalsAgainst = goalsAgainst;
	}
	public int getMatchPoints() {
		return MatchPoints;
	}
	public void setMatchPoints(int matchPoints) {
		MatchPoints = matchPoints;
	}
	public int getGoalDiff() {
		return GoalDiff;
	}
	public void setGoalDiff(int goalDiff) {
		GoalDiff = goalDiff;
	}
	/*
	public String getMedal() {
		return Medal;
	}
	public void setMedal(String medal) {
		Medal = medal;
	}
	*/
	@Override
	public String toString() {
		return "Results [Teamname=" + Teamname +  ", MatchesWon=" + MatchesWon + ", MatchesDrawn="
				+ MatchesDrawn + ", MatchesLost=" + MatchesLost + ", GoalsFor=" + GoalsFor + ", GoalsAgainst="
				+ GoalsAgainst + ", MatchPoints=" + MatchPoints + ", GoalDiff=" + GoalDiff +  "]";
	}
}
