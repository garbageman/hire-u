package org.hireu.campus;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.hireu.campus.dao.CampusDaoImpl;
import org.hireu.campus.model.Campus;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.Map;

/**
 * This class will be an example class of how to use mockito and set up testing for services.
 * Since the data coming out of the database is variable, we can mock functionality services
 * so that we can check that the operations of the
 */
@RunWith(MockitoJUnitRunner.class)
public class CampusDaoImplTest {

    /* Here we are creating a mock of the JDBCTemplate that interfaces with the database */
    /* We do this because we want to fake the data coming from the database and keep it static */
    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /* Now that we have mocked the JDBCTemplate we now want to inject the mocks into the CampusDaoImpl */
    @InjectMocks
    private CampusDaoImpl testCampusDao;


    /**
     * This test checks if the JDBCTemplate is actually making a call to access the database.
     * The reason for these tests is to keep the data coming from the database the same, so we can
     * test what the dao is doing to the data between retrieval and display
     * In this case, the campusdao doesnt actually do anything to the data so theres nothing real to test
     */
    @Test
    public void testJDBCCall() {
        /* This is the test data that will be used to check the functionality of the getCampusFromUrl method */
        String url = "umd";

        Campus testCampus = new Campus("University of Maryland - College Park", "College Park", "MD");

        String sql = "select * from campus where url = :campus_url";

        Map<String, String> namedParameters = Collections.singletonMap("campus_url", url);

        /* Here we are stubbing out the result for the JDBCTemplate */
        /* Since we don't want to test with values coming from the db, we fake the data here */
        /* We use the any() notation on the RowMapper class because each instance of the rowmapper is unique */
        /* and we don't care about what rowmapper is being used since the whole call is being mocked */
        /* In order to use the any(), we must use eq() for all parameters that we actually want to verify are being used */
        when(namedParameterJdbcTemplate.queryForObject(eq(sql), eq(namedParameters), any(RowMapper.class))).thenReturn(new Campus("University of Maryland - College Park", "College Park", "MD"));

        /* Make the call to the method we are testing */
        Campus result = testCampusDao.getCampusFromUrl(url);

        /* Here we are verifying that our namedParameterJdbcTemplate actually executed the statement once */
        verify(namedParameterJdbcTemplate).queryForObject(eq(sql), eq(namedParameters), any(RowMapper.class));

        /* Assert that the values of the result are equal to that of the test */
        assertTrue(result != null);
        assertTrue(testCampus.getUniversity().equals(result.getUniversity()));
        assertTrue(testCampus.getState().equals(result.getState()));
        assertTrue(testCampus.getCity().equals(result.getCity()));
    }
}
