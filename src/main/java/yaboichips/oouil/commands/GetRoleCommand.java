package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import yaboichips.oouil.Oouil;

public class GetRoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.getServer().dispatchCommand(sender.getServer().getConsoleSender(),
                "give " + sender.getName() + " written_book{pages:['[[\"TAG, You\\'re \",{\"text\":\"IT\",\"color\":\"dark_red\",\"underlined\":true,\"bold\":true},\"\\\\n\\\\nTag someone by the end of the session OR YOU DIE!\\\\n\\\\nIsn\\'t that a fun little twist?\\\\n\\\\nGood luck, Have fun, as the kids say!\"]]'],title:Tag,author:NOMAD,generation:0}");
        return true;
    }
}
