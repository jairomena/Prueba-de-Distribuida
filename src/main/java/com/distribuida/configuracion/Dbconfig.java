package com.distribuida.configuracion;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jdbi.v3.core.Jdbi;

@ApplicationScoped
public class Dbconfig {
    public Jdbi init(){
        System.out.println("********post construct");
        Config config = ConfigProvider.getConfig();

        String user = config.getValue("db.user", String.class);
        String password = config.getValue("db.password", String.class);
        String url = config.getValue("db.url", String.class);
        String driver = config.getValue("db.driver", String.class);
        //pool de de conexiones
        HikariConfig pollConnection = new HikariConfig();
        pollConnection.setUsername(user);
        pollConnection.setPassword(password);
        pollConnection.setJdbcUrl(url);
        pollConnection.setDriverClassName(driver);
        Jdbi conectado = Jdbi.create(new HikariDataSource(pollConnection));
        return conectado;
    }
}
