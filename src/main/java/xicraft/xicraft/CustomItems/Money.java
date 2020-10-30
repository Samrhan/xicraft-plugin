package xicraft.xicraft.CustomItems;

import org.bukkit.entity.Player;

public class Money {
    public static void give(Player player, int amount) {
        int saved = amount;
        int block = 0;
        int perle = 0;
        int cristal = 0;
        while (amount >= 100) {
            cristal++;
            amount -= 100;
        }
        while (amount >= 10) {
            block++;
            amount -= 10;
        }
        while (amount > 0) {
            perle++;
            amount--;
        }
        player.getInventory().addItem(CustomObjects.getCristal(cristal));
        player.getInventory().addItem(CustomObjects.getBlock(block));
        player.getInventory().addItem(CustomObjects.getPearl(perle));
        player.sendRawMessage(String.format("[Xi] tu viens de récupérer %d$ en échange de %d xicoins", saved, saved * 10));
    }
}
