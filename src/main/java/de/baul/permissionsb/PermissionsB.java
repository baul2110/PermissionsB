package de.baul.permissionsb;

import de.baul.permissionsb.database.DatabaseUtil;
import de.baul.permissionsb.language.Language;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionsB extends JavaPlugin {

  private static PermissionsB instance;

  private DatabaseUtil db;

  @Override
  public void onEnable() {
    instance = this;
    createResources();
    Language.loadMessages("en");
    System.out.println(Language.getMessage("TEST_TEXT_1"));
    db = new DatabaseUtil();
    db.connect();
  }

  @Override
  public void onDisable() {
    db.disconnect();
  }

  public static PermissionsB getInstance() {
    return instance;
  }

  public void createResources() {
    saveResource("config.yml", false);
    saveResource("database.yml", false);
    saveResource("locales/en.yml", true);
  }

}
