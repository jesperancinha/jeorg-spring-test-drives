open module spring.app.one.cruise {
    exports org.jesperancinha.std.app1.jdbc;
    requires persistence.api;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires jakarta.persistence;
}
