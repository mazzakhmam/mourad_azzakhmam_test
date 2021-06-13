package com.nakisa.leasing.libraryScripts;

public class CheckStrings {

  public class VersionString implements Comparable<VersionString> {

    private String version;

    // getter
    public String get() {
      return this.version;
    }

    // Constructor
    public VersionString(String version) {
      if (version == null)
        throw new IllegalArgumentException("Version can not be null");
      // checking the conformity of the new entred string version
      if (!version.matches("[0-9]+(\\.[0-9]+)*"))
        throw new IllegalArgumentException("Invalid version format");
      this.version = version;
    }

    // comparing both version : the existing one with the seconde one
    @Override
    public int compareTo(VersionString secondVersion) {
      if (secondVersion == null)
        return 1;
      //spliting the strings based on .
      String[] firstVersionArray = this.get().split("\\.");
      String[] secondVersionArray = secondVersion.get().split("\\.");
      int length = Math.max(firstVersionArray.length, secondVersionArray.length);
      for (int i = 0; i < length; i++) {
        int firstPart = i < firstVersionArray.length ? Integer.parseInt(firstVersionArray[i]) : 0;
        int secondPart = i < secondVersionArray.length ? Integer.parseInt(secondVersionArray[i]) : 0;
        if (firstPart < secondPart) {
          System.out.println("second string is greater than the first one ");
          return -1;
        }
        if (firstPart > secondPart) {
          System.out.println("first string is greater than the second one ");
          return 1;
        }
      }
      System.out.println("first and second string are equal");
      return 0;
    }

    @Override
    public boolean equals(Object secondVersion) {
      if (this == secondVersion)
        return true;
      if (secondVersion == null)
        return false;
      if (this.getClass() != secondVersion.getClass())
        return false;
      return this.compareTo((VersionString) secondVersion) == 0;
    }

  }

  public static void main(String[] args) {

    CheckStrings checkStrings = new CheckStrings();

    VersionString first = checkStrings.new VersionString("1.5");
    VersionString second = checkStrings.new VersionString("1.0.2");

    first.compareTo(second);
  }



}
