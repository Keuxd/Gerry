package core;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ChatListener extends ListenerAdapter {

	private final String DICE_REGEX = "^([1-9][0-9]?)?d[1-9][0-9]{0,3}([+-](([1-9][0-9]?)?d[1-9][0-9]{0,3}|[0-9]{1,2}))*$";
	
	@Override
	 public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) return;
		if(!event.isFromGuild()) return;
		String message = event.getMessage().getContentRaw().toLowerCase();
				
		System.out.println(event.getAuthor().getEffectiveName() + " -> " + message);
		
		// Dice Roll
		if(message.matches(DICE_REGEX)) {
			DiceRoller dr = new DiceRoller(message);

			EmbedBuilder eb = new EmbedBuilder();
			eb.setColor(Color.DARK_GRAY);
			eb.setTitle(dr.getTotalSum() + "");
			eb.setFooter(dr.dicesToString());
			eb.setAuthor(event.getAuthor().getEffectiveName(), null, event.getAuthor().getAvatarUrl());
			
			event.getChannel().sendMessageEmbeds(eb.build()).queue();
			Main.mainFrame.addUserToRollList(event.getAuthor());
		}
		
	}
}
