package com.example;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;

@RestController
public class TestController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value="/showDetails",method = RequestMethod.GET)
	public String showDetails()throws Exception
	{
		System.out.println("show details controller called");
		String ip=InetAddress.getLocalHost().toString();
		return "result-"+ip; 
	}
	
	
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	public String saveUser(@RequestBody User user)throws Exception
	{
		System.out.println("save user controller called");
		userService.saveUser(user);
		return "done"; 
	}
	
	@RequestMapping(value="/getAllUser",method = RequestMethod.POST)
	public List<User> getAllUser()
	{
		System.out.println("getAllUser controller called");
	    return userService.getAllUser();
		
	}
	
	/*
	 * @RequestMapping(value="/connectAwsS3",method = RequestMethod.GET) public
	 * String connectAwsS3() { AWSCredentials credentials = new BasicAWSCredentials(
	 * "AKIA47PGEWUTE7KW6MP3", "vFL4BUJ8GCT4SBOJGOm4lvOTptlaCR6/gPvxn8CY" );
	 * 
	 * AmazonS3 s3client = AmazonS3ClientBuilder .standard() .withCredentials(new
	 * AWSStaticCredentialsProvider(credentials)) .withRegion(Regions.EU_WEST_1)
	 * .build();
	 * 
	 * System.out.println("create bucket with name");
	 * 
	 * String bucketName = "prashant-java-bucket";
	 * 
	 * if(s3client.doesBucketExist(bucketName)) { System.out.
	 * println("Bucket name is not available.Try again with a different Bucket name."
	 * ); return null; }
	 * 
	 * s3client.createBucket(bucketName);
	 * 
	 * 
	 * System.out.println("List all buckets present in account");
	 * 
	 * List<Bucket> buckets = s3client.listBuckets();
	 * 
	 * for(Bucket bucket : buckets) {
	 * System.out.println("bucket:"+bucket.getName()); }
	 * 
	 * System.out.println("Add object data in the bucket");
	 * 
	 * s3client.putObject( bucketName, "dummy-document/employeeCopy.csv", new
	 * File("C:\\Users\\Janvi\\Desktop\\s3\\employee.csv") );
	 * 
	 * 
	 * System.out.println("List all available objects in S3 bucket");
	 * 
	 * ObjectListing objectListing = s3client.listObjects(bucketName);
	 * 
	 * for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
	 * System.out.println("object:"+os.getKey()); }
	 * 
	 * return "done";
	 * 
	 * }
	 */
}
