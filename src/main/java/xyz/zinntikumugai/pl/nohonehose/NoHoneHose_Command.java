package xyz.zinntikumugai.pl.nohonehose;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class NoHoneHose_Command implements CommandExecutor {

	final private Logger logs;
	final private NoHoneHose_Config config;
	final private String prefix;
	final private Func func;

	private String[] help = {
			"help §r this page",
			"reload §r config file reload",
			"show §r list up hose",
			"remove §r remove hose"
	};

	public NoHoneHose_Command(NoHoneHose nhh) {

		this.logs = nhh.getLogger();
		this.config = nhh.getConfigHandler();
		this.prefix = nhh.getConfigHandler().getprefix();
		this.func = nhh.getfuncHandler();
	}

	@Override
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {

		Player p = null;
		if( sender instanceof Player) {
			p = (Player)sender;
		}

		if(command.getName().equalsIgnoreCase("nohonehose")) {

			if(args.length == 0) {
				if( p!=null)
					p.sendMessage(prefix + "please option");
				else
					logs.info("please option");
				return true;
			}

			switch(args[0]) {

				case "reload":
					if(p!=null) {
						b_reload(p);
					}else {
						b_reload();
					}
					break;

				case "help":
					if(p!=null) {
						b_help(p);
					}else {
						b_help();
					}
					break;

				case "show":
					break;

				case "remove":
					break;

				default:
					break;
			}
			return true;
		}

		return false;

	}

	/**
	 * リロード
	 * @param p
	 */
	private void b_reload() {
		logs.info("Config File relaoding...");

		config.loadConfig();

		logs.info("Reloaded!");
	}

	@SuppressWarnings("static-access")
	private void b_reload(Player p) {
		if( p==null) {
			b_reload();
			return;
		}

		if(!func.hasPermission(p, "nhh.reload")) {
			//権限を持っていない
			p.sendMessage(prefix + "You don't have permissionn");
		}else {
			p.sendMessage(prefix + "Config File reloading...");
			b_reload();
			p.sendMessage(prefix + "Reloaded!");
		}
		return;
	}

	//ヘルプ
	private void b_help() {
		for(String s : help) {
			logs.info( "§b/nohonehose " + s );
		}
	}

	private void b_help(Player p) {
		for(String s : help) {
			p.sendMessage( prefix + "§b/nohonehose " + s );
		}
	}

	//remove
	//show

}
