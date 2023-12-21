package de.baul.permissionsb.group;

import org.bukkit.entity.Player;

public class PlayerGroup {

  private Player player;

  private Group group;

  private Group defaultGroup;

  public PlayerGroup(Player player, Group defaultGroup) {
    this.player = player;
    this.defaultGroup = defaultGroup;
    this.group = defaultGroup;
  }

  public void setPermissions() {

  }

}
