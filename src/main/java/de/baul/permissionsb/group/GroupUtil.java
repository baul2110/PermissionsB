package de.baul.permissionsb.group;

import java.util.ArrayList;

public class GroupUtil {

  public static ArrayList<Group> groups = new ArrayList<>();

  public static Group getGroup(String groupName) {
    for(Group group : groups) {
      if(group.getName().equalsIgnoreCase(groupName)) {
        return group;
      }
    }
    return null;
  }

}
