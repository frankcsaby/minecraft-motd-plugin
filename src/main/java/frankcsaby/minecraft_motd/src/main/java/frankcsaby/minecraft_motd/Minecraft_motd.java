package frankcsaby.minecraft_motd;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;

public final class Minecraft_motd extends JavaPlugin implements  Listener{

    @Override
    public void onEnable() {

        saveDefaultConfig();
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
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Load the welcome message from config.yml
        String welcomeMessage = getConfig().getString("welcome-message", "Welcome to the server, {player}!");
        boolean broadcastToAll = getConfig().getBoolean("broadcast-to-all", false);

        // Replace {player} with the player's name
        welcomeMessage = welcomeMessage.replace("{player}", event.getPlayer().getName());

        // Translate color codes (e.g., &a -> green)
        welcomeMessage = ChatColor.translateAlternateColorCodes('&', welcomeMessage);

        // Send the message
        if (broadcastToAll) {
            // Broadcast to all players
            getServer().broadcastMessage(welcomeMessage);
        } else {
            // Send only to the joining player
            event.getPlayer().sendMessage(welcomeMessage);
        }
    }
}
