package fun.lykorisr.fiammetta;

import fun.lykorisr.fiammetta.bots.FiammettaBotsManager;
import fun.lykorisr.fiammetta.handlers.FiammettaEventManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FiammettaMain {
    public static void main(String[] args) {
        // TODO: 更改日志框架并统一

        FiammettaBotsManager.init();

        FiammettaEventManager.init();
    }
}
