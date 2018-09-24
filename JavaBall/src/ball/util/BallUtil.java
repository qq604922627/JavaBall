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
	public static LinkedList<String> arr = new LinkedList<String>();// �����������
	public static Map<String, Results> remap = new HashMap<String, Results>();// ��������Ϣ
	public static Map<Integer, Team> teammap = new HashMap<Integer, Team>();// ���������¼
	public static int size;
	public static int state;//ResultsIn.txt ��ȡ�ɹ�=2
	public void teamname() {
		// ��������
		File file = new File("G:\\a\\TeamIn.txt");
		InputStreamReader inputReader;
		try {
			inputReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader bf = new BufferedReader(inputReader);
			String str;
			while ((str = bf.readLine()) != null) {
				arr.add(str);// ��Ӷ������Ƶ�arr������
			}
			Collections.sort(arr);// ���ն�����ĸ˳������
			bf.close();
			inputReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void chengji() {
		// ����ɼ�
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
					System.out.println("���ȶ�ȡ�����ļ���");
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
		// ������¼
		if (arr.size() == 0) {
			System.out.println("���ȶ�ȡ�����ļ�");
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
		// ��ʼ����������Ϣ
		for (String string : list) {
			Results rs = new Results();
			rs.setTeamname(string);
			rs.setGoalDiff(0);// ���
			rs.setGoalsAgainst(0);// ������
			rs.setGoalsFor(0);// ������
			rs.setMatchesDrawn(0);// ƽ��
			rs.setMatchesWon(0);// ʤ��
			rs.setMatchesLost(0);// ����
			rs.setMatchPoints(0);// ����
			remap.put(string, rs);
		}

	}

	public void jieguo(Map<Integer, Team> teammap) {
		// �������
		int a, b;
		for (String key : remap.keySet()) {
			for (int i = 0; i < teammap.size() + 1; i++) {
				if (teammap.get(i) != null) {
					if (remap.get(key).getTeamname().equals(teammap.get(i).Teamnameone)) {
						a = teammap.get(i).scoreone;// a������
						b = teammap.get(i).scoretwo;// b������
						remap.get(key).setGoalDiff(remap.get(key).getGoalDiff() + a - b);// ���
						remap.get(key).setGoalsAgainst(remap.get(key).getGoalsAgainst() + b);// ������
						remap.get(key).setGoalsFor(remap.get(key).getGoalsFor() + a);// ������
						if (a == b) {
							remap.get(key).setMatchesDrawn(remap.get(key).getMatchesDrawn() + 1);// ƽ��
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 1);// ����
						}
						if (a > b) {
							remap.get(key).setMatchesWon(remap.get(key).getMatchesWon() + 1);// ʤ��
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 3);// ����
						}
						if (a < b) {
							remap.get(key).setMatchesLost(remap.get(key).getMatchesLost() + 1);// ����
						}

					}
					if (remap.get(key).getTeamname().equals(teammap.get(i).Teamnametwo)) {
						a = teammap.get(i).scoreone;// a������
						b = teammap.get(i).scoretwo;// b������
						remap.get(key).setGoalDiff(remap.get(key).getGoalDiff() + b - a);// ���
						remap.get(key).setGoalsAgainst(remap.get(key).getGoalsAgainst() + b);// ������
						remap.get(key).setGoalsFor(remap.get(key).getGoalsFor() + b);// ������
						if (a == b) {
							remap.get(key).setMatchesDrawn(remap.get(key).getMatchesDrawn() + 1);// ƽ��
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 1);// ����
						}
						if (b > a) {
							remap.get(key).setMatchesWon(remap.get(key).getMatchesWon() + 1);// ʤ��
							remap.get(key).setMatchPoints(remap.get(key).getMatchPoints() + 3);// ����
						}
						if (b < a) {
							remap.get(key).setMatchesLost(remap.get(key).getMatchesLost() + 1);// ����
						}
					}

				}
			}
		}

	}

	public String tuisai(String teamname) {
		ArrayList<Integer> s = new ArrayList<Integer>();
		// ɾ��������Ϣ�����У��ö������Ϣ
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(teamname)) {
				
				arr.remove(arr.get(i));
				
				// ɾ����������У��ö������Ϣ
				for (int j = 0; j < remap.size(); j++) {
					remap.remove(teamname);
					
				}
				// ɾ��������¼�У��ö������Ϣ
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
				file.createNewFile();// �ļ��������򴴽�
			} else {
				file.delete();// ������ɾ��
				file.createNewFile();// Ȼ�󴴽�
			}
			FileWriter filew = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(filew);// ����������
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
			out.close();// �ر�������
			return "True";//�ɹ�
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
