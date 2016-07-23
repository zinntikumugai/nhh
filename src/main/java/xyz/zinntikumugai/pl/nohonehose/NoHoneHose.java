package xyz.zinntikumugai.pl.nohonehose;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NoHoneHose extends JavaPlugin {

	private NoHoneHose_Config config;
	private NoHoneHose_Command command;
	private Func func;

	@Override
	public void onEnable() {

		config = new NoHoneHose_Config(this);
		command = new NoHoneHose_Command(this);

		config.loadConfig();

		this.getCommand("nohonehose").setExecutor(command);

		getServer().getPluginManager().registerEvents(new NoHoneHose_Listerer(), this);
	}

	@Override
	public void onDisable() {

	}

	public Logger getLogHandler() {
		return getLogger();
	}

	public NoHoneHose_Config getConfigHandler() {
		return config;
	}

	public NoHoneHose_Command getCommandHandler() {
		return command;
	}

	public Func getfuncHandler() {
		return func;
	}


}
