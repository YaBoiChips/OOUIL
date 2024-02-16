package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class ReportLiarCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player reported = sender.getServer().getPlayer(args[0]);
        if (reported == Oouil.liar){
            Oouil.customTest.put(Oouil.custom, true);
            sender.sendMessage(reported.getName() + " has been reported as Liar!");

        }
        System.out.println(reported.getName() + " is reported");
        return true;
    }
}
