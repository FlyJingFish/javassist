package javassist.util;

import java.util.HashSet;

public enum JarUtils {
    INSTANCE;

    private String rootProjectPath;
    private final HashSet<String> noCacheJarPaths = new HashSet<>();
    private JarJudgeType type = JarJudgeType.ROOT_PATH;

    public void setRootProjectPath(String rootProjectPath) {
        this.rootProjectPath = rootProjectPath;
    }

    public void addNoCacheJarPath(String jarPath){
        noCacheJarPaths.add(jarPath);
    }

    public void removeNoCacheJarPath(String jarPath){
        noCacheJarPaths.remove(jarPath);
    }

    public void clearNoCacheJarPaths(){
        noCacheJarPaths.clear();
    }

    public void setJarJudgeType(JarJudgeType type) {
        this.type = type;
    }

    public JarJudgeType getJarJudgeType() {
        return this.type;
    }

    public boolean isProjectJar(String filePath){
        if (type == JarJudgeType.JAR_PATHS){
            return filePath.endsWith(".jar") && noCacheJarPaths.contains(filePath);
        }else {
            return filePath.endsWith(".jar") && filePath.startsWith(rootProjectPath);
        }
    }
}
