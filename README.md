[![Maven central](https://img.shields.io/maven-central/v/io.github.FlyJingFish.javassist/javassist)](https://central.sonatype.com/namespace/io.github.FlyJingFish.javassist)
[![GitHub license](https://img.shields.io/github/license/FlyJingFish/AndroidAOPPlugin.svg)](https://github.com/FlyJingFish/javassist/blob/master/LICENSE)
## About

针对 https://github.com/jboss-javassist/javassist 做了关于jar包是否使用缓存的判断优化，版本为 `3.30.2-GA`

### 通过设置当前项目的根目录来判断是否使用缓存
```java
// 设置为判断项目根目录
JarUtils.INSTANCE.setJarJudgeType(JarJudgeType.ROOT_PATH);
// 设置项目根目录
JarUtils.INSTANCE.setRootProjectPath(projectPath);
```

判断依据：

如果jar来自当前项目，大概率可能是自定义module产生的jar，那么就不可以使用缓存，否则可以使用缓存

### 通过设置忽略jar包路径来判断是否使用缓存
```java
// 设置为判断路径集
JarUtils.INSTANCE.setJarJudgeType(JarJudgeType.JAR_PATHS);
// 清空路径集
JarUtils.INSTANCE.clearNoCacheJarPaths();
// 添加一个jar包路径
JarUtils.INSTANCE.addNoCacheJarPath(ignoreJarPaths);
```
