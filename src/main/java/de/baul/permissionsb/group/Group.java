package de.baul.permissionsb.group;

import java.util.ArrayList;

public class Group {

  private final String name;
  private String prefix;
  private final ArrayList<String> permissions = new ArrayList<>();


  public boolean equals(Group group) {
    return name.equals(group.getName());
  }

  public Group(String name) {
    this.name = name;
    this.prefix = "[" + name + "]";
  }

  public void addPermission(String permission) {
    permissions.add(permission);
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getName() {
    return name;
  }

  public String getPrefix() {
    return prefix;
  }

  public ArrayList<String> getPermissions() {
    return permissions;
  }
}
