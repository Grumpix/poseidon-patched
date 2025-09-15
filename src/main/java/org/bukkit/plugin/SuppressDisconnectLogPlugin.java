package org.bukkit.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SuppressDisconnectLogPlugin extends JavaPlugin implements Listener {
    @Override
    public void onDisable() {
        // Není potřeba žádná akce při vypnutí
    }
    @Override
    public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
    System.out.println("[SuppressDisconnectLogPlugin] Plugin byl úspěšně načten a je aktivní.");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(""); // Potlačí zprávu o odpojení
    }

    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
        event.setLeaveMessage(""); // Potlačí zprávu o kicknutí
    }
}
