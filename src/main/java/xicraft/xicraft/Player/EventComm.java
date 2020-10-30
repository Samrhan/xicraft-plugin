package xicraft.xicraft.Player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.DB;
import xicraft.xicraft.XiteEvent.Leaderboard;

public class EventComm implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            DB db = new DB();
            if (cmd.getName().equals("pts"))
                player.sendRawMessage(String.format("[Xi] tu as %d points", db.getPoints(player.getUniqueId().toString())));
            if(cmd.getName().equals("reset")){
                if(player.isOp()){
                    if(args.length == 1){
                        Player reset = sender.getServer().getPlayer(args[0]);
                        assert reset != null;
                        db.setPoints(reset.getUniqueId().toString(), 0);
                        Leaderboard.refresh();
                    }
                }
            }
        }
        return true;
    }
}
