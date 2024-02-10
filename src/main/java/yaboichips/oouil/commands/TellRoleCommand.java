package yaboichips.oouil.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class TellRoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player)sender;

        if (sender == Oouil.liar)
        {
            player.sendTitle("LIAR", "Kill or be killed!", 30, 10, 30);
        }
        else if (sender == Oouil.accomplice)
        {
            player.sendTitle("ACCOMPLICE", "The LIAR is " + Oouil.liar.getName() + ". Make SURE they get a kill", 30, 40, 30);
        }
        else if (sender == Oouil.doctor)
        {
            player.sendTitle("DOCTOR", "Choose someone to SAVE with /save <name>!", 30, 40, 30);
        }
        else if (sender == Oouil.custom)
        {
            player.sendTitle("CUSTOM", "Do /getrole to get your roles information", 30, 10, 30);
        }
        else
        {
            player.sendTitle("TESTIFICATE", "Just play Minecraft and figure out who the Liar is", 30, 40, 30);
        }

        return true;
    }
}
