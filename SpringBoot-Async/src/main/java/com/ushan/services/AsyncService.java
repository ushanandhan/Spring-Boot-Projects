package com.ushan.services;

import com.ushan.model.EmployeeAddresses;
import com.ushan.model.EmployeeNames;
import com.ushan.model.EmployeePhone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	private RestTemplate restTemplate;

	private static String hostUrl = "http://localhost:6060";

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException
	{
		log.info("getEmployeeName Starts");
		EmployeeNames employeeNameData = restTemplate.getForObject(hostUrl+"/names", EmployeeNames.class);

		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeeNameData completed");
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException
	{
		log.info("getEmployeeAddress Starts");
		EmployeeAddresses employeeAddressData = restTemplate.getForObject(hostUrl+"/addresses", EmployeeAddresses.class);

		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeeAddressData completed");
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException
	{
		log.info("getEmployeePhone Starts");
		EmployeePhone employeePhoneData = restTemplate.getForObject(hostUrl+"/phones", EmployeePhone.class);

		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(1000L);	//Intentional delay
		log.info("employeePhoneData completed");
		return CompletableFuture.completedFuture(employeePhoneData);
	}

}
