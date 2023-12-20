package de.baul.permissionsb.language;

import de.baul.permissionsb.PermissionsB;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
    if (!langFolder.exists()) {
      langFolder.mkdir();
    }
    File langFile = new File(langFolder, locale + ".yml");
    try {
      if (!langFile.exists()) {
        InputStream in = PermissionsB.getInstance().getResource("languages/" + locale + ".yml");
        Files.copy(in, langFile.toPath());
      }
    } catch (IOException expected) {
      System.out.println(" ");
    }
    FileConfiguration lang = YamlConfiguration.loadConfiguration(langFile);
    for (String key : lang.getKeys(false)) {
      for (String messageName : Objects.requireNonNull(lang.getConfigurationSection(key))
          .getKeys(false)) {
        String message = lang.getString(key + "." + messageName);
        System.out.println(messageName + ": " + message);
        messages.put(messageName, message);
      }
    }
  }

}
