package co.gm4.GM4_BatGrenades;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;


/**
 * Project: GM4_BatGrenades
 * Author: Freelancer_Asul
 * Date: July 4, 2016
 * Website: http://www.freelancemedias.com
 */

@SuppressWarnings("deprecation")
public class BatGrenades extends JavaPlugin implements Listener{

    private static int DETECTION_RADIUS;
    private static int EXPLOSION_RADIUS;
    private static int SOUND_RADIUS;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        DETECTION_RADIUS = getConfig().getInt("detection-radius", 3);
        EXPLOSION_RADIUS = getConfig().getInt("explosion-radius", 1);
        SOUND_RADIUS = getConfig().getInt("sound-radius", 7);

        getLogger().log(Level.INFO, ChatColor.GREEN + "[BatGrenades] Module enabled!");

        Bukkit.getScheduler().runTaskTimer(this,new BatCheck(),0L,20L);
    }

    static int getValue(int value){
        switch(value) {
            case 1:
                return DETECTION_RADIUS;
            case 2:
                return EXPLOSION_RADIUS;
            default:
                return SOUND_RADIUS;
        }
    }

    /*
    This next part is to add the achievement [BatBoozled], which happens once the player dies from the bat.

    The only issue I have is how to detect whether they have the tag or not.
    Other, more advanced options include creating a yml file for each and every player that will store that player data.

    A really roundabout way that would probably work is to create a command block that tells it to add a tag if it is not present. like:

    |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
    ||| scoreboard players tag @p[name=SELECTEDPLAYER,tag=!GM4_BGachv] add GM4_BGachv |||
    |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    I can do that no problem, but it is not ideal.

    However I am open to suggestions.
    */
    /*@EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity().getLastDamageCause().getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION && e.getEntity().getKiller() == null && e.getEntity().getScoreboard().getObjective("GM4")){

        }
    }*/
}