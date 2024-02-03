package yaboichips.oouil.commands;

import org.bukkit.GameRule;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class StartSessionCommand implements CommandExecutor {

    public List<Player> players = new ArrayList<>();
    public Random rand = new Random();

    public StartSessionCommand() {
        super();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.getServer().getWorld("world").setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        Collection<? extends Player> onlinePlayers = sender.getServer().getOnlinePlayers();
        players.addAll(onlinePlayers);
        players.forEach(player -> player.playSound(player, Sound.ITEM_TOTEM_USE, 1, 1));
        Player custom = players.get(rand.nextInt(players.size()));
        Oouil.custom = custom;
        players.remove(custom);
        Player liar = players.get(rand.nextInt(players.size()));
        players.remove(liar);
        Player doctor = players.get(rand.nextInt(players.size()));
        players.remove(doctor);
        Oouil.doctor = doctor;
        Player accomplice = players.get(rand.nextInt(players.size()));
        players.remove(accomplice);
        Oouil.liar = liar;
        Oouil.accomplice = accomplice;
        liar.sendTitle("LIAR", "Kill or be killed!", 30, 10, 30);
        doctor.sendTitle("DOCTOR", "Choose someone to SAVE with /save <name>!", 30, 40, 30);
        accomplice.sendTitle("ACCOMPLICE", "The LIAR is " + liar.getName() + ". Make SURE they get a kill", 30, 40, 30);
        custom.sendTitle("CUSTOM", "Do /getrole to get your roles information", 30, 10, 30);
        players.forEach((player) -> player.sendTitle("TESTIFICATE", "Just play Minecraft and figure out who the Liar is", 30, 40, 30));
        Oouil.liarTest.clear();
        Oouil.liarTest.put(liar, false);
        players.clear();
        Oouil.LOGGER.info(Oouil.liar.getName() + "Is The LIAR");
        Oouil.LOGGER.info(Oouil.accomplice.getName() + "Is The ACCOMPLICE");
        Oouil.LOGGER.info(Oouil.doctor.getName() + "Is The DOCTOR");
        Oouil.LOGGER.info(Oouil.custom.getName() + "Is CUSTOM");
        return true;
    }
}
