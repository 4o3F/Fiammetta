package fun.lykorisr.fiammetta.bots;

import fun.lykorisr.fiammetta.Fiammetta;
import fun.lykorisr.fiammetta.common.constants.FiammettaConfigConstants;
import lombok.Getter;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.tomlj.TomlArray;

import java.util.ArrayList;

public class FiammettaBots {
    private static final FiammettaBots INSTANCES = new FiammettaBots();

    @Getter
    private ArrayList<Bot> bots = new ArrayList<>();

    private FiammettaBots() {
        TomlArray botConfigs = Fiammetta.FiammettaConfigAPI.<TomlArray>getConfig(FiammettaConfigConstants.BOTS).get();
        for (Integer i = 0; i < botConfigs.size(); i++) {
            Long accountID = botConfigs.getTable(i).getLong(FiammettaConfigConstants.BOTS_ACCOUNT_ID);
            String password = botConfigs.getTable(i).getString(FiammettaConfigConstants.BOTS_ACCOUNT_PASSWORD);
            Bot bot = BotFactory.INSTANCE.newBot(accountID, password, new BotConfiguration() {{
                fileBasedDeviceInfo(accountID.toString()+".json");
                enableContactCache();
                setProtocol(MiraiProtocol.ANDROID_PAD);
            }});
            bots.add(bot);
            bot.login();
        }
    }

    public static FiammettaBots getInstance() {
        return INSTANCES;
    }

}
