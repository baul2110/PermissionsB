package de.baul.permissionsb.group;

import java.util.ArrayList;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

  ArrayList<GroupPlayer> players = new ArrayList<>();

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    //if player.hasGroup
    Player p = e.getPlayer();
    boolean newPlayer = true;
    for(GroupPlayer player : players) {
      if(p.getUniqueId().equals(player.player.getUniqueId())) {

      }
    }
  }

}
