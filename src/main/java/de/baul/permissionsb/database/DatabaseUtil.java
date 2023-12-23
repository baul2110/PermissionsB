package de.baul.permissionsb.database;

import de.baul.permissionsb.PermissionsB;
import de.baul.permissionsb.group.Group;
import de.baul.permissionsb.group.GroupUtil;
import de.baul.permissionsb.language.Language;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DatabaseUtil {

  private String url;
  private String user;
  private String password;

  private Connection con;

  private final PermissionsB plugin = PermissionsB.getInstance();

  public DatabaseUtil() {
    loadConfig();
  }

  public boolean connect() {
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println(Language.getMessage("DB_SUCCESSFULLY_CONNECTED"));
      createTables();
      loadGroups();
      return true;
    } catch (SQLException e) {
      System.out.println(Language.getMessage("DB_CONNECT_ERROR"));
      plugin.getServer().getPluginManager().disablePlugin(plugin);
      return false;
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

  private void loadGroups() {
    try {
      Statement statement = con.createStatement();
      ResultSet groupSet = statement.executeQuery("SELECT DISTINCT group_name FROM permissions");
      while(groupSet.next()) {
        GroupUtil.groups.add(new Group(groupSet.getString("group_name")));
      }
      for(Group group : GroupUtil.groups) {
        ResultSet permissionSet = statement.executeQuery("SELECT permission FROM permissions WHERE group_name = " + group.getName());
        while (permissionSet.next()) {
          group.addPermission(permissionSet.getString("permission"));
        }
      }
    } catch (SQLException ignored) {

    }
  }

  private void createTables() {
    try {
      Statement statement = con.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS permissions(group_name VARCHAR(255) PRIMARY KEY, permission VARCHAR(255))");
      statement.execute("CREATE TABLE IF NOT EXISTS players(uuid VARCHAR(36) PRIMARY KEY, group_name VARCHAR(255))");
    } catch (SQLException ignored) {
    }
  }

  public void addPlayerToDatabase(Player player, Group group) {
    String uuid = player.getUniqueId().toString();
    String groupName = group.getName();
    try {
      Statement statement = con.createStatement();
      statement.execute("");
    } catch (SQLException ignored) {
    }
  }



}
