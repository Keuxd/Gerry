package core;

import java.util.Arrays;

import frames.MainFrame;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

	private static final String TESTERT_TOKEN = "Nzk1OTUwNzg3MTU4OTk5MDYx.GyL5iV.A51afe0u0q7PvE10nGaIVDNln07iC2xh6yo51k";
	
	public static JDA jda;
	public static MainFrame mainFrame;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Running");
		//SIMULATION();
		mainFrame = new MainFrame();
		buildBot();
	}
	
	private static void buildBot() throws InterruptedException {
		JDABuilder builder = JDABuilder.createDefault(TESTERT_TOKEN);
		
		builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
		builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
		builder.setActivity(Activity.watching("Aula"));
		builder.addEventListeners(new ChatListener());
		
		jda = builder.build();
		jda.awaitReady();
		mainFrame.remove(mainFrame.loading);
		mainFrame.repaint();
		System.out.println("Bot Ready!");
	}
	
	public static void SIMULATION() {
		final String DICE_REGEX = "^([1-9][0-9]?)?d[1-9][0-9]{0,3}([+-](([1-9][0-9]?)?d[1-9][0-9]{0,3}|[0-9]{1,2}))*$";
		String message = "2d20+d40-1d20+60+6d6";
		System.out.println("Message: " + message);
		if(message.matches(DICE_REGEX)) {
			DiceRoller dr = new DiceRoller(message);
			dr.DEBUG_VALUES();
			System.out.println(dr.dicesToString());
		}
	}
}
