package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import yaboichips.oouil.Oouil;

public class KilledCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender == Oouil.liar) {
            Oouil.liarTest.put(Oouil.liar, true);
        }
        return true;
    }

}
