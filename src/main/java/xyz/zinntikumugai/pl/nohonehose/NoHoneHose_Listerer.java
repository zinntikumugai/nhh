package xyz.zinntikumugai.pl.nohonehose;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NoHoneHose_Listerer implements Listener {

	final private String bw;

	public NoHoneHose_Listerer( NoHoneHose nhh) {
		this.bw = nhh.getConfigHandler().getwroldname();
	}

	/**
	 * 自然(or コマンド)でスポーンした
	 * @param e
	 */
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {

		if(e.getEntityType().equals(EntityType.HORSE)) {
			Horse h = (Horse)e.getEntity();

			if(h.getVariant().equals(Variant.SKELETON_HORSE)) {

				//System.out.println("SKELETON HORSE!");

				//System.out.println(h.getWorld().getName());

				if(
						isblockworld(h.getWorld()) &&
						!(e.isCancelled())
						) {

					e.setCancelled(true);
				}
			}
		}
	}
/* スポーン判定で一緒に処理できる(ダブらせる必要ないね)
	/**
	 * スポナーからスポーンした
	 * @param e
	 * /
	@EventHandler
	public void onSpawnerSpawn(SpawnerSpawnEvent e) {
		if(e.getEntityType().equals(EntityType.HORSE)) {

			Horse h = (Horse)e.getEntity();

			if(h.getVariant().equals(Variant.SKELETON_HORSE)) {
				//スケ馬がすぽなーで出てきた

				if(
						isblockworld(h.getWorld()) &&
						!(e.isCancelled()) &&
						!(nhh.getConfigHandler().getCan_Spa())
						) {
					e.setCancelled(true);
				}
			}
		}

	}
*/

	public boolean isblockworld(World w) {
		String w_s = w.getName().toString();

		if( w_s.equals(bw)) {
			return true;
		}
		return false;
	}
}
