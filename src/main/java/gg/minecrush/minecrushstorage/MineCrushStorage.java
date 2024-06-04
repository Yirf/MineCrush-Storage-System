package gg.minecrush.minecrushstorage;

import gg.minecrush.minecrushstorage.Commands.HeadCommand;
import gg.minecrush.minecrushstorage.Players.PlayerJoinListener;
import gg.minecrush.minecrushstorage.Storage.FolderCreator;
import gg.minecrush.minecrushstorage.Storage.StorageClass;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public final class MineCrushStorage extends JavaPlugin implements Listener {

    public static final Logger log = Bukkit.getLogger();

    public static final PluginManager pm = Bukkit.getPluginManager();

    public static MineCrushStorage instance;
    private StorageClass playerStorage;

    @Override
    public void onEnable() {
        instance = this;

        // Initialize StorageClass with the appropriate subfolder
        FolderCreator.createFolder("plugins/" + "MineCrushStorage/", "players");
        getCommand("gethead").setExecutor(new HeadCommand());

        // Initialize PlayerHeadSaver after initializing playerStorage

        // Register listeners
        pm.registerEvents(this, this);
        pm.registerEvents(new PlayerJoinListener(), this);
        initConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initConfig() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}