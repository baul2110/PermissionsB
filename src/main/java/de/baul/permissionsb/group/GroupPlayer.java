package de.baul.permissionsb.group;

import de.baul.permissionsb.PermissionsB;
import java.util.ArrayList;
import org.bukkit.entity.Player;

public class GroupPlayer {

  public final Player player;

  private Group group;

  private Group defaultGroup;

  private final PermissionsB plugin = PermissionsB.getInstance();

  public GroupPlayer(Player player, Group defaultGroup) {
    this.player = player;
    this.group = defaultGroup;

  }

  public void setPermissions() {
    ArrayList<String> permissions = group.getPermissions();
    for(String permission : permissions) {
      player.addAttachment(plugin).setPermission(permission, true);
    }
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public boolean removeGroup(Group group) {
    if(group.equals(this.group)) {
      this.group = defaultGroup;
      return true;
    }
    return false;
  }

}
