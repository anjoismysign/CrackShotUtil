package us.mytheria.shotutil;

import com.shampaggon.crackshot.CSUtility;
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

    public CSUtility csInstance;
    Listener listener;

    public void onEnable() {
        File dir = new File(String.valueOf(this.getDataFolder()));
        if (!dir.exists()) {
            this.saveResource("config.yml", false);
        }
        loadWeapons();
        listener = new Listener(this);
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(listener, this);

    }

    public void loadWeapons() {
        ConfigurationSection configurationSection = getConfig().getConfigurationSection("Weapons");
        for (String weapon : getConfig().getConfigurationSection("Weapons").getKeys(false)) {
            double damage = getConfig().getDouble("Weapons." + weapon);
            weapons.put(weapon, damage);
        }
    }
}
