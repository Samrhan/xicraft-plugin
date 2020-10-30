package xicraft.xicraft.Exchange;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.Player.Inventory;

public class GetDollar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendRawMessage(String.format("[Xi] tu as %d$ dans ton inventaire", Inventory.money(player)));
        }
        return true;
    }
}
