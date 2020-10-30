package xicraft.xicraft.Event.Player;

import discord4j.common.util.Snowflake;
import discord4j.rest.entity.RestChannel;
import org.bukkit.event.player.PlayerLoginEvent;
import xicraft.xicraft.DB;
import xicraft.xicraft.Discord.DiscordBot;

public class PlayerLog {
    public PlayerLog(PlayerLoginEvent event) {
        DB db = new DB();
        db.registerPlayer(event.getPlayer().getUniqueId().toString(), event.getPlayer().getDisplayName());
        if (DiscordBot.online){
            RestChannel chann = DiscordBot.client.getChannelById(Snowflake.of("742005428228980828"));
            chann.createMessage(String.format("`%s vient de se connecter`", event.getPlayer().getDisplayName())).block();
        }
    }
}
