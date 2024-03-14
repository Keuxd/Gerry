package frames;

import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;

import core.RollUser;
import net.dv8tion.jda.api.entities.User;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JProgressBar loading;
	private JList<RollUser> rollList;
	
	protected Set<RollUser> rollUsers;
	
	public MainFrame() {
		setTitle("GerryBot");
		setSize(600, 400);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loading = new JProgressBar();
		loading.setSize(getWidth() / 2, getHeight() / 4);
		loading.setLocation((int) (loading.getWidth() / 2.2), (int)(loading.getHeight() / 0.8));
		loading.setIndeterminate(true);
		//add(loading);
		
		addMainComponents();
		
		setVisible(true);
	}
	
	public void removeLoading() {
		remove(loading);
		repaint();
	}
	
	public void addMainComponents() {
		rollList = new JList<RollUser>();
		rollList.setLocation(30, 5);
		rollList.setSize(100, 200);
		rollList.setSelectedIndex(1);
		add(rollList);
	}
	
	public void addUserToRollList(User author) {
		DefaultListModel<RollUser> model = new DefaultListModel<>();
		
		for(RollUser user : )
	}
}
