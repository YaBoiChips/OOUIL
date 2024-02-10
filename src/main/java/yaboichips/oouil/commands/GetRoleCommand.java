package yaboichips.oouil.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import yaboichips.oouil.Oouil;

public class GetRoleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Oouil.infected.add(Oouil.custom);
        sender.getServer().dispatchCommand(sender.getServer().getConsoleSender(),
                "give " + sender.getName() + " written_book{pages:['[[\"You are \",{\"text\":\"INFECTED!\",\"color\":\"dark_green\"},\"\\\\nYou are going to DIE by the end of the session UNLESS you infect more people by shooting them with the provided arrows.\\\\nOne person will die from the infection the more people you infect the less your chance of dying.\\\\nDid I mention you only get 10 shots? \",{\"text\":\"GOOD LUCK!\",\"italic\":true,\"underlined\":true,\"strikethrough\":true,\"color\":\"dark_red\"}]]'],title:Infected,author:NOMAD,generation:0}");
        sender.getServer().dispatchCommand(sender.getServer().getConsoleSender(),
                "give " + sender.getName() + " tipped_arrow{CustomPotionColor:8439583,CustomPotionEffects:[{Id:19,Duration:80,Amplifier:1,ShowParticles:0b,ShowIcon:0b}]} 10");
        return true;
    }
}
