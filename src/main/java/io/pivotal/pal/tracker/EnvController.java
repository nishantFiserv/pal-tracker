package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

	private String port;
	private String memoryLimit;
	private String cfInstanceIndex;
	private String cfInstanceAddress;	public EnvController(
	        @Value("${port:NOT SET}") String port,
	        @Value("${memory.limit:NOT SET}") String memoryLimit,
	        @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
	        @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress
	    ) {
	        this.port = port;
	        this.memoryLimit = memoryLimit;
	        this.cfInstanceIndex = cfInstanceIndex;
	        this.cfInstanceAddress = cfInstanceAddress;
	    }
	@RequestMapping("/env")
	public Map<String, String> envVars() {
		Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddress);

        return env;
		
	}
}
