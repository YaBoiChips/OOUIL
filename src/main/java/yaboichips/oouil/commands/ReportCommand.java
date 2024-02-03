package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class ReportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player reported = sender.getServer().getPlayer(args[0]);
        if (reported == Oouil.accomplice){
            reported.damage(50);
            Oouil.liarTest.put(Oouil.liar, true);
            Oouil.accomplice = null;
        } else {
            if (sender instanceof Player){
                ((Player) sender).damage(50);
            }
        }
        return true;
    }
}
