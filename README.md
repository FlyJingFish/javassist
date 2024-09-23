[![Maven central](https://img.shields.io/maven-central/v/io.github.FlyJingFish/javassist)](https://central.sonatype.com/artifact/io.github.FlyJingFish/javassist/)
[![GitHub license](https://img.shields.io/github/license/FlyJingFish/AndroidAOPPlugin.svg)](https://github.com/FlyJingFish/javassist/blob/master/LICENSE)
## About

针对 https://github.com/jboss-javassist/javassist 做了关于jar包是否使用缓存的判断优化

通过设置当前项目的根目录来判断是否使用缓存
```java
JarUtils.INSTANCE.setRootProjectPath(projectPath);
```



