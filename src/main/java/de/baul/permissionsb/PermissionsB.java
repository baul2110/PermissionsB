package de.baul.permissionsb;

import de.baul.permissionsb.language.Language;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionsB extends JavaPlugin {

  private static PermissionsB instance;

  @Override
  public void onEnable() {
    instance = this;
    saveResource("config.yml", false); //erstellt config.yml file wenn noch nicht erstellt
    Language.loadMessages("en");
    System.out.println(Language.getMessage("TEST_TEXT_1"));
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public static PermissionsB getInstance() {
    return instance;
  }


}
