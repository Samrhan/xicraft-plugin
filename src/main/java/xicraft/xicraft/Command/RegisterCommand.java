package xicraft.xicraft.Command;

import xicraft.xicraft.Exchange.Exchange;
import xicraft.xicraft.Exchange.GetDollar;
import xicraft.xicraft.Exchange.GetXicoins;
import xicraft.xicraft.Player.EventComm;
import xicraft.xicraft.Xicraft;

import java.util.Objects;

public class RegisterCommand {
    public static void register(Xicraft base){
        Objects.requireNonNull(base.getCommand("lobby")).setExecutor(new Teleport());
        Objects.requireNonNull(base.getCommand("village")).setExecutor(new Teleport());
        Objects.requireNonNull(base.getCommand("home")).setExecutor(new Teleport());
        Objects.requireNonNull(base.getCommand("xicoins")).setExecutor(new GetXicoins());
        Objects.requireNonNull(base.getCommand("echange")).setExecutor(new Exchange());
        Objects.requireNonNull(base.getCommand("$")).setExecutor(new GetDollar());
        Objects.requireNonNull(base.getCommand("knackie")).setExecutor(new GiveObjects());
        Objects.requireNonNull(base.getCommand("fb")).setExecutor(new GiveObjects());
        Objects.requireNonNull(base.getCommand("house")).setExecutor(new GiveObjects());
        Objects.requireNonNull(base.getCommand("fw")).setExecutor(new GiveObjects());
        Objects.requireNonNull(base.getCommand("rename")).setExecutor(new EditPlayer());
        Objects.requireNonNull(base.getCommand("glow")).setExecutor(new EditObjects());
        Objects.requireNonNull(base.getCommand("lore")).setExecutor(new EditObjects());
        Objects.requireNonNull(base.getCommand("dn")).setExecutor(new EditObjects());
        Objects.requireNonNull(base.getCommand("pts")).setExecutor(new EventComm());
        Objects.requireNonNull(base.getCommand("reset")).setExecutor(new EventComm());

    }
}
