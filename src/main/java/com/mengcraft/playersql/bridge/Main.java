package com.mengcraft.playersql.bridge;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

import com.mengcraft.playersql.api.PlayerPreSwitchServerEvent;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        if (checkPlugin("Stargate")) {
            hookMessage("Stargate");
            new StarGateHook(this).register();
        }
    }

    private void hookMessage(String line) {
        getLogger().info("Hook to " + line + ".");
    }

    private boolean checkPlugin(String line) {
        return getServer().getPluginManager().getPlugin(line) != null;
    }

    public void call(Player player, String target) {
        getServer().getPluginManager().callEvent(createEvent(player, target));
    }

    private Event createEvent(Player player, String target) {
        return new PlayerPreSwitchServerEvent(player, target);
    }

}
