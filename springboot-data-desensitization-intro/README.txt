E:.
│  pom.xml  - Maven构建工具的项目配置文件
│  数据脱敏.iml  - IntelliJ IDEA项目文件，保存了项目的设置和配置信息
│
└─src
├─main
│  ├─java
│  │  └─com
│  │      └─zhixi
│  │          │  SpringbootDataDesensitizationIntroApplication.java - 应用程序的入口类
│  │          │
│  │          ├─annotation
│  │          │      JsonDesensitization.java - 自定义注解，用于标记需要进行数据脱敏的字段
│  │          │
│  │          ├─controller
│  │          │      IndexController.java - Web应用程序的控制器类，处理HTTP请求和响应
│  │          │
│  │          ├─desensitizer
│  │          │  │  AbstractDesensitizer.java - 数据脱敏器的抽象基类
│  │          │  │  Desensitizer.java - 数据脱敏器接口
│  │          │  │
│  │          │  └─impl
│  │          │          DefaultDesensitizer.java - 默认的数据脱敏器实现类，用于处理除手机号和电子邮件以外的字段
│  │          │          EmailDesensitizer.java - 电子邮件地址数据脱敏器实现类
│  │          │          MobileDesensitizer.java - 手机号码数据脱敏器实现类
│  │          │
│  │          ├─entity
│  │          │      User.java - 实体类，用于保存用户信息
│  │          │
│  │          ├─enums
│  │          │      DesensitizationType.java  - 枚举类，定义了不同类型的数据脱敏方式
│  │          │
│  │          ├─exception
│  │          │      DesensitizationException.java - 异常类，用于在数据脱敏出现错误时抛出异常
│  │          │
│  │          └─support
│  │                  DesensitizerFactory.java  - 工厂类，用于创建不同类型的数据脱敏器
│  │                  JsonDesensitizationSerializer.java - 自定义序列化器，用于将数据脱敏后的对象转换为JSON格式
│  │
│  └─resources
│          application.properties
│
└─test
└─java
└─com
└─zhixi
SpringbootDataDesensitizationIntroApplicationTests.java