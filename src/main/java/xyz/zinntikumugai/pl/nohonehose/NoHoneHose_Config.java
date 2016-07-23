package xyz.zinntikumugai.pl.nohonehose;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;

public class NoHoneHose_Config {

	private NoHoneHose nhh;
	public FileConfiguration config = null;
	final private Logger logs;

	private String worldname;
	private String prefix_title;
	private String prefix_coloer;

	public NoHoneHose_Config(final NoHoneHose nhh) {
		this.nhh = nhh;
		this.logs = nhh.getLogger();

		this.loadConfig();
	}

	public boolean loadConfig() {

		if(!(new File(nhh.getDataFolder() + File.separator + "config.yml").exists())) {

			//デフォルトコピー
			nhh.saveDefaultConfig();
			logs.info("Default Config file Copied");
		}

		//リロード
		if(config != null) {
			nhh.reloadConfig();
		}

		config        = nhh.getConfig();

		worldname     = config.getString("BlockWorld", "home");
		prefix_title  = config.getString("prefix.title", "[NHH] §r");
		prefix_coloer = config.getString("prefix.coloer", "");


		return false;

	}

	public String getwroldname() {
		return this.worldname;
	}

	public String getprefix_title() {
		return this.prefix_title;
	}

	public String getprefix_coloer() {
		return this.prefix_coloer;
	}

	public String getprefix() {
		return this.prefix_coloer + this.prefix_title + "§r ";
	}

}
