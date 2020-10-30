package xicraft.xicraft.Discord;

import discord4j.core.GatewayDiscordClient;

public class EventHandler implements Runnable {
    public GatewayDiscordClient gateway;

    public EventHandler(GatewayDiscordClient _gateway) {
        this.gateway = _gateway;
    }

    public void run() {
        assert gateway != null;
        /*gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                assert channel != null;
                if (channel.getId().asString().equals("741964482280161281"))
                    channel.createMessage("Pong!").block();
            }
        });*/
        gateway.onDisconnect().block();
    }
}
