package yaboichips.oouil.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import yaboichips.oouil.Oouil;

public class EndSessionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Oouil.custom.damage(50);
        if (!Oouil.liarTest.get(Oouil.liar)) {
            Oouil.liar.damage(50);
            Oouil.accomplice.damage(50);
        } else {
            sender.getServer().getOnlinePlayers().forEach(player -> {
                player.playSound(player, Sound.AMBIENT_CAVE, 1, 1);
                player.sendTitle("Another Soul Collected", "don't let it be you", 30, 40, 30);
            });
        }
        return true;
    }
}
