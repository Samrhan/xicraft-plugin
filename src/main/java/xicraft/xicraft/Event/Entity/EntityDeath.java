package xicraft.xicraft.Event.Entity;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import xicraft.xicraft.CustomItems.CustomObjects;

import java.util.concurrent.ThreadLocalRandom;

public class EntityDeath {
    private boolean candrop(LivingEntity entity) {
        return (entity.getWorld().getName().equals("world") || entity.getWorld().getName().equals("world_the_end") || entity.getWorld().getName().equals("world_nether"));
    }

    public EntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity.getName().equals("Horse") && candrop(event.getEntity())) {
            ItemStack item = new ItemStack(Material.TNT_MINECART);
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            meta.setDisplayName("Lasagnes Findus");
            item.setItemMeta(meta);
            event.getDrops().add(item);
        } else if (entity.getName().equals("Polpot")) {
            entity.getWorld().getBlockAt(1283, 32, -738).setType(Material.REDSTONE_BLOCK);
            entity.getWorld().getBlockAt(1305, 37, -737).setType(Material.STONE_PRESSURE_PLATE);
            event.getDrops().add(CustomObjects.getCristal(3));
        } else if (entity.getName().equals("PolPot's_Father")) {
            entity.getWorld().getBlockAt(340, 144, -3809).setType(Material.REDSTONE_BLOCK);
            entity.getWorld().getBlockAt(340, 144, -3803).setType(Material.REDSTONE_BLOCK);
            event.getDrops().add(CustomObjects.getCristal(10));
        } else if (entity.getName().equals("Polpot's_commander")) {
            entity.getWorld().getBlockAt(353, 158, -3820).setType(Material.AIR);
            entity.getWorld().getBlockAt(353, 157, -3820).setType(Material.AIR);
            entity.getWorld().getBlockAt( 340, 144, -3805).setType(Material.REDSTONE_BLOCK);
            event.getDrops().add(CustomObjects.getCristal(3));
        }
        if (candrop(event.getEntity())) {
            int random1 = ThreadLocalRandom.current().nextInt(0, 10 + 1);
            int random2 = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            int random3 = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            if (random3 == 666) {
                event.getDrops().add(CustomObjects.getCristal(1));
            }
            if (random1 == 5) {
                event.getDrops().add(CustomObjects.getPearl(1));
            }
            if (random2 == 42) {
                event.getDrops().add(CustomObjects.getBlock(1));
            }
        }
    }
}
