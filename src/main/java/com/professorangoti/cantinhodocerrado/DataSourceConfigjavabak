package com.professorangoti.cantinhodocerrado;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DataSourceConfig {

	@Value("${JAWSDB_MARIA_URL}")
	private String dbUrl;

	@Bean
	@Primary
	public DataSource dataSource() throws URISyntaxException {
		URI uri = new URI(dbUrl);
		String username = uri.getUserInfo().split(":")[0];
		String password = uri.getUserInfo().split(":")[1];
		String url = "jdbc:mysql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();

		return DataSourceBuilder.create()
				.url(url)
				.username(username)
				.password(password)
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.build();
	}
}
