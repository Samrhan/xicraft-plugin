package xicraft.xicraft.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;
import xicraft.xicraft.Event.Entity.EntityDeath;
import xicraft.xicraft.Event.Entity.EntitySpawn;
import xicraft.xicraft.Event.Mobs.GriefEvent;
import xicraft.xicraft.Event.Player.*;
import xicraft.xicraft.Xicraft;

public class Handler implements Listener {
    public Handler(Xicraft plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntitySpawn(EntitySpawnEvent event) {
        new EntitySpawn(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerLog(PlayerLoginEvent event) {
        new PlayerLog(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerUnlog(PlayerQuitEvent event) {
        new PlayerUnlog(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDie(EntityDeathEvent event) {
        new EntityDeath(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onGriefEvent(EntityChangeBlockEvent event) {
        new GriefEvent(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommandEvent(PlayerCommandPreprocessEvent event) {
        new PlayerCommand(event);
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void catchInteract(InventoryOpenEvent event) {
        new InventoryOpen(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event) {
        new PlayerUse(event);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerConsume(PlayerItemConsumeEvent event) {
        new PlayerConsume(event);
    }

}
