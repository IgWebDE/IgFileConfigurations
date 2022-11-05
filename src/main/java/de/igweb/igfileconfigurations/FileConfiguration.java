package de.igweb.igfileconfigurations;

import lombok.Getter;
import org.simpleyaml.configuration.file.YamlConfiguration;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@SuppressWarnings("unused")
public class FileConfiguration {

    private final FileSettings fileSettings;

    private final String path;

    private final Map<String, Object> values = new HashMap<>();

    public FileConfiguration() {
        this.fileSettings = getClass().getAnnotation(FileSettings.class);
        this.path = fileSettings.value();
        load();
    }

    public void load() {
        try {
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(path));
            yamlConfiguration.getKeys(true).forEach(key -> values.put(key, yamlConfiguration.get(key)));
            for (Field field : getClass().getDeclaredFields()) {
                if (field.trySetAccessible()) {
                    field.set(this, values.get(field.getName()));
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException("Failed to load configuration from " + path, exception);
        }
    }

    public void save() {
        try {
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new File(path));
            values.forEach(yamlConfiguration::set);
            for (Field field : getClass().getDeclaredFields()) {
                if (field.trySetAccessible()) {
                    yamlConfiguration.set(field.getName(), field.get(this));
                }
            }
            yamlConfiguration.save(new File(path));
        } catch (Exception exception) {
            throw new RuntimeException("Failed to save configuration to " + path, exception);
        }
    }

    public Object get(String key) {
        return values.get(key);
    }

    public void set(String key, Object value) {
        values.put(key, value);
    }

    public void removeByKey(String key) {
        values.remove(key);
    }

    public void removeByValue(Object value) {
        values.entrySet().removeIf(entry -> entry.getValue().equals(value));
    }

    public boolean containsKey(String key) {
        return values.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

}
