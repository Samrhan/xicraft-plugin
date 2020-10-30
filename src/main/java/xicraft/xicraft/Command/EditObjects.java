package xicraft.xicraft.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EditObjects implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equals("lore"))
                    if (args.length > 0) {
                        ItemStack item = player.getInventory().getItemInMainHand();
                        ItemMeta meta = item.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add(String.join(" ", args));
                        meta.setLore(lore);
                        item.setItemMeta(meta);
                        return true;
                    } else return false;
                if (cmd.getName().equals("dn"))
                    if (args.length > 0) {
                        ItemStack item = player.getInventory().getItemInMainHand();
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName(String.join(" ", args));
                        item.setItemMeta(meta);
                        return true;
                    } else return false;
            }
            if (cmd.getName().equals("glow")) {
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                assert meta != null;
                meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item.setItemMeta(meta);
            }
        }
        return true;
    }

}
