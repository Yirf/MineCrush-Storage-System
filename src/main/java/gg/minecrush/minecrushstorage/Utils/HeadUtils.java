package gg.minecrush.minecrushstorage.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class HeadUtils {

    public static ItemStack getPlayerHead(UUID playerUUID) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) head.getItemMeta();

        OfflinePlayer offlinePlayer = getOfflinePlayer(playerUUID);
        if (offlinePlayer != null) {
            meta.setOwningPlayer(offlinePlayer);
            head.setItemMeta(meta);
        }

        return head;
    }

    private static OfflinePlayer getOfflinePlayer(UUID playerUUID) {
        return Bukkit.getOfflinePlayer(playerUUID);
    }
}
