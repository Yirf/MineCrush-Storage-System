package gg.minecrush.minecrushstorage.Storage;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StorageClass extends ConfigFile {

    private final String subfolder;

    public StorageClass(String subfolder, String uuid) {
        super(subfolder, uuid);
        this.subfolder = subfolder;
    }

    public void setStorage(String key, String value) {
        get().set(key, value);
        save();
    }

    public String getStorage(String key) {
        return get().getString(key);
    }

    public void setList(String key, List<String> values) {
        get().set(key, values);
        save();
    }

    public void setListFromCommaSeparated(String key, String commaSeparatedValues) {
        List<String> values = Arrays.stream(commaSeparatedValues.split(", "))
                .map(String::trim)
                .collect(Collectors.toList());
        setList(key, values);
    }

    public void addValueToList(String key, String value) {
        List<String> currentList = getList(key);
        currentList.add(value);
        setList(key, currentList);
    }

    public void editValueInList(String key, String oldValue, String newValue) {
        List<String> currentList = getList(key);

        // Find the index of the oldValue in the list
        int index = currentList.indexOf(oldValue);

        if (index != -1) {
            // If the oldValue is found, edit the value at the found index
            currentList.set(index, newValue);
            setList(key, currentList);
        } else {
            // Handle the case where the oldValue is not found in the list
            System.out.println("Value not found in the list for editing.");
        }
    }

    public List<String> getList(String key) {
        return get().getStringList(key);
    }

    @Override
    public void onFirstLoad() {
        save();
    }
}
