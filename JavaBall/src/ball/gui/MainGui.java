package ball.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import ball.bean.Results;
import ball.bean.Team;
import ball.util.BallUtil;
import ball.util.RankUtil;

public class MainGui {
	BallUtil t = new BallUtil();
	JFrame jfmain;
	JMenuBar jmb;
	JMenu fileMenu;
	JMenuItem openfile, exitfile, aafile, bbfile, addfile;
	JPanel jgpanel = new JPanel();
	JPanel rcpanel = new JPanel();
	JButton b1;
	Label la1 = new Label();
	public JTextArea jt = new JTextArea();

	private void JavaBallGui() {
		jfmain = new JFrame("JavaBall");
		Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
		Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
		int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
		int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
		jfmain.setSize(screenWidth / 2, screenHeight / 2);// ���ڴ�С
		int windowWidth = jfmain.getWidth();// ��ô��ڿ�
		int windowHeight = jfmain.getHeight();// ��ô��ڸ�
		jfmain.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���
		// jfmain.setLayout(null);
		jmb = new JMenuBar();
		jmb.setSize(jfmain.getWidth(), jfmain.getHeight() / 15);// ��ʾ��С
		jmb.setLocation(0, 0);// ��ʾλ��
		fileMenu = new JMenu("File");
		bbfile = new JMenuItem("Team In");
		aafile = new JMenuItem("Results In");
		exitfile = new JMenuItem("Exit the game");
		addfile = new JMenuItem("Add game information");
		openfile = new JMenuItem("Result of generation");
		fileMenu.add(bbfile);
		fileMenu.add(aafile);
		fileMenu.add(exitfile);
		fileMenu.add(addfile);
		fileMenu.add(openfile);
		addfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFrame jfr = new JFrame("Add game information");
				jfr.setVisible(true);// ��ʾ�������
				jfr.setResizable(false);// ���ڴ�С���ɸı�
				jfr.setSize(410, 300);// ���ô��ڴ�С
				Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
				Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
				int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
				int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
				int windowWidth = jfr.getWidth();// ��ô��ڿ�
				int windowHeight = jfr.getHeight();// ��ô��ڸ�
				jfr.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���
				jfr.setLayout(null);// ȡ�����֣������Զ��岼��
				JLabel la = new JLabel();
				la.setText("Team One Name");// ��ʾ����
				la.setSize(100, 30);// ��ʾ��С
				la.setLocation(10, 10);// ��ʾλ��
				jfr.add(la);
				final JTextField jtf = new JTextField();
				jtf.setSize(180, 40);// ��ʾ��С
				jtf.setLocation(10, 40);// ��ʾλ��
				jfr.add(jtf);

				JLabel la1 = new JLabel();
				la1.setText("Team Two Name");// ��ʾ����
				la1.setSize(100, 30);// ��ʾ��С
				la1.setLocation(200, 10);// ��ʾλ��
				jfr.add(la1);
				final JTextField jtf1 = new JTextField();
				jtf1.setSize(180, 40);// ��ʾ��С
				jtf1.setLocation(200, 40);// ��ʾλ��
				jfr.add(jtf1);

				JLabel la2 = new JLabel();
				la2.setText("Team One Score");// ��ʾ����
				la2.setSize(100, 30);// ��ʾ��С
				la2.setLocation(10, 90);// ��ʾλ��
				jfr.add(la2);
				final JTextField jtf2 = new JTextField();
				jtf2.setSize(180, 40);// ��ʾ��С
				jtf2.setLocation(10, 120);// ��ʾλ��
				jfr.add(jtf2);
				JLabel la3 = new JLabel();
				la3.setText("Team Two Score");// ��ʾ����
				la3.setSize(100, 30);// ��ʾ��С
				la3.setLocation(200, 90);// ��ʾλ��
				jfr.add(la3);
				final JTextField jtf3 = new JTextField();
				jtf3.setSize(180, 40);// ��ʾ��С
				jtf3.setLocation(200, 120);// ��ʾλ��
				jfr.add(jtf3);
				JButton exitbu = new JButton("Yes");
				exitbu.setSize(200, 40);// ��ʾ��С
				exitbu.setLocation(105, 180);// ��ʾλ��
				jfr.add(exitbu);
				exitbu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFrame tishi = new JFrame("Feedback information");
						tishi.setVisible(true);// ��ʾ���
						tishi.setResizable(false);// ��С���ɱ�
						tishi.setSize(200, 100);// ��ʾ��С
						JLabel tishilabel = new JLabel();
						tishilabel.setHorizontalAlignment(JLabel.CENTER);

						Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
						Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
						int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
						int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
						int windowWidth = tishi.getWidth();// ��ô��ڿ�
						int windowHeight = tishi.getHeight();// ��ô��ڸ�
						tishi.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���

						if (BallUtil.teammap.size() == 0) {
							tishilabel.setText("Fail!No information!");
							tishi.add(tishilabel);
						} else {
							if (jtf.getText().trim().length() == 0 || jtf2.getText().trim().length() == 0
									|| jtf1.getText().trim().length() == 0 || jtf3.getText().trim().length() == 0) {
								tishilabel.setText("Fail!Error in input information!");
								tishi.add(tishilabel);
							} else {
								String teamonename = jtf.getText();
								String teamonescore = jtf2.getText();
								String teamtwoname = jtf1.getText();
								String teamtwoscore = jtf3.getText();
								if ((0 < Integer.valueOf(teamonescore) && Integer.valueOf(teamonescore) < 9)
										&& (0 < Integer.valueOf(teamtwoscore) && Integer.valueOf(teamtwoscore) < 9)) {
									String aa = t.addScore(teamonename, Integer.valueOf(teamonescore), teamtwoname,
											Integer.valueOf(teamtwoscore));

									if ("True".equals(aa)) {
										tishilabel.setText("Score ! Add Success !");
										tishi.add(tishilabel);
									} else if("Exist".equals(aa)){
										tishilabel.setText("Error ! Score ! Already exist !");
										tishi.add(tishilabel);
									}else{
										tishilabel.setText("Error ! Teamname can't find !");
									}
									tishi.add(tishilabel);
								} else {
									tishilabel.setText("Fail!Score error!");
									tishi.add(tishilabel);
								}

							}
						}
					}
				});

			}
		});
		openfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame tishi = new JFrame("Feedback information");
				tishi.setVisible(true);// ��ʾ���
				tishi.setResizable(false);// ��С���ɱ�
				tishi.setSize(250, 100);// ��ʾ��С
				JLabel tishilabel = new JLabel();
				tishilabel.setHorizontalAlignment(JLabel.CENTER);
				Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
				Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
				int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
				int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
				int windowWidth = tishi.getWidth();// ��ô��ڿ�
				int windowHeight = tishi.getHeight();// ��ô��ڸ�
				tishi.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���
				if (BallUtil.remap.size() == 0) {
					tishilabel.setText("The  game results does not exist!");
					tishi.add(tishilabel);
				} else {
					String a = t.savaResults(BallUtil.remap);
					if ("True".equals(a)) {
						tishilabel.setText("Success��");
						tishi.add(tishilabel);
					} else {
						tishilabel.setText("Fail!");
						tishi.add(tishilabel);
					}
				}
			}
		});
		exitfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame jfr = new JFrame("Exit the game");
				jfr.setVisible(true);
				jfr.setSize(300, 100);
				Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
				Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
				int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
				int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
				int windowWidth = jfr.getWidth();// ��ô��ڿ�
				int windowHeight = jfr.getHeight();// ��ô��ڸ�
				jfr.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���
				jfr.setLayout(null);
				final JTextField jtf = new JTextField();
				jtf.setSize(180, 40);
				jtf.setLocation(10, 10);
				jfr.add(jtf);
				JButton exitbu = new JButton("Yes");
				exitbu.setSize(70, 40);
				exitbu.setLocation(200, 10);
				jfr.add(exitbu);

				exitbu.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						JFrame tishi = new JFrame("Feedback information");
						tishi.setVisible(true);// ��ʾ���
						tishi.setResizable(false);// ��С���ɱ�
						tishi.setSize(250, 100);// ��ʾ��С
						JLabel tishilabel = new JLabel();
						tishilabel.setHorizontalAlignment(JLabel.CENTER);
						Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
						Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
						int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
						int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
						int windowWidth = tishi.getWidth();// ��ô��ڿ�
						int windowHeight = tishi.getHeight();// ��ô��ڸ�
						tishi.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���

						String exittema = jtf.getText();
						if (exittema.trim().length() == 0) {
							tishilabel.setText("Incorrect format of team name !");
							tishi.add(tishilabel);
						} else {
							String a = t.tuisai(exittema);

							if ("True".equals(a)) {
								tishilabel.setText(exittema + ":Exit the game ! Success !");
								tishi.add(tishilabel);
							} else {
								tishilabel.setText(exittema + ":Can't find ! Fail! ");
								tishi.add(tishilabel);
							}
							// ˢ�±�����¼���
							rcpanel.removeAll();
							if (BallUtil.arr.size() == 0) {
								la1.setText("Please Open Team File��");
								rcpanel.add(la1);
							} else if (BallUtil.teammap.size() != 0) {
								String[] title = { "TeamOne", "SconreOne", "TeamTwo", "SconreOne" };
								String[][] date = new String[BallUtil.teammap.size()][4];
								int j = 0;
								for (int i = 1; i < BallUtil.size + 1; i++) {

									if (BallUtil.teammap.get(i) != null) {
										date[j][0] = BallUtil.teammap.get(i).Teamnameone;
										date[j][1] = String.valueOf(BallUtil.teammap.get(i).scoreone);
										date[j][2] = BallUtil.teammap.get(i).Teamnametwo;
										date[j][3] = String.valueOf(BallUtil.teammap.get(i).scoretwo);
										j++;
									}
								}
								JTable tab = new JTable(date, title);
								JScrollPane src = new JScrollPane(tab);
								rcpanel.add(src);

							}
						}
					}
				});
			}
		});
		aafile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame tishi = new JFrame("Feedback information");
				tishi.setVisible(true);// ��ʾ���
				tishi.setResizable(false);// ��С���ɱ�
				tishi.setSize(250, 100);// ��ʾ��С
				JLabel tishilabel = new JLabel();
				tishilabel.setHorizontalAlignment(JLabel.CENTER);
				Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
				Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
				int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
				int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
				int windowWidth = tishi.getWidth();// ��ô��ڿ�
				int windowHeight = tishi.getHeight();// ��ô��ڸ�
				tishi.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���

				if(BallUtil.state==2) {//�ж��Ƿ��ȡ��
					tishilabel.setText("Error ! Please do not repeat reading !");
					tishi.add(tishilabel);
				}else {
				t.chengji();
				t.jieguo(BallUtil.teammap);
				rcpanel.removeAll();
				if (BallUtil.arr.size() == 0) {
					tishilabel.setText("Please Open Team File��");
					tishi.add(tishilabel);
				} else if (BallUtil.teammap.size() != 0) {

					String[] title = { "TeamOne", "SconreOne", "TeanTwo", "SconreTwo" };
					String[][] date = new String[BallUtil.teammap.size()][4];
					int j = 0;
					for (int i = 1; i < BallUtil.size + 1; i++) {
						if (BallUtil.teammap.get(i) != null) {
							date[j][0] = BallUtil.teammap.get(i).Teamnameone;
							date[j][1] = String.valueOf(BallUtil.teammap.get(i).scoreone);
							date[j][2] = BallUtil.teammap.get(i).Teamnametwo;
							date[j][3] = String.valueOf(BallUtil.teammap.get(i).scoretwo);
							j++;
						}
					}
					JTable tab = new JTable(date, title);
					JScrollPane src = new JScrollPane(tab);
					rcpanel.add(src);
					BallUtil.state=2;
					tishilabel.setText("Open ResultsIn ! Success !");
					tishi.add(tishilabel);
				}
			}}
		});
		bbfile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame tishi = new JFrame("Feedback information");
				tishi.setVisible(true);// ��ʾ���
				tishi.setResizable(false);// ��С���ɱ�
				tishi.setSize(250, 100);// ��ʾ��С
				JLabel tishilabel = new JLabel();
				tishilabel.setHorizontalAlignment(JLabel.CENTER);
				Toolkit kit = Toolkit.getDefaultToolkit(); // ���幤�߰�
				Dimension screenSize = kit.getScreenSize();// ��ȡ��Ļ�ĳߴ�
				int screenWidth = screenSize.width;// ��ȡ��Ļ�Ŀ�
				int screenHeight = screenSize.height;// ��ȡ��Ļ�ĸ�
				int windowWidth = tishi.getWidth();// ��ô��ڿ�
				int windowHeight = tishi.getHeight();// ��ô��ڸ�
				tishi.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);// ���ô��ھ���
				
				
				
				if (BallUtil.arr.size() == 0) {
					
					tishilabel.setText("Team information ! Read Success !");
					tishi.add(tishilabel);
					BallUtil.arr.clear();
					t.teamname();
					t.bisaijilu(BallUtil.arr);
					t.addjieguo(BallUtil.arr);
					rcpanel.removeAll();
					if (BallUtil.arr.size() == 0) {
						la1.setText("��ѡ������ļ���");
						rcpanel.add(la1);
					} else if (BallUtil.teammap.size() != 0) {

						String[] title = { "TeamOne", "SconreOne", "TeamTwo", "SconreTwo" };
						String[][] date = new String[BallUtil.teammap.size()][4];
						int j = 0;
						for (int i = 1; i < BallUtil.size + 1; i++) {
							if (BallUtil.teammap.get(i) != null) {
								date[j][0] = BallUtil.teammap.get(i).Teamnameone;
								date[j][1] = String.valueOf(BallUtil.teammap.get(i).scoreone);
								date[j][2] = BallUtil.teammap.get(i).Teamnametwo;
								date[j][3] = String.valueOf(BallUtil.teammap.get(i).scoretwo);
								j++;
							}
						}
						JTable tab = new JTable(date, title);
						JScrollPane src = new JScrollPane(tab);
						rcpanel.add(src);

					}
				} else {
					tishilabel.setText("Error ! Team information !"+"Already exist !");
					tishi.add(tishilabel);
				}

			}

		});
		jmb.add(fileMenu);
		jfmain.add(jmb);

		jfmain.setLayout(null);// ȡ��ԭ�в���
		Container con = jfmain.getContentPane();
		JTabbedPane bisai = new JTabbedPane(JTabbedPane.TOP);
		bisai.setBounds(0, jmb.getHeight(), jfmain.getWidth(), jfmain.getHeight() - jmb.getHeight());
		rcpanel.addAncestorListener(new AncestorListener() {
			@Override
			public void ancestorRemoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				// ��ȥʱִ��
				rcpanel.removeAll();
				for (Team string : BallUtil.teammap.values()) {
					System.out.println(string.Teamnameone);
					System.out.println(string.Teamnametwo);
					System.out.println(string.scoreone);
					System.out.println(string.scoretwo);
				}
				if (BallUtil.arr.size() == 0) {
					Label label = new Label();
					label.setText("Please Open File��");
					rcpanel.add(label);
				} else if (BallUtil.teammap.size() != 0) {

					String[] title = { "TeamOne", "ScoreOne", "TeamTwo", "ScoreTwo" };
					String[][] date = new String[BallUtil.teammap.size()][4];
					int j = 0;
					for (int i = 1; i < BallUtil.size + 1; i++) {

						if (BallUtil.teammap.get(i) != null) {
							date[j][0] = BallUtil.teammap.get(i).Teamnameone;
							date[j][1] = String.valueOf(BallUtil.teammap.get(i).scoreone);
							date[j][2] = BallUtil.teammap.get(i).Teamnametwo;
							date[j][3] = String.valueOf(BallUtil.teammap.get(i).scoretwo);
							j++;

						}
					}
					JTable tab = new JTable(date, title);
					JScrollPane src = new JScrollPane(tab);
					rcpanel.add(src);

				}
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub
				// �ƶ�
				System.out.println("222");
			}

			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub
				// �����ʱִ��
			}
		});
		jgpanel.addAncestorListener(new AncestorListener() {

			@Override
			public void ancestorRemoved(AncestorEvent event) {
				jgpanel.removeAll();
				BallUtil.remap.clear();
				t.addjieguo(BallUtil.arr);
				t.jieguo(BallUtil.teammap);
				if (BallUtil.arr.size() == 0) {
					Label label = new Label();
					label.setText("Please Open File��");
					jgpanel.add(label);
				} else if (BallUtil.teammap.size() != 0) {
					String[] title = { "Teamname", "MatchesWon", "MatchesDrawn", "MatchesLost", "GoalsFor",
							"GoalsAgainst", "MatchPoints", "GoalDiff", "Rank", "Medal" };
					String[][] date = new String[BallUtil.remap.size()][10];
					int i = 0;

					List<Map.Entry<String, Results>> list = new ArrayList<Map.Entry<String, Results>>();
					list.addAll(BallUtil.remap.entrySet());
					RankUtil vc = new RankUtil();
					Collections.sort(list, vc);
					for (Iterator<Entry<String, Results>> it = list.iterator(); it.hasNext();) {
						if (BallUtil.arr.get(i) != null) {
							Results results = it.next().getValue();
							date[i][0] = results.getTeamname();
							date[i][1] = String.valueOf(results.getMatchesWon());
							date[i][2] = String.valueOf(results.getMatchesDrawn());
							date[i][3] = String.valueOf(results.getMatchesLost());
							date[i][4] = String.valueOf(results.getGoalsFor());
							date[i][5] = String.valueOf(results.getGoalsAgainst());
							date[i][6] = String.valueOf(results.getMatchPoints());
							date[i][7] = String.valueOf(results.getGoalDiff());
							date[i][8] = String.valueOf(i + 1);
							if (i == 0) {
								date[i][9] = "Gold";
							} else if (i == 1) {
								date[i][9] = "Silver";
							} else if (i == 2) {
								date[i][9] = "Bronze";
							} else {
								date[i][9] = "";
							}
							i++;
						}
					}

					JTable tab1 = new JTable(date, title);
					JScrollPane src1 = new JScrollPane(tab1);
					jgpanel.add(src1);
				}
			}

			@Override
			public void ancestorMoved(AncestorEvent event) {
				// TODO Auto-generated method stub

			}

			@Override
			public void ancestorAdded(AncestorEvent event) {
				// TODO Auto-generated method stub

			}
		});
		bisai.addTab("Game information", rcpanel);
		bisai.addTab("Result of the game", jgpanel);
		con.add(bisai);
		jfmain.setVisible(true);// �����Ƿ�ɼ�
		jfmain.setResizable(false);// ���ڴ�С�����Ըı�
		jfmain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�رճ���

	}

	public void shuaxin() {

	}

	public static void main(String[] args) {
		MainGui mg = new MainGui();
		mg.JavaBallGui();

	}
}
