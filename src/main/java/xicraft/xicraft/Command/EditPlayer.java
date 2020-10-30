package xicraft.xicraft.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EditPlayer implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equals("rename"))
                    if (args.length != 0) {
                        player.setDisplayName(args[0]);
                        return true;
                    }
            } else {
                player.sendRawMessage("[Xi] Tu n'as pas la permission d'effectuer cette commande");
            }
        }
        return true;
    }

}
