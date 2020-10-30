package xicraft.xicraft.Exchange;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.DB;

public class GetXicoins implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            DB db = new DB();
            int xicoins = db.getXicoin(player.getUniqueId().toString());
            player.sendRawMessage(String.format("[Xi] tu as %d xicoins", xicoins));
        }
        return true;
    }
}
