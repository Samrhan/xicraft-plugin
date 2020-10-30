package xicraft.xicraft.Event.Player;

import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import xicraft.xicraft.DB;
import xicraft.xicraft.Event.Items.FireworkStick;
import xicraft.xicraft.WorldGuard.WG;

import java.util.Objects;

public class PlayerUse {
    public PlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if (!event.hasBlock() && p.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD && Objects.requireNonNull(p.getInventory().getItemInMainHand().getItemMeta()).hasLore()) {
            String lore = Objects.requireNonNull(Objects.requireNonNull(p.getInventory().getItemInMainHand().getItemMeta()).getLore()).get(0);
            if (lore.startsWith("Feu d'artifice")) {
                new FireworkStick(p, lore, event);
            } else if (lore.equals("BOULE DE FEUU")) {
                Fireball fire = p.getWorld().spawn(event.getPlayer().getEyeLocation(), Fireball.class);
                fire.setShooter(p);
            }
        }
        if (event.hasItem())
            if (Objects.requireNonNull(event.getItem()).isSimilar(new ItemStack(Material.VILLAGER_SPAWN_EGG))) {
                if (WG.hisOwn(p.getLocation(), p)) {
                    event.setCancelled(true);
                }
            }
        if (event.hasItem() && Objects.requireNonNull(event.getItem()).getType() == Material.EMERALD) {
            Player player = event.getPlayer();
            if (player.getWorld().getName().equals("xite")) {
                if (event.hasBlock() && Objects.requireNonNull(event.getClickedBlock()).getType() == Material.OAK_WALL_SIGN) {
                    Block block = event.getClickedBlock();
                    BlockState state = block.getState();
                    assert state instanceof Sign;
                    Sign sign = (Sign) state;
                    String price = sign.getLine(3);
                    int prix = 0;
                    if (price.startsWith("Prix ")) {
                        prix = Integer.parseInt(price.substring(5, 7));
                    }
                    if (prix > 0) {
                        ItemStack item_player = player.getInventory().getItemInMainHand();
                        int amount = item_player.getAmount();
                        if (amount >= prix) {
                            ProtectedRegion rg = WG.get_rg(block.getLocation());
                            if (rg.getOwners().size() == 0) {
                                DB db = new DB();
                                if (db.getHome(player.getUniqueId().toString()) == 0) {
                                    DefaultDomain members = rg.getOwners();
                                    members.addPlayer(player.getDisplayName());
                                    db.setHome(player.getUniqueId().toString(), 1);
                                    rg.setFlag(Flags.GREET_MESSAGE, String.format("Bienvenue chez %s !", player.getDisplayName()));
                                    item_player.setAmount(amount - prix);
                                    sign.setLine(2, player.getDisplayName());
                                    sign.setLine(3, "");
                                    sign.update();
                                } else {
                                    player.sendRawMessage("Tu as déjà une maison");
                                }
                            } else {
                                player.sendRawMessage("Cette maison appartient déjà à quelqu'un");
                            }
                        } else {
                            player.sendRawMessage("Tu n'as pas assez d'émeraude");
                        }
                    }

                }
            }
        }

    }
}
