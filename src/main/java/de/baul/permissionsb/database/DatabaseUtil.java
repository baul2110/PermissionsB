package de.baul.permissionsb.database;

import de.baul.permissionsb.PermissionsB;
import de.baul.permissionsb.language.Language;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class DatabaseUtil {

  private String url;
  private String user;
  private String password;

  private Connection con;

  private final PermissionsB plugin = PermissionsB.getInstance();

  public DatabaseUtil() {
    loadConfig();
  }

  public void connect() {
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println(Language.getMessage("DB_SUCCESSFULLY_CONNECTED"));
    } catch (SQLException e) {
      System.out.println(Language.getMessage("DB_CONNECT_ERROR"));
    }
  }

  public void disconnect() {
    try {
      try {
        con.close();
        System.out.println(Language.getMessage("DB_SUCCESSFULLY_DISCONNECTED"));
      } catch (SQLException e) {
        System.out.println(Language.getMessage("DB_DISCONNECT_ERROR"));
      }
    } catch (NullPointerException e) {
      System.out.println(Language.getMessage("DB_WAS_NOT_CONNECTED_ERROR"));
    }

  }

  private void loadConfig() {
    File dbFile = new File(plugin.getDataFolder() + "/database.yml");
    FileConfiguration dbConfiguration = YamlConfiguration.loadConfiguration(dbFile);
    this.url = "jdbc:mysql://" + dbConfiguration.getString("url") + "/" + dbConfiguration.getString("database");
    this.user = dbConfiguration.getString("username");
    this.password = dbConfiguration.getString("password");
  }

}
