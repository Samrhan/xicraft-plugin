package xicraft.xicraft.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.CustomItems.CustomObjects;

public class GiveObjects implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (cmd.getName().equals("knackie"))
                    player.getInventory().addItem(CustomObjects.getKnackie(1));
                if (cmd.getName().equals("fw"))
                    if (args.length == 1) {
                        player.getInventory().addItem(CustomObjects.getFWStick(1, args));
                    }
                if (cmd.getName().equals("fb"))
                    player.getInventory().addItem(CustomObjects.getFBStick(1));
                if (cmd.getName().equals("house"))
                    if (args.length == 1 && player.isOp()) {
                        player.getInventory().addItem(CustomObjects.getBookHouse(1, args));
                    }        return true;

            }
            else{
                player.sendRawMessage("[Xi] Tu n'as pas la permission d'effectuer cette commande");
            }
        }
        return true;
    }

}
