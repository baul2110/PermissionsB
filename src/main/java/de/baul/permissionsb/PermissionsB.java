package de.baul.permissionsb;

import org.bukkit.plugin.java.JavaPlugin;

public final class PermissionsB extends JavaPlugin {

  @Override
  public void onEnable() {
    System.out.println("Plugin v" + getDescription().getVersion() + " enabled!");

  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
