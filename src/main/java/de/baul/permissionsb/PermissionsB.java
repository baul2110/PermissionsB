package de.baul.permissionsb;

import de.baul.permissionsb.language.Language;
import java.util.Objects;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionsB extends JavaPlugin {

  private static PermissionsB instance;

  public static Language text;

  @Override
  public void onEnable() {
    instance = this;
    saveResource("config.yml", false); //erstellt config.yml file wenn noch nicht erstellt
    loadLanguage();
    System.out.println(text.LOAD_MESSAGE);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public static PermissionsB getInstance() {
    return instance;
  }

  public void loadLanguage() {
    if(getConfig().get("language") != null) {
      text = new Language((String) Objects.requireNonNull(getConfig().get("language")));
    } else {
      text = new Language("");
    }
  }

}
