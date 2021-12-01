package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import static org.junit.Assert.*;

import javax.swing.text.Position;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence")
        );

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }


    @Test
    public void testJobsForEquality(){
        Job job1 = new Job(
                "QA analyst",
                new Employer("Vanguard"),
                new Location("Philadelphia"),
                new PositionType("Quality control"),
                new CoreCompetency("Unit testing")
        );

        Job job2 = new Job(
                "QA analyst",
                new Employer("Vanguard"),
                new Location("Philadelphia"),
                new PositionType("Quality control"),
                new CoreCompetency("Unit testing")
        );
        assertFalse(job1.equals(job2));
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job(
                "Junior Web developer",
                new Employer("Catalyst"),
                new Location("Baltimore"),
                new PositionType("Dev"),
                new CoreCompetency("HTML")
        );

        assertEquals('\n',
                job.toString().charAt(0));
        assertEquals('\n',
                job.toString().charAt(job.toString().length()-1));

    }


    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job(
                "Web developer",
                new Employer("Catalyst"),
                new Location("Baltimore"),
                new PositionType("Dev"),
                new CoreCompetency("JavaScript")
        );

        assertEquals("\nID: " + job.getId() +
                "\nName: Web developer" +
                "\nEmployer: Catalyst" +
                "\nLocation: Baltimore" +
                "\nPosition Type: Dev" +
                "\nCore Competency: JavaScript" +
                "\n", job.toString()
        );
    }


    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job(
                "Web developer II",
                new Employer("Catalyst"),
                new Location(""),
                new PositionType("Dev"),
                new CoreCompetency("")
        );

        String strDataNotAvailable = "Data not available";
        assertEquals(
                "\nID: " + job.getId() +
                        "\nName: Web developer II" +
                        "\nEmployer: Catalyst" +
                        "\nLocation: " + strDataNotAvailable +
                        "\nPosition Type: Dev" +
                        "\nCore Competency: " + strDataNotAvailable +
                        "\n", job.toString()
        );
    }


    @Test
    public void testToStringHandlesJobObjectOnlyContainsDataForID(){
        Job job = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency("")

        );

        String strDataDoesNotExist = "OOPS! This job does not seem to exist.";
        assertEquals(strDataDoesNotExist, job.toString());
    }
}
