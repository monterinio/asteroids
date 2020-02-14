package org.monterinio.games.asteroids;

/**
 * This error comes from sun.launcher.LauncherHelper in the java.base module. The reason for this is
 * that the Main app extends Application and has a main method. If that is the case, the
 * LauncherHelper will check for the javafx.graphics module to be present as a named module. If that
 * module is not present, the launch is aborted.
 * <p>
 * <p>
 * For Maven the solution is exactly the same: provide a new main class that doesn't extend from
 * Application.
 */
class NewMain {

  public static void main(String[] args) {
    MainAsteroids.main(args);
  }

}
