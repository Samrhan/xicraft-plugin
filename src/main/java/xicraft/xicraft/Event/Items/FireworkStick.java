package xicraft.xicraft.Event.Items;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkStick {


    public FireworkStick(Player p, String lore, PlayerInteractEvent event){
        Firework fire = p.getWorld().spawn(event.getPlayer().getEyeLocation(), Firework.class);
        FireworkMeta fwm = fire.getFireworkMeta();
        FireworkEffect.Type explosion_type = FireworkEffect.Type.CREEPER;
        Color couleur = Color.GREEN;
        if (lore.endsWith("Creeper")) {
            explosion_type = FireworkEffect.Type.CREEPER;
        } else if (lore.endsWith("Star")) {
            explosion_type = FireworkEffect.Type.STAR;
            couleur = Color.YELLOW;
        } else if (lore.endsWith("Ball")) {
            explosion_type = FireworkEffect.Type.BALL;
            couleur = Color.RED;
        } else if (lore.endsWith("Bigball")) {
            explosion_type = FireworkEffect.Type.BALL_LARGE;
            couleur = Color.RED;
        } else if (lore.endsWith("Burst")) {
            explosion_type = FireworkEffect.Type.BURST;
            couleur = Color.RED;
        }
        FireworkEffect effect = FireworkEffect.builder().withColor(couleur).with(explosion_type).withTrail().build();
        fwm.addEffects(effect);
        fwm.setPower(0);
        fire.setFireworkMeta(fwm);
    }
}
