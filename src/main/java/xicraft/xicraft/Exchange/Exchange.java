package xicraft.xicraft.Exchange;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.CustomItems.Money;
import xicraft.xicraft.DB;
import xicraft.xicraft.Player.Inventory;

public class Exchange implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args != null && args.length == 1) {
                int amount = Integer.parseInt(args[0]);
                if (amount > 0) {
                    DB db = new DB();
                    int xicoins = db.getXicoin(player.getUniqueId().toString());
                    int $ = Inventory.money(player);
                    if (xicoins >= amount && amount % 10 == 0) {
                        xicoins -= amount;
                        db.setXicoin(player.getUniqueId().toString(), xicoins);
                        Money.give(player, amount / 10);
                        return true;
                    } else if (xicoins < amount) {
                        player.sendRawMessage(String.format("[Xi] t'as pas assez de xicoins, t'en a que %d", xicoins));
                    } else {
                        player.sendRawMessage("[Xi] tu ne peux échanger que des multiples de 10 (1$ = 10 xicoins)");
                    }

                }
            }
        }
        return false;
    }
}

