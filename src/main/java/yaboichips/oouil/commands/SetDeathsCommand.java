package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import yaboichips.oouil.Oouil;

public class SetDeathsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String name = args[0];
        int deaths = Integer.parseInt(args[1]);
        Oouil.playerDeathCount.put(name, deaths);
        sender.sendMessage(name + " is set to " + deaths + " death(s)");
        return true;
    }
}
