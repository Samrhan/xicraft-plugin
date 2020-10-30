package xicraft.xicraft.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xicraft.xicraft.Teleport.MapLocation;

import java.util.Objects;

public class Teleport implements CommandExecutor {

    private boolean cantp(Player player) {
        return (player.getWorld().getName().equals("world") || player.getWorld().getName().equals("world_the_end") || player.getWorld().getName().equals("world_nether") || player.getWorld().getName().equals("freebuild"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equals("village") && (cantp(player)))
                player.teleport(MapLocation.VILLAGE);
            if (cmd.getName().equals("lobby") && (cantp(player)))
                player.teleport(MapLocation.LOBBY);
            if (cmd.getName().equals("home") && (cantp(player)))
                if ((player.getBedSpawnLocation() != null))
                    player.teleport(Objects.requireNonNull(player.getBedSpawnLocation()));
        }
        return true;
    }
}
