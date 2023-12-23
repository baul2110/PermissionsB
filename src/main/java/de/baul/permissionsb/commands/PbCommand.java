package de.baul.permissionsb.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PbCommand implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
    if(args.length == 2) {
      if(args[0].equalsIgnoreCase("delete")) {

      }
      if(args[0].equalsIgnoreCase("create")) {

      }
    }
    return false;
  }
}
