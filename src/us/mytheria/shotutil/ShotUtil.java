package us.mytheria.shotutil;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class ShotUtil extends JavaPlugin implements org.bukkit.event.Listener {

    private static ShotUtil instance;

    public static ShotUtil getInstance() {
        return instance;
    }

    public HashMap<String, Double> weapons = new HashMap<>();

    Listener listener;

    public void onEnable() {
        instance = this;
        File dir = new File(String.valueOf(this.getDataFolder()));
        if (!dir.exists()) {
            this.saveResource("config.yml", false);
        }
        loadWeapons();
        listener = new Listener();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(listener, this);

    }

    public void loadWeapons() {
        if (getConfig().getConfigurationSection("Weapons") != null) {
            ConfigurationSection weapons = getConfig().getConfigurationSection("Weapons");
            for (String weapon : weapons.getKeys(false)) {
                double damage = getConfig().getDouble("Weapons." + weapon);
                this.weapons.put(weapon, damage);
            }
        }
    }
}
