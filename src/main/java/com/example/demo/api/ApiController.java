package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MetricsDto;
import com.example.demo.service.ProcessFile;

@RestController
@RequestMapping("/apidemo")
public class ApiController {

	@Autowired
    private ProcessFile processFile;
	
	@RequestMapping(value = "/{date}", method = RequestMethod.GET)
	public ResponseEntity<String> getDate(@PathVariable("date") final String date) {

		try {
			if(processFile.readFile(date)) {
				return new ResponseEntity<>("File read correctly", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/metrics", method = RequestMethod.GET)
	public ResponseEntity<MetricsDto> metrics() {

		try {
			MetricsDto metricsDto = processFile.getMetricsDto();
			if(metricsDto != null) {
				return new ResponseEntity<>(metricsDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
