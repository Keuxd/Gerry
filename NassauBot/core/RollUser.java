package core;

import net.dv8tion.jda.api.entities.User;

public class RollUser {
	
	private String name;
	
	public RollUser(User author) {
		this.name = author.getEffectiveName();
	}
	
	public String getName() {
		return this.name;
	}
}
