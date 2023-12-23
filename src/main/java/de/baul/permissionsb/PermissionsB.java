package de.baul.permissionsb;

import de.baul.permissionsb.database.DatabaseUtil;
import de.baul.permissionsb.group.GroupPlayer;
import de.baul.permissionsb.language.Language;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;

public class PermissionsB extends JavaPlugin {

  private static PermissionsB instance;

  public static ArrayList<GroupPlayer> allPlayers = new ArrayList<>();

  private DatabaseUtil db;

  @Override
  public void onEnable() {
    instance = this;
    createResources();
    Language.loadMessages("en");
    db = new DatabaseUtil();
    if(!db.connect()) {
      return;
    }
    System.out.println(Language.getMessage("PLUGIN_ENABLED"));
  }

  @Override
  public void onDisable() {
    db.disconnect();

    System.out.println(Language.getMessage("PLUGIN_DISABLED"));
  }

  public static PermissionsB getInstance() {
    return instance;
  }

  public void createResources() {
    saveResource("config.yml", false);
    saveResource("database.yml", false);
    saveResource("locales/en.yml", true); //TODO: Change replace to false
  }

}
