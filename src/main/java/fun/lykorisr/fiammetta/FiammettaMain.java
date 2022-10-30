package fun.lykorisr.fiammetta;

import fun.lykorisr.fiammetta.bots.FiammettaBotsManager;
import fun.lykorisr.fiammetta.config.FiammettaConfig;
import lombok.extern.slf4j.Slf4j;
import net.mamoe.mirai.Bot;

@Slf4j
public class FiammettaMain {
    public static void main(String[] args) {
        FiammettaBotsManager.init();

    }
}
