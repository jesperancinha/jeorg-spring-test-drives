## Hints & Tricks

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
