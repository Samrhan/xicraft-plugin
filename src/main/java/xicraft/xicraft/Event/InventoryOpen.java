package xicraft.xicraft.Event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import xicraft.xicraft.DB;
import xicraft.xicraft.WorldGuard.WG;
import xicraft.xicraft.XiteEvent.Leaderboard;

import java.util.Objects;

public class InventoryOpen {
    public Location chest_xite = new Location(Bukkit.getWorld("xite"), -114, 137, 84);

    public InventoryOpen(InventoryOpenEvent event){
        Player player = (Player) event.getPlayer();
        //if (!player.isOp()){
        InventoryType tmp = event.getInventory().getType();
        if (!tmp.equals(InventoryType.CREATIVE) && !tmp.equals(InventoryType.PLAYER) && !tmp.equals(InventoryType.MERCHANT)) {
            if (event.getInventory().getLocation() != null && !WG.hisOwn(event.getInventory().getLocation(), player))
                event.setCancelled(true);
            if (tmp.equals(InventoryType.CHEST)) {
                if (Objects.equals(event.getInventory().getLocation(), chest_xite)) {
                    event.setCancelled(true);
                    ItemStack mainHand = player.getInventory().getItemInMainHand();
                    if (mainHand.getType() == Material.EMERALD) {
                        int amount = mainHand.getAmount();
                        player.sendRawMessage(String.format("Tu viens de gagner %d points !", amount));
                        mainHand.setAmount(0);
                        DB db = new DB();
                        int player_pts = db.getPoints(player.getUniqueId().toString());
                        db.setPoints(player.getUniqueId().toString(), player_pts + amount);
                        Leaderboard.refresh();
                    }

                }
            }
        }
        //}
    }
}
