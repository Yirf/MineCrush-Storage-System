package gg.minecrush.minecrushstorage.Storage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

public abstract class Config {
    private static final String path = "config.";

    public static FileConfiguration get() {
        File file = new File("plugins/MineCrushStorage/config.yml");
        return (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }
    public static <T> T getOrDefault(T value, T def) {
        return value != null ? value : def;
    }

    public static class Players {

        public static Boolean headSaver() {
            return Config.get().getBoolean("players.saveheadtexture");
        }
    }

}
