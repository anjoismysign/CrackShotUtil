package us.mytheria.shotutil;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Damageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listener implements org.bukkit.event.Listener {

    ShotUtil main;

    public Listener(ShotUtil main) {
        this.main = main;
        ;
    }

    @EventHandler
    public void onDamage(WeaponDamageEntityEvent e) {
        if (!main.weapons.containsKey(e.getWeaponTitle())) {
            return;
        }
        e.setDamage(main.weapons.get(e.getWeaponTitle()));
    }

    @EventHandler
    public void test(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (e.getClickedBlock().getType() != Material.RED_BED) {
            return;
        }
        Bed bed = (Bed) e.getClickedBlock().getBlockData();
        e.getPlayer().sendMessage(bed.getFacing().toString());
    }

}
