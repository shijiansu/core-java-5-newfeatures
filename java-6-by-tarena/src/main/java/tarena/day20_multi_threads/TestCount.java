package tarena.day20_multi_threads;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestCount {
	private static boolean flag = false;

	public static void main(String[] args) {
		JFrame f = new JFrame("计数器");
		final JLabel label = new JLabel("0");
		label.setFont(new Font(null, Font.BOLD + Font.ITALIC, 80));
		f.add(label);
		JPanel panel = new JPanel();
		JButton start = new JButton("开始");
		JButton end = new JButton("结束");
		panel.add(start);
		panel.add(end);
		f.add(panel, "South");

		f.setSize(300, 260);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				flag = false;
				Thread t = new Thread() {
					public void run() {
						for (int i = 1; i <= 1000; i++) {
							label.setText(i + "");
							if (flag) {
								return;
							}
							try {
								Thread.sleep(100);
							} catch (Exception e) {
							}
						}
					}
				};
				t.start();
			}
		});
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = true;
			}
		});
		System.out.println("主方法结束");
	}
}
