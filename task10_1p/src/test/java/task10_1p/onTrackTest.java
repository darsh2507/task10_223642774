package task10_1p;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class onTrackTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "223642774";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Darsh";
		Assert.assertNotNull("Student name is null", studentName);
	}
	
    @Test
    public void testTaskCreation() {
        Date dueDate = new Date();
        onTrack task = new onTrack(1, "Task1", dueDate);
        assertEquals("new", task.getStatus());
        assertEquals("", task.getFeedback());
       
    }

    @Test
    public void testSubmitTask() {
    	onTrack task = new onTrack(1, "Task1", new Date());
        task.submitTask();
        assertEquals("submitted", task.getStatus());
    }
//    @Test
//    public void testDaysRemaining() {
//        Date dueDate = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 5)); // 5 days from now
//        Task task = new Task(1, "Task1", dueDate);
//        int daysRemaining = task.getDaysRemaining();
//        assertEquals(5, daysRemaining);
//    }

    @Test
    public void testUpdateStatus() {
    	onTrack task = new onTrack(1, "Task1", new Date());
        task.updateStatus("in progress");
        assertEquals("in progress", task.getStatus());
    }

    @Test
    public void testAddFeedback() {
    	onTrack task = new onTrack(1, "Task1", new Date());
        task.addFeedback("Good job!");
        assertEquals("Good job!", task.getFeedback());
    }

   
    @Test
    public void testSendMessage() {
    	onTrack task = new onTrack(1, "Task1", new Date());
        task.sendMessage("Hello!");
        assertFalse(task.getChatHistory().isEmpty());
        assertTrue(task.getChatHistory().contains("Hello!"));
    }
//    @Test
//    public void testSendMessage() {
//    	onTrack task = new onTrack(1, "Task1", new Date());
//    task.sendMessage("Hello!");
//    assertFalse(task.getChatHistory().isEmpty());
//    assertEquals("Hello!", task.getChatHistory());
//    } 
    

    @Test
    public void testDaysRemaining() {
        long fiveDaysInMillis = TimeUnit.DAYS.toMillis(5);
        Date dueDate = new Date(System.currentTimeMillis() + fiveDaysInMillis);
        onTrack task = new onTrack(1, "Task1", dueDate);
        int daysRemaining = task.getDaysRemaining();
        assertEquals(5, daysRemaining);
    }

}
