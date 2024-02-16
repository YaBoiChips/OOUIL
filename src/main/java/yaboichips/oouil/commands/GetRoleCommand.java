package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class GetRoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Oouil.customTest.put(Oouil.custom, false);
        sender.getServer().dispatchCommand(sender.getServer().getConsoleSender(),
                "give " + sender.getName() + " written_book{pages:['[[\"You are \",{\"text\":\"THE DETECTIVE\",\"color\":\"aqua\"},\"\\\\n\\\\nGo get em Sherlock, solve the mystery deduce the whatever.\\\\n\\\\nBut Uh Oh your decision will result in peoples deaths.\\\\n\\\\nPeople die cause thats \",{\"text\":\"WHAT PEOPLE DO!\",\"color\":\"dark_red\",\"italic\":true,\"strikethrough\":true,\"bold\":true,\"underlined\":true}]]','[[\"If you report correct (/reportliar) the liar will die at the end of the session but if you don\\'t get it correct YOU DIE!\\\\n\\\\nBut thats the game Sherlock, the \",{\"text\":\"HUNT\",\"bold\":true,\"italic\":true,\"underlined\":true,\"strikethrough\":true,\"color\":\"dark_red\"},\" is afoot.\"]]'],title:Detective,author:NOMAD,generation:0}");
        return true;
    }
}
