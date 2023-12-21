package de.baul.permissionsb.language;

import de.baul.permissionsb.PermissionsB;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Language {

  private static final Map<String, String> messages = new HashMap<>();

  public static String getMessage(String messageName) {
    return messages.getOrDefault(messageName, messageName);
  }

  public static void loadMessages(String locale) {
    File langFolder = new File(PermissionsB.getInstance().getDataFolder() + "/locales");
    File langFile = new File(langFolder, locale + ".yml");
    FileConfiguration lang = YamlConfiguration.loadConfiguration(langFile);
    for (String key : lang.getKeys(false)) {
      for (String messageName : Objects.requireNonNull(lang.getConfigurationSection(key)).getKeys(false)) {
        String message = lang.getString(key + "." + messageName);
        messages.put(messageName, message);
      }
    }
  }

}
