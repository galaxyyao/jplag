# JPlag Frontend Pack

JPlag通过不同的前置解析器（frontend），将输入的文件转换为token（令牌）流。这可以将源代码进行很大程度的抽象。
例如在Java前置解析器中，变量赋值会被转换成J_ASSIGN令牌，方法调用被转换为J_APPLY令牌。
而具体的运算、命名和注释会被忽略，只保留一定程度的程序结果，用来和其他源代码文件比对。

前置解析器包中，src/main/antlr目录中的.g和.g4文件（例如src/main/antlr/java.g）是ANTLR文件。
每种语言的语法定义在该文件中。在某些情况下，解析器也会给上述的token流添加token。可以搜索"parser.add("来找到相关代码。
token类型定义在`src/main/java/jplag/java/JavaToken.java`和`src/main/java/jplag/java/JavaTokenConstants.java`这两个文件中。

在通过简单的`mvn compile`命令编译源代码后，你可以调用jplag.java.Parser的主方法，并传递一个Java文件作为参数，来测试解析器：
```shell
java -cp "antlr.jar;build" jplag.java.Parser src/main/java/jplag/java/Parser.java
```
该命令会在屏幕的右侧列出src/main/java/jplag/java/Parser.java，并在屏幕左侧列出生成的token和他们的位置。

要创建一个新的前置解析器，你需要做如下事情：
- 生成ANTLR语法（注意ANTLR的各版本差异很大）
- 选择要生成的token
- 在...Token.java和...TokenConstants.java这两个文件中生命token类型
- 在`parser.add(...`中添加token
- 适配其他文件

除了ANTLR之外，Java1.5前置解析器使用的是另一种解析器JavaCC 3.2。