package yaboichips.oouil.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class SaveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender == Oouil.doctor) {
            Player saved = sender.getServer().getPlayer(args[0]);
            Oouil.healed = saved;
            saved.playSound(saved, Sound.BLOCK_AMETHYST_BLOCK_CHIME, 1, 1);
            saved.sendTitle("You Have Been Saved", "You may rest easy today", 30, 40, 40);
            sender.sendMessage(saved.getName() + " has been saved!");
        }
        return true;
    }

}
