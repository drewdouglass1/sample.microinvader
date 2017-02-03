Microinvader
============

To run (requires the Maven command line client):

1. Clone the GitHub repository: `git clone https://github.com/WASdev/sample.microinvaders.git`
2. `cd sample.microinvaders`
3. Run the Maven build: `mvn install`
4. `cd target/wlp/bin`
5. Start the Liberty server: `./server start microinvader`
6. Open a web browser at `http://localhost:9081/space-1.0/game.html`
7. Play.
8. To stop the Liberty server: `./server stop microinvader`

To run Microinvader from Eclipse (inc Maven plugin):

1. In Eclipse, switch to the Git perspective.
2. Click **Clone a Git repository** from the Git Repositories view.
3. Enter the URL `https://github.com/WASdev/sample.microinvaders.git`
4. Click **Next**, then click **Next** again, accepting the defaults.
5. Select **Import all existing Eclipse projects after clone finishes**, then click **Finish**.
7. Switch to the Java EE perspective. The `microinvaders` project is displayed in the Explorer view.
8. Right-click the **pom.xml** in the `microinvaders` project, then click **Run As... > Maven Build...**, then in the **Goals** field type `install liberty:start-server` and click **Run**. This builds and tests the application then starts the server running in the background.
9. Open the application in a browser: `http://localhost:9081/space-1.0/`. Follow the instructions to play the game.
10. To stop the server when you're finished, run the Maven build again with the `liberty:stop-server` goal.
