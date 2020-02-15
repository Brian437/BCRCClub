/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package club.business;

import junit.framework.TestCase;

/**
 *
 * author Brian Chaves
 * April 8
 * Test page
 */
public class MemberTest extends TestCase {
    
    public MemberTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getFullName method, of class Member.
     */
    public void testGetFullName() {
        System.out.println("getFullName");
        Member instance = new Member();
        String expResult = "Brian Chaves";
        instance.setFullName(expResult);
        String result = instance.getFullName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEmailAddress method, of class Member.
     */
    
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Member instance = new Member();
        String expResult = "bchaves@email.com";
        instance.setEmailAddress(expResult);
        String result = instance.getEmailAddress();
        assertEquals(expResult, result);
    }


    /**
     * Test of getPhoneNumber method, of class Member.
     */
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Member instance = new Member();
        String expResult = "911";
        instance.setPhoneNumber(expResult);
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
    }


    /**
     * Test of getProgramName method, of class Member.
     */
    public void testGetProgramName() {
        System.out.println("getProgramName");
        Member instance = new Member();
        String expResult = "CPA";
        instance.setProgramName(expResult);
        String result = instance.getProgramName();
        assertEquals(expResult, result);
    }


    /**
     * Test of getYearLevel method, of class Member.
     */
    public void testGetYearLevel() {
        System.out.println("getYearLevel");
        Member instance = new Member();
        int expResult = 2;
        instance.setYearLevel(expResult);
        int result = instance.getYearLevel();
        assertEquals(expResult, result);
    }


    /**
     * Test of isValid method, of class Member.
     */
    public void testIsValidPositive() {
        System.out.println("isValid");
        Member instance = new Member();
        
        instance.setFullName("Brian Chaves");
        instance.setEmailAddress("bchaves@email.com");
        
        boolean expResult = true;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
    }
    
    //Checks if it's a failed test
    public void testIsValidNegative() {
        System.out.println("isValid");
        Member instance = new Member();
        
        instance.setFullName("");
        instance.setEmailAddress("");
        
        boolean expResult = false;;
        boolean result = instance.isValid();
        assertEquals(expResult, result);
        
        //Checks again with just the name filled
        instance.setFullName("Brian");
        result = instance.isValid();
        assertEquals(expResult, result);
        
        //Checks again with just the email filled
        instance.setFullName("");
        instance.setEmailAddress("Bchaves@email.com");
        result = instance.isValid();
        assertEquals(expResult, result);
    }
}
