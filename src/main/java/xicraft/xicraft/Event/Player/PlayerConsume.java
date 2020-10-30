package xicraft.xicraft.Event.Player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import xicraft.xicraft.WorldGuard.WG;

public class PlayerConsume {
    public PlayerConsume(PlayerItemConsumeEvent event) {
        Player player = event.getPlayer();
        if (WG.get_rg(player.getLocation()).getId().equals("polpot") && event.getItem().getType() == Material.MILK_BUCKET) {
            event.setCancelled(true);
        }
    }
}
