package fun.lykorisr.fiammetta.handlers;

import fun.lykorisr.fiammetta.bots.FiammettaBot;
import fun.lykorisr.fiammetta.bots.FiammettaBots;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class FiammettaEventManager {
    public static void init() {
        System.out.println("Registering Event Handlers...");
        for (FiammettaBot bot : FiammettaBots.getInstance().getBots()) {
            FiammettaGroupHandler groupHandler = new FiammettaGroupHandler(bot);
            bot.getBot().getEventChannel().subscribeAlways(GroupMessageEvent.class,
                    groupHandler::handleEvent
            );
        }
    }
}
