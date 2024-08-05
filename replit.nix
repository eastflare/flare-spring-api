{ pkgs }: {
    deps = [
      pkgs.jdk17_headless
      pkgs.gradle
      pkgs.jdk
    ];
}