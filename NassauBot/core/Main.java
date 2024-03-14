package core;

import frames.MainFrame;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

	private static final String TESTERT_TOKEN = "";
	
	public static JDA jda;
	public static MainFrame mainFrame;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Running");
		mainFrame = new MainFrame();
		//buildBot();
	}
	
	private static void buildBot() throws InterruptedException {
		JDABuilder builder = JDABuilder.createDefault(TESTERT_TOKEN);
		
		builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
		builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
		builder.setActivity(Activity.watching("Aula"));
		builder.addEventListeners(new ChatListener());
		
		jda = builder.build();
		jda.awaitReady();
		
		mainFrame.removeLoading();
		
		System.out.println("Bot Ready!");
	}
}
