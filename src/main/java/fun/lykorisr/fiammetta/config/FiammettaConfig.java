package fun.lykorisr.fiammetta.config;

import fun.lykorisr.fiammetta.common.utils.FiammettaWorkSpaceUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.tomlj.Toml;
import org.tomlj.TomlParseResult;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class FiammettaConfig {
    private static final FiammettaConfig Instance = new FiammettaConfig();

    @Getter
    @Setter
    private Map<String, Object> configContent = new HashMap<>();

    private FiammettaConfig() {
        File katConfigFile = new File(FiammettaWorkSpaceUtils.fixPath("./config.toml"));
        try {
            // 检测配置文件状态并处理
            if (katConfigFile.exists()) {
                InputStream inputStream = new FileInputStream(katConfigFile);
                TomlParseResult toml = Toml.parse(inputStream);
                for (Map.Entry<String, Object> entry : toml.dottedEntrySet()) {
                    configContent.put(entry.getKey(), entry.getValue());
                }
                inputStream.close();

            } else {
                if (katConfigFile.createNewFile()) {
                    OutputStream outputStream = new FileOutputStream(katConfigFile);
                    outputStream.write(Objects.requireNonNull(FiammettaConfig.class.getClassLoader().getResourceAsStream("config.toml")).readAllBytes());
                    outputStream.flush();
                    outputStream.close();
                    InputStream inputStream = new FileInputStream(katConfigFile);
                    TomlParseResult toml = Toml.parse(inputStream);
                    for (Map.Entry<String, Object> entry : toml.dottedEntrySet()) {
                        configContent.put(entry.getKey(), entry.getValue());
                    }
                    inputStream.close();

                } else {
                    log.error("Unable to write config file!");
                }
            }

        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
    }

    public static FiammettaConfig getInstance() {
        return Instance;
    }

}
