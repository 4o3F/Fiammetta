package fun.lykorisr.fiammetta.bots;

import lombok.Builder;
import lombok.Getter;
import net.mamoe.mirai.Bot;

import java.util.ArrayList;

@Builder
public class FiammettaBot {
    @Getter
    private ArrayList<Long> importantGroups;

    @Getter
    private Bot bot;

}
