package yaboichips.oouil;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import yaboichips.oouil.commands.*;

import java.util.*;
import java.util.logging.Logger;

public final class Oouil extends JavaPlugin implements Listener {

    public static Map<String, Integer> playerDeathCount = new HashMap<>();

    public static Player liar;
    public static Player accomplice;
    public static Player doctor;
    public static Player custom;
    public static Player healed;

    public static List<Player> infected = new ArrayList<>();
    public static Map<Player, Boolean> liarTest = new HashMap<>();
    public static final Logger LOGGER = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getOnlinePlayers().forEach(player -> playerDeathCount.put(player.getName(), 0));
        this.getCommand("start").setExecutor(new StartSessionCommand());
        this.getCommand("end").setExecutor(new EndSessionCommand());
        this.getCommand("save").setExecutor(new SaveCommand());
        this.getCommand("report").setExecutor(new ReportCommand());
        this.getCommand("killed").setExecutor(new KilledCommand());
        this.getCommand("getrole").setExecutor(new GetRoleCommand());
        this.getCommand("setdeaths").setExecutor(new SetDeathsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerHit(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (player.hasPotionEffect(PotionEffectType.POISON)) {
                infected.add(player);
                System.out.println(player + " is infected");
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (event.getEntity().getKiller() == liar) {
            liarTest.put(liar, true);
        }
        Player player = event.getEntity();
        player.getServer().getOnlinePlayers().forEach(player2 ->
                player2.sendTitle(player.getName(), "HAS PERISHED!!!", 30, 40, 30));
        // Check if the player is already in adventure mode
        if (player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        player.getWorld().strikeLightningEffect(player.getLocation());
        player.getWorld().getPlayers().forEach(playerz -> playerz.playSound(playerz, Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1));
        // Increment death count for the player
        if (player != healed) {
            int deathCount = playerDeathCount.getOrDefault(player.getName(), 0) + 1;
            playerDeathCount.put(player.getName(), deathCount);
            if (deathCount >= 3) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("You have died 3 times and are now in Spectator mode.");
            }
        } else {
            healed = null;
        }
    }
}
