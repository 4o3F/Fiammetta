package fun.lykorisr.fiammetta.bots;

import fun.lykorisr.fiammetta.Fiammetta;
import fun.lykorisr.fiammetta.common.constants.FiammettaConfigConstants;
import lombok.Getter;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import org.tomlj.TomlArray;

import java.util.ArrayList;
import java.util.Objects;

public class FiammettaBots {
    private static final FiammettaBots INSTANCES = new FiammettaBots();

    @Getter
    private ArrayList<FiammettaBot> bots = new ArrayList<>();

    private FiammettaBots() {
        TomlArray botConfigs = Fiammetta.FiammettaConfigAPI.<TomlArray>getConfig(FiammettaConfigConstants.SYNC_BOTS).get();
        for (int i = 0; i < botConfigs.size(); i++) {
            Long accountID = botConfigs.getTable(i).getLong(FiammettaConfigConstants.ACCOUNT_ID);
            String password = botConfigs.getTable(i).getString(FiammettaConfigConstants.ACCOUNT_PASSWORD);
            Bot bot = BotFactory.INSTANCE.newBot(accountID, password, new BotConfiguration() {{
                fileBasedDeviceInfo(accountID.toString() + ".json");
                enableContactCache();
                setProtocol(MiraiProtocol.ANDROID_PAD);
            }});
            bot.login();

            TomlArray importantGroupsTomlArray = botConfigs.getTable(i).getArray(FiammettaConfigConstants.IMPORATANT_GROUP_ID);
            ArrayList<Long> importantGroups = new ArrayList<>();
            for (int j = 0; j < Objects.requireNonNull(importantGroupsTomlArray).size(); j++) {
                importantGroups.add(importantGroupsTomlArray.getLong(j));
            }

            FiammettaBot fiammettaBot = new FiammettaBot(importantGroups, bot);
            bots.add(fiammettaBot);
        }
    }

    private static void loginBots() {
        for (FiammettaBot bot : INSTANCES.bots) {
            bot.getBot().login();
        }
    }


    public static FiammettaBots getInstance() {
        return INSTANCES;
    }

}
