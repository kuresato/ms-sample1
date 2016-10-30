# ms-sample1

ひな形をつくる
```
$ mvn archetype:generate -B \
     -DarchetypeGroupId=org.apache.maven.archetypes \
     -DarchetypeArtifactId=maven-archetype-quickstart \
     -DarchetypeVersion=1.1 \
     -DgroupId=samples \
     -DartifactId=sample1
     -Dversion=1.0-SNAPSHOT
     -Dpackage=sample1
```

pom.xmlを編集
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>samples</groupId>
  <artifactId>sample1</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>sample1</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <!-- 追加: ここから -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.0.2.RELEASE</version>
  </parent>
  <!-- 追加: ここまで -->

  <dependencies>

    <!-- 追加: ここから -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <!-- 追加: ここまで -->

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>
```

$ vi src/main/java/sample1/App.java

```java
package sample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class App
{
    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "Hello, Spring Boot!";
    }

    public static void main( String[] args )
    {
        System.out.println("starting...");
        SpringApplication.run(App.class, args);
    }
}
```

実行する
```
$ mvn spring-boot:run
```

Webブラウザでhttp://localhost:8080/ にアクセス


# OpenShiftでSpringBootアプリケーションを動かす

これを使うとOpenShift上でs2iしてSpringBootアプリを動かせる？

* How to deploy Spring Boot applications to OpenShift
  * https://blog.codecentric.de/en/2016/03/deploy-spring-boot-applications-openshift/

* STI builder image for building and running maven based Spring Boot applications
  * codecentric/springboot-maven3-centos
  * https://hub.docker.com/r/codecentric/springboot-maven3-centos/

