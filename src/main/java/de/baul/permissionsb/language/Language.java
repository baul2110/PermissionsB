package de.baul.permissionsb.language;

public class Language {

  public final String LOAD_MESSAGE;

  public Language(String locale) {
    if(locale.equals("en")) {
      LOAD_MESSAGE = "Loading Plugin";
    } else if(locale.equals("de")) {
      LOAD_MESSAGE = "Lade Plugin";
    } else {
      LOAD_MESSAGE = "LOAD_MESSAGE";
    }
  }

}
