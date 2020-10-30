package xicraft.xicraft.Event.Player;

import discord4j.common.util.Snowflake;
import discord4j.rest.entity.RestChannel;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import xicraft.xicraft.Discord.DiscordBot;

public class PlayerCommand {
    public PlayerCommand(PlayerCommandPreprocessEvent event) {
        if (DiscordBot.online){
            RestChannel chann = DiscordBot.client.getChannelById(Snowflake.of("742005428228980828"));
            chann.createMessage(String.format("`[%s] %s`", event.getPlayer().getDisplayName(), event.getMessage())).block();
        }
    }
}
