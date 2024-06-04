package gg.minecrush.minecrushstorage.Players;

import gg.minecrush.minecrushstorage.Storage.Config;
import gg.minecrush.minecrushstorage.Storage.StorageClass;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (Config.Players.headSaver()) {
            Player player = event.getPlayer();
            String subfolder = "players"; // Replace with your desired subfolder name

            // Create an instance of StorageClass with the subfolder and player's UUID
            StorageClass storage = new StorageClass(subfolder, player.getUniqueId().toString());

            // Get the player's head texture
            ItemStack playerHead = getPlayerHead(player);

            // Set the head texture in the storage
            storage.setStorage("headtexture", playerHead.toString());
        }

        // You can now use the 'storage' object to access and modify the player's data
    }

    private ItemStack getPlayerHead(Player player) {
        ItemStack head = new ItemStack(org.bukkit.Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();

        // Set the head's owner to the player's name
        meta.setOwningPlayer(player);
        head.setItemMeta(meta);

        return head;
    }
}
