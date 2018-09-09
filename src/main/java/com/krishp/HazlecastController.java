package com.krishp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.HazelcastInstance;

@RestController
@RequestMapping("/hazle")
public class HazlecastController {

	@Autowired
	private HazelcastInstance hazelcastInstance;

	@PostMapping("/write")
	public String write(@RequestParam("key") String key, @RequestParam("value") String value) {
		Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
		hazelcastMap.put(key, value);
		return "data-stored";
	}

	@GetMapping("/read")
	public String read(@RequestParam("key") String key) {
		Map<String, String> hazelcastMap = hazelcastInstance.getMap("my-map");
		return hazelcastMap.get(key);
	}

	@GetMapping("/read-all")
	public Map<String, String> readAll() {
		return hazelcastInstance.getMap("my-map");
	}

}
