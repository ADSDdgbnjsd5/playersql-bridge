package com.mengcraft.playersql.bridge;

import net.TheDgtl.Stargate.event.StargatePortalEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class StarGateHook implements Listener {

    private final Main main;

    public StarGateHook(Main main) {
        this.main = main;
    }
    
    @EventHandler
    public void handle(StargatePortalEvent event) {
        if (event.getDestination().isBungee()) {
            event.setCancelled(true);
            main.call(event.getPlayer(), 
                      event.getDestination().getDestinationName());
        }
    }

    public void register() {
        main.getServer().getPluginManager().registerEvents(this, main);
    }

}
