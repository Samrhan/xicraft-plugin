package xicraft.xicraft.XiteEvent;

import discord4j.common.util.Snowflake;
import discord4j.discordjson.json.EmbedData;
import discord4j.discordjson.json.ImmutableEmbedData;
import discord4j.discordjson.json.ImmutableMessageEditRequest;
import discord4j.discordjson.json.MessageEditRequest;
import discord4j.rest.entity.RestMessage;
import xicraft.xicraft.DB;
import xicraft.xicraft.Discord.DiscordBot;

public class Leaderboard {
    private final static String msg_id = "742006494920179742";
    private final static String chan_id = "741964482280161281";

    public static void refresh() {
        DB db = new DB();
        Object[] ranks = db.getRanks();
        int n = 1; //position
        int i = 0; //incrément
        StringBuilder leaderboard_b = new StringBuilder();
        while (n <= 10) {
            if (ranks[i] != null) {
                leaderboard_b.append(String.format("**%d.** %s, *nombre d'émeraudes : %s*\n\n", n, ranks[i].toString().replace("\"", ""), ranks[i + 1].toString()));
            }
            n++;
            i += 2;
        }
        RestMessage msg = DiscordBot.client.getMessageById(Snowflake.of(chan_id), Snowflake.of(msg_id));
        ImmutableEmbedData.Builder embed_builder = EmbedData.builder();
        embed_builder.description(leaderboard_b.toString());
        embed_builder.title("Classement : Xité des émeraudes");
        ImmutableMessageEditRequest.Builder editbuilder = MessageEditRequest.builder();
        editbuilder.embed(embed_builder.build());
        editbuilder.content("");
        msg.edit(editbuilder.build()).block();
    }
}
