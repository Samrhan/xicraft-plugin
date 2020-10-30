package xicraft.xicraft;

import org.bukkit.plugin.java.JavaPlugin;
import xicraft.xicraft.Command.RegisterCommand;
import xicraft.xicraft.Discord.DiscordBot;
import xicraft.xicraft.Event.Handler;

import java.io.File;

public final class Xicraft extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Let's Go");
        new Handler(this);
        //  new DiscordBot("NTQ4NTcxNDIyMTY3OTI0NzU2.XHA-8w.G4VM2yeqMKbf6OL0t2ZiR3LZmgk").start();
        RegisterCommand.register(this);
        new FileWatcher(new File("/home/minecraft/server/whitelist.json")).start();
    }


    @Override
    public void onDisable() {
        getLogger().info("This is the End");
        DiscordBot.gateway.logout();
    }
}

