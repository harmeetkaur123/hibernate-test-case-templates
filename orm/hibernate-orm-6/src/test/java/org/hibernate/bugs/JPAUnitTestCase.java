package org.hibernate.bugs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This template demonstrates how to develop a test case for Hibernate ORM, using the Java Persistence API.
 */
public class JPAUnitTestCase {

	private EntityManagerFactory entityManagerFactory;

	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory( "templatePU" );
	}

	@After
	public void destroy() {
		entityManagerFactory.close();
	}

	// Entities are auto-discovered, so just add them anywhere on class-path
	// Add your tests, using standard JUnit.
	@Test
	public void hhh123Test() throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		// I have this customJson string for my Entity class
		String pdsProfile = "{\"id\":{\"pdsProfileId\":\"9ad8c4db-0697-48f0-9d5e-fee5fe8ac028\",\"supi\":\"imsi-450081000000001\",\"gpsi\":\"msisdn-81000000002\",\"other\":\"\"}," +
                "\"lastModifiedTime\":\"1671017441426\",\"lastAuditTime\":null,\"siteId\":\"site1\",\"pdsProfileData\":[{\"pdsUserId\":\"40289d96851064d2018511633e5a0000\",\"gpsi\":null," +
                "\"supi\":null,\"nai\":null,\"sySessionId\":null,\"sourceType\":5,\"subscriptionLevel\":\"::\",\"siteId\":\"site1\",\"lastModified\":\"1671017441425\"," +
                "\"lastAuditTime\":null,\"createdTimestamp\":null,\"subscriberValue\":\"{\\\"umCoalescedData\\\":{\\\"lastErrorcode\\\":null,\\\"umDataLimits\\\":{\\\"mk1\\\":" +
                "{\\\"lastErrorcode\\\":null,\\\"limitId\\\":\\\"mk1\\\",\\\"scopes\\\":{\\\"11-abc123\\\":{\\\"snssai\\\":{\\\"sst\\\":11,\\\"sd\\\":\\\"abc123\\\"},\\\"dnn\\\":" +
                "[\\\"dnn1\\\"]}},\\\"umLevel\\\":\\\"SESSION_LEVEL\\\",\\\"startDate\\\":\\\"2022-01-01T08:17:14.09Z\\\",\\\"endDate\\\":\\\"2023-11-05T08:17:14.09Z\\\",\\\"usageLimit\\\":" +
                "{\\\"duration\\\":123456,\\\"totalVolume\\\":90000,\\\"downlinkVolume\\\":40000,\\\"uplinkVolume\\\":50000},\\\"resetPeriod\\\":{\\\"period\\\":\\\"WEEKLY\\\",\\\"maxNumPeriod\\\":2}}}," +
                "\\\"umData\\\":null}}\",\"subscriptionInfo\":\"{\\\"umCoalescedData\\\":{\\\"dataSourceInfo\\\":{\\\"dataSourceId\\\":\\\"fe7d992b-0541-4c7d-ab84-555552222222:94d8d19a-b0d9-4d6d-994f-39a49ed5c111\\\"," +
                "\\\"host\\\":\\\"nf1stub.ragnar-ns.svc\\\",\\\"port\\\":8080},\\\"otherAttr\\\":{\\\"etag\\\":\\\"101\\\",\\\"processETag\\\":true}}}\",\"contextInfo\":\"" +
                "[{\\\"contextOwner\\\":\\\"UM\\\",\\\"contextId\\\":\\\"28395887-970c-412e-b1dd-57a808bd74a9\\\"}]\",\"pdsProfileId\":\"9ad8c4db-0697-48f0-9d5e-fee5fe8ac028\",\"isMigrated\":true,\"checksum\":null," +
                "\"exceptionalScenarioStatus\":null,\"revalidated\":true,\"version\":null},{\"pdsUserId\":\"40289d96851064d2018511633e5a0000\",\"gpsi\":null,\"supi\":null,\"nai\":null,\"sySessionId\":null,\"sourceType\":5," +
                "\"subscriptionLevel\":\"::\",\"siteId\":\"site1\",\"lastModified\":\"1671017441425\",\"lastAuditTime\":null,\"createdTimestamp\":null,\"subscriberValue\":\"{\\\"umCoalescedData\\\":{\\\"lastErrorcode\\\":null," +
                "\\\"umDataLimits\\\":{\\\"mk1\\\":{\\\"lastErrorcode\\\":null,\\\"limitId\\\":\\\"mk1\\\",\\\"scopes\\\":{\\\"11-abc123\\\":{\\\"snssai\\\":{\\\"sst\\\":11,\\\"sd\\\":\\\"abc123\\\"},\\\"dnn\\\":[\\\"dnn1\\\"]}}," +
                "\\\"umLevel\\\":\\\"SESSION_LEVEL\\\",\\\"startDate\\\":\\\"2022-01-01T08:17:14.09Z\\\",\\\"endDate\\\":\\\"2023-11-05T08:17:14.09Z\\\",\\\"usageLimit\\\":{\\\"duration\\\":123456,\\\"totalVolume\\\":90000," +
                "\\\"downlinkVolume\\\":40000,\\\"uplinkVolume\\\":50000},\\\"resetPeriod\\\":{\\\"period\\\":\\\"WEEKLY\\\",\\\"maxNumPeriod\\\":2}}},\\\"umData\\\":null}}\",\"subscriptionInfo\":\"{\\\"umCoalescedData\\\":" +
                "{\\\"dataSourceInfo\\\":{\\\"dataSourceId\\\":\\\"fe7d992b-0541-4c7d-ab84-555552222222:94d8d19a-b0d9-4d6d-994f-39a49ed5c111\\\",\\\"host\\\":\\\"nf1stub.ragnar-ns.svc\\\",\\\"port\\\":8080},\\\"otherAttr\\\":" +
                "{\\\"etag\\\":\\\"100\\\",\\\"processETag\\\":true}}}\",\"contextInfo\":\"[{\\\"contextOwner\\\":\\\"UM\\\",\\\"contextId\\\":\\\"28395887-970c-412e-b1dd-57a808bd74a9\\\"}]\"," +
                "\"pdsProfileId\":\"9ad8c4db-0697-48f0-9d5e-fee5fe8ac028\",\"isMigrated\":true,\"checksum\":null,\"exceptionalScenarioStatus\":null,\"revalidated\":false,\"version\":null}]}";

		// I am trying to perform an insert operation which involves above entity
		List<Pdsprofile> result = ReflectionTestUtils.invokeMethod(dbFlowTask, "insertDBOperation",
                userList, pdsProfile, workFLowRequestDto);

		//Following field is of type version
		@Version
    		private Integer version;

		//Since this is mockito, hence all operations are stateless hence I am not able to identify what value to pass for this above field. 
		//It was working with null value till Spring Boot 3.1.2. With spring 3.1.3, it is unable to process and throwing exception
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
