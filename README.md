# OpenJML Plugin for IntelliJ IDEA  
This Plugin provides the OpenJML/ESC to IntelliJ IDEA 2019.2. 

## Getting started

### Installation
Build the plugin using `./gradlew buildPlugin`. 
A zip containing the plugin is then located in `build/distributions/`
Use the intelliJ build-in plugin manager (Settings > Plugins) to install the plugin, by clicking the wheel, and select "Install Plugin from Disk".

### OpenJML Download
After you successfully installed the plugin you have to choose how you want to get the OpenJML commandline tool. There are two possibilities:
1. Download it from www.openjml.org
2. Use the build-in download option to download the latest release from the official openjml github repository

### Plugin Configuration
To use the plugin you have to configure it. Go to the intellij settings an choose the OpenJML tab. 
1. Set the path to the openjml commandline tool if you had downloaded it manually. Otherwise click the download button and choose a directory where to download the openjml commanline tool.
2. Choose a solver which is shipped with the commandline tool or set the path to a custom solver.

