package fun.lykorisr.fiammetta;

import fun.lykorisr.fiammetta.config.FiammettaConfigManager;
import fun.lykorisr.fiammetta.common.constants.FiammettaConfigConstants;

import java.util.Map;
import java.util.Optional;

public class Fiammetta {
    public static final class FiammettaConfigAPI {
        public static Map<String, Object> getConfig() {
            return FiammettaConfigManager.getAllConfig();
        }

        /**
         * 通过节点表达方式获取配置文件内容，参照 <b>{@link FiammettaConfigConstants}</b>
         *
         * @param <T>        配置内容的具体类型
         * @param configNode 配置文件的节点表示方法
         * @return 由 <b>{@link Optional}</b> 包装的配置内容
         */
        public static <T> Optional<T> getConfig(String configNode) {
            return FiammettaConfigManager.getConfig(configNode);
        }
    }
}
