package fun.lykorisr.fiammetta.handlers;

import fun.lykorisr.fiammetta.bots.FiammettaBot;
import net.mamoe.mirai.event.events.GroupMessageEvent;

public class FiammettaGroupHandler {
    private FiammettaBot bot;
    public FiammettaGroupHandler(FiammettaBot bot) {
        this.bot = bot;
    }

    public void handleEvent(GroupMessageEvent event) {
        if (bot.getImportantGroups().contains(event.getGroup().getId())) {

        }
    }
}
