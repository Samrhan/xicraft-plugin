package xicraft.xicraft.Player;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import xicraft.xicraft.CustomItems.CustomObjects;

public class Inventory {
    public static int getAmount(Player arg0, ItemStack arg1) {
        if (arg1 == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = arg0.getInventory().getItem(i);
            if (slot == null || slot.isSimilar(arg1))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

    public static int money(Player player) {
        return getAmount(player, CustomObjects.getPearl(1)) + getAmount(player, CustomObjects.getBlock(1)) * 10 + getAmount(player, CustomObjects.getCristal(1)) * 100;
    }
}

