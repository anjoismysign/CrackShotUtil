package us.mytheria.shotutil;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.event.EventHandler;

public class Listener implements org.bukkit.event.Listener {

    ShotUtil main;

    public Listener() {
        this.main = ShotUtil.getInstance();
    }

    @EventHandler
    public void onDamage(WeaponDamageEntityEvent e) {
        if (!main.weapons.containsKey(e.getWeaponTitle())) {
            return;
        }
        e.setDamage(main.weapons.get(e.getWeaponTitle()));
    }

}
