package frames;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public JProgressBar loading;
	
	public MainFrame() {
		setTitle("GerryBot");
		setSize(600, 400);
		setVisible(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loading = new JProgressBar();
		loading.setSize(getWidth() / 2, getHeight() / 4);
		loading.setLocation((int) (loading.getWidth() / 2.2), (int)(loading.getHeight() / 0.8));
		loading.setIndeterminate(true);
		add(loading);
	}
}
