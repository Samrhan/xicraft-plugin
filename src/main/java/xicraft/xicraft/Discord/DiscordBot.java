package xicraft.xicraft.Discord;

import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

public final class DiscordBot extends Thread {
    public static DiscordClient client;
    public static GatewayDiscordClient gateway;
    public static boolean online = false;

    public DiscordBot(String token) {
        client = DiscordClient.create(token);
        gateway = client.login().block();
        assert gateway != null;
        online = true;
        new Thread(new EventHandler(gateway)).start();
    }
}