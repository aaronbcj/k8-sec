package com.aaronbcj.k8s;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController  {
	private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);
    
	
	@Autowired
	private ConfigKeys keys;
	
	@Autowired
	private Environment env;
	
	//@Scheduled(initialDelay = 3000, fixedRate = 15000)
	public void run() {
		System.out.println(getConfig());
	}
	
	@RequestMapping("/keys")
	private String collectKeys() {
		return getConfig();
	}
	
	private String getConfig()
	{
		String sysGetEnv = System.getenv().getOrDefault("secret1", "user");
		//String accessToken = System.getenv().getOrDefault("SECRETS_CRED_USER_ACCESS_TOKEN", "token");
		//String profile = System.getenv().getOrDefault("spring.profiles.active", "not-set");
		
		String response = String.format("secret1=%s, secret2=%s, secret3=%s, secret=%s, allkeys=%s, sys.getenv=%s, env.getsecret=%s, env.getallkeys=%s", 
				keys.getSecret1(), keys.getSecret2(), keys.getSecret3(),keys.getSecret(),keys.getAllkeys(),sysGetEnv, env.getProperty("secret"),env.getProperty("allkeys"));
		
		System.out.println(response);
		return response;
	}
}