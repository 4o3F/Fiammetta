package fun.lykorisr.fiammetta.common.utils;

import fun.lykorisr.fiammetta.common.constants.FiammettaMiscConstants;

import java.nio.file.Path;

public class FiammettaWorkSpaceUtils {
    public static String getWorkingDir() {
        var workingDir = System.getenv().get(FiammettaMiscConstants.ENV_WORKING_DIR);
        return workingDir == null || workingDir.isEmpty() ? System.getProperty("user.dir") : workingDir;
    }
    public static String fixPath(String path) {
        return Path.of(path).isAbsolute() ? path : FiammettaWorkSpaceUtils.getWorkingDir() + path;
    }
}
