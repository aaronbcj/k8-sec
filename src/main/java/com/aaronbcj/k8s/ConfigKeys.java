
package com.aaronbcj.k8s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@ConfigurationProperties(prefix="")
@RefreshScope
public class ConfigKeys {

	@Value("${secret1.location:empty}")
	private String secret1;
	
	@Value("${secret2.location:empty}")
	private String secret2;
	
	@Value("${secret3.location:empty}")
	private String secret3;
	
	public String getSecret1() {
		return secret1;
	}

	public void setSecret1(String secret1) {
		this.secret1 = secret1;
	}
	
	public String getSecret2() {
		return secret2;
	}

	public void setSecret2(String secret2) {
		this.secret2 = secret2;
	}
	
	public String getSecret3() {
		return secret3;
	}

	public void setSecret3(String secret3) {
		this.secret3 = secret3;
	}
	
}
