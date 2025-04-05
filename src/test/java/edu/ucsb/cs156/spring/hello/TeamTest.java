package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.beans.Transient;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_case1_returns_correct_state() {
        Team team2 = team;
        assertTrue(team.equals(team2), "Teams are not being recognized as the same");
    }

    @Test
    public void equals_case2_returns_correct_state() {
        int x = 5;
        assertFalse(team.equals(5), "Different objects are recognized as coming from the same class");
    }

    @Test
    public void equals_case3a_returns_correct_state() {
        Team team2 = new Team("test-team");
        assertTrue(team.equals(team2), "Teams with same name and members should be equal");
    }

    @Test
    public void equals_case3b_returns_correct_state() {
        Team team2 = new Team("test-team");
        team2.addMember("Alice");
        team2.addMember("Dave");
        assertFalse(team.equals(team2), "Should be false if only members differ");
    }

    @Test
    public void equals_case3c_returns_correct_state() {
        Team team2 = new Team("test-team2");
        assertFalse(team.equals(team2), "Should be false if only names differ");
    }

    @Test
    public void equals_case3d_returns_correct_state() {
        Team team2 = new Team("test-team2");
        team2.addMember("Alice");
        team2.addMember("Dave");
        assertFalse(team.equals(team2), "Should be false if both name and members differ");
    }

    @Test 
    public void equivalentmutation_check() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");
        int result = t.hashCode();
        int expectedResult = 68610;
        assertEquals(expectedResult, result);
    }

    @Test 
    public void hashcode_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

}
