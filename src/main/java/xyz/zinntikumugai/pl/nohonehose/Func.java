package xyz.zinntikumugai.pl.nohonehose;

import java.util.logging.Logger;

import org.bukkit.entity.Player;

public class Func {

	final private Logger logs;

	public Func(NoHoneHose nhh) {
		this.logs = nhh.getLogger();
	}

	/**
	 * コマンドを実行したPlayerが権限を持っていいるか
	 * @param p
	 * @param per
	 * @return
	 */
	public static boolean hasPermission(Player p, String per) {
		//System.out.println("hasPermission");
		if(p.hasPermission(per)) {
			//System.out.println("true player");
			return true;
		}
		return false;
	}

}
