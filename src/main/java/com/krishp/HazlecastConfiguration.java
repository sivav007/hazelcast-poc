package com.krishp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;

@Configuration
public class HazlecastConfiguration {

	@Bean
	public Config hazlecastConfig() {
		Config config = new Config();
		config.setInstanceName("hazlecast-instance");

		MapConfig mapConfig = new MapConfig();
		mapConfig.setName("configuration");
		// what does this mean?
		mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
		// ??
		mapConfig.setTimeToLiveSeconds(-1);

		MaxSizeConfig maxSizeConfig = new MaxSizeConfig();
		maxSizeConfig.setSize(200);
		// ??
		maxSizeConfig.setMaxSizePolicy(MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE);

		mapConfig.setMaxSizeConfig(maxSizeConfig);

		return config;
	}

}
