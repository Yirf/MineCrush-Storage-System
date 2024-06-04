package gg.minecrush.minecrushstorage.Commands;

import gg.minecrush.minecrushstorage.Utils.HeadUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;

import java.util.UUID;

public class HeadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage(ChatColor.RED + "Usage: /gethead <player-uuid>");
            return true;
        }

        try {
            UUID targetUUID = UUID.fromString(args[0]);
            ItemStack playerHead = HeadUtils.getPlayerHead(targetUUID);

            if (playerHead != null) {
                player.getInventory().addItem(playerHead);
                player.sendMessage(ChatColor.GREEN + "Player head added to your inventory!");
            } else {
                player.sendMessage(ChatColor.RED + "Unable to retrieve player head. Make sure the UUID is valid.");
            }
        } catch (IllegalArgumentException e) {
            player.sendMessage(ChatColor.RED + "Invalid UUID format. Please provide a valid player UUID.");
        }

        return true;
    }
}
