package fun.lykorisr.fiammetta.config;

import java.util.Map;
import java.util.Optional;

public class FiammettaConfigManager {
    @SuppressWarnings("unchecked")
    public static <T> Optional<T> getConfig(String configNode) {
        var optionalConfigNode = Optional.ofNullable(configNode);

        if (optionalConfigNode.isEmpty()) {
            return Optional.empty();
        }

        Object res = FiammettaConfig.getInstance().getConfigContent().get(configNode);

        return Optional.ofNullable((T) res);
    }

    public static Map<String, Object> getAllConfig() {
        return FiammettaConfig.getInstance().getConfigContent();
    }
}
