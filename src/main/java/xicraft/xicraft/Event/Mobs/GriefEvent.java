package xicraft.xicraft.Event.Mobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class GriefEvent {
    public GriefEvent(EntityChangeBlockEvent event) {
        if (event.getEntity().getType() == EntityType.WITHER) {
            Entity wither = event.getEntity();
            if (wither.getName().equals("PolPot") || wither.getName().equals("PolPot's_Father") ) {
                event.setCancelled(true);
            }
        }

    }
}
