# Spring-test-drives

[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Spring%20Test%20Drives&color=informational)](https://github.com/jesperancinha/spring-test-drives) 
[![GitHub release](https://img.shields.io/github/release-pre/jesperancinha/spring-test-drives.svg)](#)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9d14f60a58bd456fb1084860b5a46871)](https://www.codacy.com/manual/jofisaes/spring-test-drives?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/spring-test-drives&amp;utm_campaign=Badge_Grade)
[![codebeat badge](https://codebeat.co/badges/b9097b8c-40f8-48bf-beb3-2007803b4bad)](https://codebeat.co/projects/github-com-jesperancinha-spring-test-drives-master)
[![CircleCI](https://circleci.com/gh/jesperancinha/spring-test-drives.svg?style=svg)](https://circleci.com/gh/jesperancinha/spring-test-drives)
[![Build Status](https://travis-ci.org/jesperancinha/spring-test-drives.svg?branch=master)](https://travis-ci.org/jesperancinha/spring-test-drives)
[![BCH compliance](https://bettercodehub.com/edge/badge/jesperancinha/spring-test-drives?branch=master)](https://bettercodehub.com/)
[![Build status](https://ci.appveyor.com/api/projects/status/wksvhmqaq0sd8505?svg=true)](https://ci.appveyor.com/project/jesperancinha/spring-test-drives)
[![Known Vulnerabilities](https://snyk.io/test/github/jesperancinha/spring-test-drives/badge.svg)](https://snyk.io/test/github/jesperancinha/spring-test-drives)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/spring-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/spring-test-drives.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/spring-test-drives.svg)](#)

---

## Description

SPRING study project.

This project is intended as a study tool for the latest Spring version. To find out the current version in study please check the details in the [pom.xml](pom.xml) file

## Contents:

2. spring-test-drives-hadoop - Tests for big data access
3. spring-test-drives-postgres - Tests for postgres access
4. spring-test-drivesvaadin-app - Tests for archetype web-app for vaadin (temporarily removed)
5. spring-test-drives-webpackage - Tests for the Java 8 API
6. spring-test-drives-postgres - Tests for PostgreSQL
8. spring-test-drives-webapp - Tests for Spring framework

## Hints and tricks

### Migration from Hamcrest to AssertJ

#### From equalTo() to isEqualTo()
```text
assertThat\(([0-9A-Za-z \(\)\. ã\ë"]*), equalTo\(([0-9A-Za-z .\(,\)\"_\\]*)\)\);
```
to
```text
assertThat($1).isEqualTo($2);
```

#### From nullValue() to isNull()
```text
assertThat\(([0-9A-Za-z \(\)\. ã\ë"]*), nullValue\(([0-9A-Za-z .\(,\)\"_\\]*)\)\);
```
to
```text
assertThat($1).isNull();
```

#### From hasSize() to hasSize()
```text
assertThat\(([0-9A-Za-z \(\)\. ã\ë"]*), hasSize\(([0-9A-Za-z .\(,\)\"_\\]*)\)\);
```
to
```text
assertThat($1).hasSize($2);
```

#### Imports from Junit assertThat to AssertJ assertThart

```text
import static org.junit.Assert.assertThat;
```
to
```text
import static org.assertj.core.api.Assertions.assertThat;
```
### Check dependency tree

Example:

> Question: Which libraries are using junit?

```text
mvn dependency:tree -Dverbose -Dincludes=junit
```

### Circel CI

-   [Using Environment Variables](https://circleci.com/docs/2.0/env-vars/)

## References:

* http://www.fitnesse.org/FrontPage

* https://cucumber.io/

* http://www.tutorialspoint.com/design_pattern/bridge_pattern.htm

## About me

[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social)](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social)](https://github.com/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=joaofilipesabinoesperancinha.nl&color=6495ED)](http://joaofilipesabinoesperancinha.nl)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=DEV&message=Profile&color=green)](https://dev.to/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Medium&message=@jofisaes&color=green)](https://medium.com/@jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Free%20Code%20Camp&message=jofisaes&color=008000)](https://www.freecodecamp.org/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Hackerrank&message=jofisaes&color=008000)](https://www.hackerrank.com/jofisaes)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Acclaim%20Badges&message=joao-esperancinha&color=red)](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Google%20Apps&message=Joao+Filipe+Sabino+Esperancinha&color=orange)](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Code%20Pen&message=jesperancinha&color=orange)](https://codepen.io/jesperancinha)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
