package hellmonky.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by yuanlai.xwt on 2017/5/27.
 */

@Path("Welcome")
public class Welcome {

    private String welcomeStr;

    public Welcome(){
        this.welcomeStr = "welcome to apsara stack proxy";
    }

    private void setContent(){
        this.welcomeStr = "          _____                            _____           _______                   _____ "
            + "                   _____                            _____                    _____                    "
            + "_____                    _____          \n"
            + "         /\\    \\                          /\\    \\         /::\\    \\                 /\\    \\   "
            + "               /\\    \\                          /\\    \\                  /\\    \\                "
            + "  /\\    \\                  /\\    \\         \n"
            + "        /::\\    \\                        /::\\____\\       /::::\\    \\               /::\\____\\  "
            + "              /::\\    \\                        /::\\____\\                /::\\    \\               "
            + " /::\\____\\                /::\\    \\        \n"
            + "        \\:::\\    \\                      /:::/    /      /::::::\\    \\             /:::/    /     "
            + "          /::::\\    \\                      /:::/    /               /::::\\    \\              "
            + "/::::|   |                \\:::\\    \\       \n"
            + "         \\:::\\    \\                    /:::/    /      /::::::::\\    \\           /:::/    /      "
            + "         /::::::\\    \\                    /:::/    /               /::::::\\    \\            "
            + "/:::::|   |                 \\:::\\    \\      \n"
            + "          \\:::\\    \\                  /:::/    /      /:::/~~\\:::\\    \\         /:::/    /      "
            + "         /:::/\\:::\\    \\                  /:::/    /               /:::/\\:::\\    \\          "
            + "/::::::|   |                  \\:::\\    \\     \n"
            + "           \\:::\\    \\                /:::/    /      /:::/    \\:::\\    \\       /:::/____/       "
            + "        /:::/__\\:::\\    \\                /:::/____/               /:::/__\\:::\\    \\        "
            + "/:::/|::|   |                   \\:::\\    \\    \n"
            + "           /::::\\    \\              /:::/    /      /:::/    / \\:::\\    \\      |::|    |         "
            + "      /::::\\   \\:::\\    \\              /::::\\    \\              /::::\\   \\:::\\    \\      "
            + "/:::/ |::|   |                   /::::\\    \\   \n"
            + "  ____    /::::::\\    \\            /:::/    /      /:::/____/   \\:::\\____\\     |::|    |     "
            + "_____    /::::::\\   \\:::\\    \\            /::::::\\____\\________    /::::::\\   \\:::\\    \\    "
            + "/:::/  |::|___|______    ____    /::::::\\    \\  \n"
            + " /\\   \\  /:::/\\:::\\    \\          /:::/    /      |:::|    |     |:::|    |    |::|    |    /\\  "
            + "  \\  /:::/\\:::\\   \\:::\\    \\          /:::/\\:::::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\  "
            + "/:::/   |::::::::\\    \\  /\\   \\  /:::/\\:::\\    \\ \n"
            + "/::\\   \\/:::/  \\:::\\____\\        /:::/____/       |:::|____|     |:::|    |    |::|    |   "
            + "/::\\____\\/:::/__\\:::\\   \\:::\\____\\        /:::/  |:::::::::::\\____\\/:::/  \\:::\\   "
            + "\\:::\\____\\/:::/    |:::::::::\\____\\/::\\   \\/:::/  \\:::\\____\\\n"
            + "\\:::\\  /:::/    \\::/    /        \\:::\\    \\        \\:::\\    \\   /:::/    /     |::|    |  "
            + "/:::/    /\\:::\\   \\:::\\   \\::/    /        \\::/   |::|~~~|~~~~~     \\::/    \\:::\\  /:::/    "
            + "/\\::/    / ~~~~~/:::/    /\\:::\\  /:::/    \\::/    /\n"
            + " \\:::\\/:::/    / \\/____/          \\:::\\    \\        \\:::\\    \\ /:::/    /      |::|    | "
            + "/:::/    /  \\:::\\   \\:::\\   \\/____/          \\/____|::|   |           \\/____/ \\:::\\/:::/    /"
            + "  \\/____/      /:::/    /  \\:::\\/:::/    / \\/____/ \n"
            + "  \\::::::/    /                    \\:::\\    \\        \\:::\\    /:::/    /       |::|____|/:::/   "
            + " /    \\:::\\   \\:::\\    \\                    |::|   |                    \\::::::/    /           "
            + "    /:::/    /    \\::::::/    /          \n"
            + "   \\::::/____/                      \\:::\\    \\        \\:::\\__/:::/    /        |:::::::::::/    "
            + "/      \\:::\\   \\:::\\____\\                   |::|   |                     \\::::/    /            "
            + "   /:::/    /      \\::::/____/           \n"
            + "    \\:::\\    \\                       \\:::\\    \\        \\::::::::/    /         "
            + "\\::::::::::/____/        \\:::\\   \\::/    /                   |::|   |                     /:::/   "
            + " /               /:::/    /        \\:::\\    \\           \n"
            + "     \\:::\\    \\                       \\:::\\    \\        \\::::::/    /           ~~~~~~~~~~     "
            + "          \\:::\\   \\/____/                    |::|   |                    /:::/    /               "
            + "/:::/    /          \\:::\\    \\          \n"
            + "      \\:::\\    \\                       \\:::\\    \\        \\::::/    /                           "
            + "           \\:::\\    \\                        |::|   |                   /:::/    /               "
            + "/:::/    /            \\:::\\    \\         \n"
            + "       \\:::\\____\\                       \\:::\\____\\        \\::/____/                            "
            + "            \\:::\\____\\                       \\::|   |                  /:::/    /               "
            + "/:::/    /              \\:::\\____\\        \n"
            + "        \\::/    /                        \\::/    /         ~~                                       "
            + "        \\::/    /                        \\:|   |                  \\::/    /                \\::/   "
            + " /                \\::/    /        \n"
            + "         \\/____/                          \\/____/                                                   "
            + "         \\/____/                          \\|___|                   \\/____/                  "
            + "\\/____/                  \\/____/         \n"
            + "                                                                                                      "
            + "                                                                                                      "
            + "                             ";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public String listPhysicalHost(@PathParam("name") String name) {
        if(null==name || name.equals("")){
            return this.welcomeStr;
        }else{
            setContent();
            return this.welcomeStr;
        }
    }
}