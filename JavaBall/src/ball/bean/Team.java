package ball.bean;

public class Team {
	//球队信息
	public String Teamnameone;//队伍1
	public int  scoreone;//队伍1得分
	public String Teamnametwo;//队伍2
	public int scoretwo;//队伍2得分
	public String getTeamnameone() {
		return Teamnameone;
	}
	public void setTeamnameone(String teamnameone) {
		Teamnameone = teamnameone;
	}
	public int getScoreone() {
		return scoreone;
	}
	public void setScoreone(int scoreone) {
		this.scoreone = scoreone;
	}
	public String getTeamnametwo() {
		return Teamnametwo;
	}
	public void setTeamnametwo(String teamnametwo) {
		Teamnametwo = teamnametwo;
	}
	public int getScoretwo() {
		return scoretwo;
	}
	public void setScoretwo(int scoretwo) {
		this.scoretwo = scoretwo;
	}
	
}
