package ball.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ball.bean.Results;
import ball.bean.Team;

public class BallUtil {
	public static LinkedList<String> arr = new LinkedList<String>();// 储存队伍名称
	public static Map<String, Results> remap = new HashMap<String, Results>();// 储存结果信息
	public static Map<Integer, Team> teammap = new HashMap<Integer, Team>();// 储存比赛记录
	public static int size;
	public static int state;//ResultsIn.txt 读取成功=2
	public void teamname() {
		// 队伍名称
		File file = new File("G:\\a\\TeamIn.txt");
		InputStreamReader inputReader;
		try {
			inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			String str;
			while ((str = bf.readLine()) != null) {
				arr.add(str);// 添加队伍名称到arr数组中
			}
			Collections.sort(arr);// 按照队伍字母顺序排序
			bf.close();
			inputReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void chengji() {
		// 队伍成绩
		File file = new File("G:\\a\\ResultsIn.txt");
		InputStreamReader inputReader;
		try {
			inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			String str;
			while ((str = bf.readLine()) != null) {
				String a[] = str.split(" ");
				if (teammap.size() != 0) {

					for (int i = 0; i < teammap.size(); i++) {
						if (teammap.get(i) != null) {
							if (teammap.get(i).Teamnameone.equals(a[0]) && teammap.get(i).Teamnametwo.equals(a[2])) {
								teammap.get(i).setScoreone(Integer.valueOf(a[1]));
								teammap.get(i).setScoretwo(Integer.valueOf(a[3]));
							}
							if (teammap.get(i).Teamnameone.equals(a[2]) && teammap.get(i).Teamnametwo.equals(a[0])) {
								teammap.get(i).setScoreone(Integer.valueOf(a[3]));
								teammap.get(i).setScoretwo(Integer.valueOf(a[1]));
							}
						}
					}
				
				} else {
					System.out.println("请先读取队伍文件！");
				}
			}

			bf.close();
			inputReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bisaijilu(LinkedList<String> arr) {
		// 比赛记录
		if (arr.size() == 0) {
			System.out.println("请先读取队伍文件");
		} else {

			int g = 0;
			for (int i = 0; i < arr.size(); i++) {
				for (int j = i + 1; j < arr.size(); j++) {
					g++;
					Team team = new Team();
					team.setTeamnameone(arr.get(i));
					team.setScoreone(0);
					team.setTeamnametwo(arr.get(j));
					team.setScoretwo(0);
					teammap.put(g, team);
				}
			}
			size = teammap.size();
		}
	}

	public void addjieguo(LinkedList<String> list) {
		// 初始化队伍结果信息
		for (String string : list) {
			Results rs = new Results();
			rs.setTeamname(string);
			rs.setGoalDiff(0);// 球差
			rs.setGoalsAgainst(0);// 丢球数
			rs.setGoalsFor(0);// 进球数
			rs.setMatchesDrawn(0);// 平场
			rs.setMatchesWon(0);// 胜场
			rs.setMatchesLost(0);// 负场
			rs.setMatchPoints(0);// 积分
			remap.put(string, rs);
		}

	}

	public void jieguo(Map<Integer, Team> teammap) {
		// 比赛结果
		int a, b;
		for (String key : remap.keySet()) {
			for (int i = 0; i < teammap.size() + 1; i++) {
				if (teammap.get(i) != null) {
					if (remap.get(key).getTeamname().equals(teammap.get(i).Teamnameone)) {
						a = teammap.get(i).scoreone;// a进球数
						b = teammap.get(i).scoretwo;// b进球数
						remap.get(key).setGoalDiff(remap.get(key).getGoalDiff() + a - b);// 球差
						remap.get(key).setGoalsAgainst(remap.get(key).getGoalsAgainst() + b);// 丢球数
						remap.get(key).setGoalsFor(remap.get(key).getGoalsFor() + a);// 进球数
						if (a == b) {
							remap.get(key).setMatchesDrawn(remap.get(key).getMatchesDrawn() + 1);// 平场
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 1);// 积分
						}
						if (a > b) {
							remap.get(key).setMatchesWon(remap.get(key).getMatchesWon() + 1);// 胜场
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 3);// 积分
						}
						if (a < b) {
							remap.get(key).setMatchesLost(remap.get(key).getMatchesLost() + 1);// 负场
						}

					}
					if (remap.get(key).getTeamname().equals(teammap.get(i).Teamnametwo)) {
						a = teammap.get(i).scoreone;// a进球数
						b = teammap.get(i).scoretwo;// b进球数
						remap.get(key).setGoalDiff(remap.get(key).getGoalDiff() + b - a);// 球差
						remap.get(key).setGoalsAgainst(remap.get(key).getGoalsAgainst() + b);// 丢球数
						remap.get(key).setGoalsFor(remap.get(key).getGoalsFor() + b);// 进球数
						if (a == b) {
							remap.get(key).setMatchesDrawn(remap.get(key).getMatchesDrawn() + 1);// 平场
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 1);// 积分
						}
						if (b > a) {
							remap.get(key).setMatchesWon(remap.get(key).getMatchesWon() + 1);// 胜场
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 3);// 积分
						}
						if (b < a) {
							remap.get(key).setMatchesLost(remap.get(key).getMatchesLost() + 1);// 负场
						}
					}

				}
			}
		}

	}

	public String tuisai(String teamname) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		// 删除队伍信息数组中，该队伍的信息
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(teamname)) {
				
				arr.remove(arr.get(i));
				
				// 删除比赛结果中，该队伍的信息
				for (int j = 0; j < remap.size(); j++) {
					remap.remove(teamname);
					
				}
				// 删除比赛记录中，该队伍的信息
				for (int k = 0; k < size + 1; k++) {
					if (teammap.get(k) != null) {
						if (teammap.get(k).Teamnameone.equals(teamname) || teammap.get(k).Teamnametwo.equals(teamname)) {
							// teammap.remove(i);
							s.add(k);
						}
					}
				}
				if (s.size() > 0) {
					for (int h = 0; h < s.size(); h++) {
						teammap.remove(s.get(h));
					}
				}
				return "True";
			}
		}
		
		
		if (arr.size() < 3) {
			arr.clear();
			remap.clear();
			teammap.clear();
			return "Stop";
		}
		return "False";
	}

	public String savaResults(Map<String, Results> remap) {
		try {
			File file = new File("G:\\a\\ResultsOut.txt");
			if (!file.exists()) {
				file.createNewFile();// 文件不存在则创建
			} else {
				file.delete();// 存在则删除
				file.createNewFile();// 然后创建
			}
			FileWriter filew = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(filew);// 创建输入流
			out.write(
					"Teamname MatchesWon MatchesDrawn MatchesLost GoalsFor GoalsAgainst MatchPoints GoalDiff Rank Medal");
			out.newLine();
			int i = 0;
			List<Map.Entry<String, Results>> list = new ArrayList<Map.Entry<String, Results>>();
			list.addAll(remap.entrySet());
			RankUtil vc = new RankUtil();
			Collections.sort(list, vc);
			if (BallUtil.arr.get(i) != null) {
			for (Iterator<Entry<String, Results>> it = list.iterator(); it.hasNext();) {
				
					Results results = it.next().getValue();
					out.write(results.getTeamname()+" ");
					out.write(String.valueOf(results.getMatchesWon())+" ");
					out.write(String.valueOf(results.getMatchesDrawn())+" ");
					out.write(String.valueOf(results.getMatchesLost())+" ");
					out.write(String.valueOf(results.getGoalsFor())+" ");
					out.write(String.valueOf(results.getGoalsAgainst())+" ");
					out.write(String.valueOf(results.getMatchPoints())+" ");
					out.write(String.valueOf(results.getGoalDiff())+" ");
					out.write(String.valueOf(i + 1)+" ");
					if (i == 0) {
						out.write("Gold"+" ");
					} else if (i == 1) {
						out.write("Silver"+" ");
					} else if (i == 2) {
						out.write("Bronze"+" ");
					} else {
						out.write("Strive"+" ");
					}
					out.newLine();
					i++;
					
				}
			out.close();// 关闭输入流
			return "True";//成功
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "False";

	}

	public String addScore(String teamonename, int teamonescore, String teamtwoname, int teamtwoscore) {	
		for (int i = 0; i < teammap.size() + 1; i++) {
			if (teammap.get(i) != null) {
				if (teamonename.equals(teammap.get(i).Teamnameone) && teamtwoname.equals(teammap.get(i).Teamnametwo)) {
					if (teammap.get(i).scoreone == 0 && teammap.get(i).scoretwo == 0) {
						teammap.get(i).setScoreone(teamonescore);
						teammap.get(i).setScoretwo(teamtwoscore);
						System.out.println(teamonescore + "." + teamtwoscore);
						return "True";
					}else {
						return "Exist";
					}
				

				} else if (teamtwoname.equals(teammap.get(i).Teamnameone)
						&& teamonename.equals(teammap.get(i).Teamnametwo)) {
					if (teammap.get(i).scoreone == 0 && teammap.get(i).scoretwo == 0) {
						teammap.get(i).setScoreone(teamtwoscore);
						teammap.get(i).setScoretwo(teamonescore);
						return "True";
					}else {
						return "Exist";
					}
				}
			}
		}
		return "False";
	}

	public static void main(String[] args) {
		BallUtil ttt = new BallUtil();
		ttt.teamname();
		ttt.bisaijilu(arr);
		ttt.addjieguo(arr);
		ttt.chengji();
		ttt.jieguo(teammap);
		ttt.savaResults(remap);

	}
}
