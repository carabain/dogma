# dogma

Requirements:

JDK: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Maven: https://maven.apache.org/download.cgi
NodeJS: https://nodejs.org/en/download
Solidity: https://github.com/ethereum/solidity/releases

1) Add the directory of the solidity binary (solc.exe on Windows) to the PATH environment variable
2) Create an environment variable NODE_INSTALL_DIR which points tot the folder containing the "node" folder.
   e.g. set it to "C:\ws\apps" if the path to the node installation is "C:\ws\apps\node".
   (If you have a "nodejs" folder, rename it to "node". This is needed for the maven plugin to work correctly.)


Test