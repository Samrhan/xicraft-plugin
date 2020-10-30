package xicraft.xicraft.Event.Entity;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntitySpawnEvent;
import xicraft.xicraft.Event.Mobs.wither_donjon_1;

public class EntitySpawn {
    public EntitySpawn(EntitySpawnEvent event) {
        if (event.getEntityType() == EntityType.WITHER) {
            if (event.getEntity().getName().equals("Polpot"))
                new wither_donjon_1(event.getEntity());
        } /*else if (event.getEntityType() == EntityType.ENDER_DRAGON) {
            new ender_dragon_power_up(event.getEntity());
        }*/
    }
}

