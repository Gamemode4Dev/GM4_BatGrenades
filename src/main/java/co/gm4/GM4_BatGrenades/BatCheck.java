package co.gm4.GM4_BatGrenades;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.List;

/**
 * Project: GM4_BatGrenades
 * Author: Freelancer_Asul
 * Date: July 4, 2016
 * Website: http://www.freelancemedias.com
 */

class BatCheck extends BukkitRunnable{
    public void run() {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            List<org.bukkit.entity.Entity> near = p.getLocation().getWorld().getEntities();
            for(org.bukkit.entity.Entity e : near) {
                if(e.getType() == EntityType.BAT){
                    //WARNING
                    if(e.getLocation().distance(p.getLocation()) <= BatGrenades.getValue(0)){
                        e.getWorld().playSound(e.getLocation(),"entity.bat.ambient",0.3F,1);
                    }
                    //EXPLOSION
                    if(e.getLocation().distance(p.getLocation()) <= BatGrenades.getValue(1) && !e.isDead()){
                        Location removal = e.getLocation();
                        removal.setY(-400);
                        e.getWorld().createExplosion(e.getLocation().getX(),e.getLocation().getY(),e.getLocation().getZ(), BatGrenades.getValue(2),false,true);
                    }
                }
            }
        }
    }
}
