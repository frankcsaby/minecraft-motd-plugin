package frankcsaby.minecraft_motd;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;

public final class Minecraft_motd extends JavaPlugin implements  Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("WelcomePlugin has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("WelcomePlugin has been disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        // send a welcome message to the player
        event.getPlayer().sendMessage(ChatColor.GREEN + "Welcome to the server, " + event.getPlayer().getName() + "! If you want to keep your stuff in your inventory, please type /gamerule keepInventory true, in EVERY world. (Overworld, Nether, End!)");
    }
}
