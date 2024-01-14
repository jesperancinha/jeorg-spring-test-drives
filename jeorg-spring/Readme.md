# jeorg-spring-5 - Spring 5 Java

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/jeorg-spring-test-drives)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%20Test%20Drives&color=informational)](https://github.com/jesperancinha/jeorg-spring-test-drives)
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/jeorg-spring-test-drives.svg)](#)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/9d14f60a58bd456fb1084860b5a46871)](https://www.codacy.com/gh/jesperancinha/jeorg-spring-test-drives/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/jeorg-spring-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/b9097b8c-40f8-48bf-beb3-2007803b4bad)](https://codebeat.co/projects/github-com-jesperancinha-jeorg-spring-test-drives-master)
[![CircleCI](https://circleci.com/gh/jesperancinha/jeorg-spring-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/jeorg-spring-test-drives)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/jeorg-spring-test-drives)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/jeorg-spring-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/jeorg-spring-test-drives)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/jeorg-spring-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/jeorg-spring-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/jeorg-spring-test-drives.svg)](#)

---
## Description

SPRING 5 study project.

This project is intended as a study tool for Spring version 5.

## Contents

1.  [jeorg-spring-app-old](./jeorg-spring-app-old) - 💾 Old applications present when this project started
2.  [jeorg-spring-topics](./jeorg-spring-topics) - 🗄 A set of Spring Boot applications exploring each relevant Spring topic per application
3.  [jeorg-spring-flash](./jeorg-spring-flash) - ⚡️ Fast track modules about Spring Boot 5
    1.  [jeorg-spring-flash-set-1](./jeorg-spring-flash/jeorg-spring-flash-set-1) - ⚡️ Fast track modules about Spring Boot 5 - Set 1 with 20 modules
    2.  [jeorg-spring-flash-set-2](./jeorg-spring-flash/jeorg-spring-flash-set-2) - ⚡️ Fast track modules about Spring Boot 5 - Set 2 with 20 modules
    3.  [jeorg-spring-flash-set-3](./jeorg-spring-flash/jeorg-spring-flash-set-3) - ⚡️ Fast track modules about Spring Boot 5 - Set 3 with 20 modules
    4.  [jeorg-spring-flash-set-4](./jeorg-spring-flash/jeorg-spring-flash-set-4) - ⚡️ Fast track modules about Spring Boot 5 - Set 4 with 4 modules
4.  [jeorg-spring-apps](./jeorg-spring-apps) - 💻 A set of applications for large topics
    1.  [jeorg-spring-app-1](./jeorg-spring-apps/jeorg-spring-app-1) - 🛳 - Cruise Ships (JDBC and persistence)
5.  [jeorg-spring-mastery](./jeorg-spring-mastery) - ⚔️ Mastery modules - Each module is a combination of different concepts of the Spring framework
    1.  [jeorg-spring-mastery-1](./jeorg-spring-mastery/jeorg-spring-mastery-1) - 🇫🇷 French Language in Music
    2.  [jeorg-spring-mastery-2](./jeorg-spring-mastery/jeorg-spring-mastery-2) - 🇵🇹 Portuguese Language in Music
6.  [jeorg-spring-action](./jeorg-spring-action) - 🥋 Action Modules - Detailed studies separated by topics with the goal to disambiguate nuances and complicated concepts of the Spring Framework

## Installation Notes

I'm using JDK version 11.0.9.hs-adpt for all of these tests.

```bash
sdk install java 11.0.9.hs-adpt
sdk use 11.0.9.hs-adpt 
```

Many of the modules are using JSP's. For this you need to have your running path right. If you run spring boot from the command line, you should not see any issue:

```bash
mvn clean install spring-boot:run
```

On the other hand, if running through an IDE, the root path must be specified. In IntelliJ as an example:

![alt img](./docs/workingdirectory.png)

## Resources

### Books

-   Cosmina, I. (11th December 2019). <i>Pivotal Certified Professional Core Spring 5 Developer Exam: A Study Guide Using Spring Framework 5</i>. (Second Edition). Apress
-   Sharma, R. (September 2018). <i>Hands-On Reactive Programming with Reactor</i>. (First Edition). Packt
-   Cosmina, I. Harrop, R. Schaefer, C. Ho, C. (October 2017). <i>Pro Spring 5 An In-Depth Guide to the Spring Framework and Its Tools</i>. (Fifth Edition). Apress
-   Winch, R. Mularien, P. (December 2012). <i>Spring Security 3.1</i>. (Second Edition). Packt Publishing
-   Kurniawan, B. Deck, P. (January 2015). <i>Servlet, JSP & Spring MVC</i>. (First Edition). Brainy Software
-   Long, J. (2020). <i>Reactive Spring</i>. (First Edition). Josh Long

### Online

-   [AOP Alliance (Java/J2EE AOP standards)](http://aopalliance.sourceforge.net/)
-   [Spring Framework Documentation 5.3.3](https://docs.spring.io/spring-framework/docs/5.3.3/reference/html/)
-   [VMware Spring Professional 2021 - EDU-1202](https://www.vmware.com/education-services/certification/vcp-spring.html)
-   [What’s new in Spring Framework 5](https://developer.ibm.com/languages/java/tutorials/j-whats-new-in-spring-framework-5-theedom)
-   [Spring Framework Overview](https://docs.spring.io/spring-framework/docs/5.1.18.RELEASE/spring-framework-reference/overview.html)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
