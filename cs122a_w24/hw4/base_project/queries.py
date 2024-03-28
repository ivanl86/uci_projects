import mysql.connector
from constants import Constants

class Queries(object):

    """example queries, to show how this framework work"""
    query0 = """
        SELECT 
            UCINetID 
        FROM 
            Users;
    """

    """find the titles of all courses offered in the 'Fall' quarter."""
    query1 = """
        SELECT
            Title
        FROM
            Courses
        WHERE
            Quarter = 'Fall';
    """

    """find all machine IDs and their locations where the operational status is busy"""
    query2 = """
        SELECT
            MachineID, Location
        FROM
            Machines
        WHERE
            OperationalStatus = 'busy';
    """

    """count the number of students enrolled in each course and return them in (CourseID, Title, number of enrollments), based on the projects they are doing."""
    query3 = """
        SELECT
            C.CourseID, C.Title, COUNT(DISTINCT S.StudentUCINetID) AS NumEnrollments
        FROM
            Projects P
        NATURAL JOIN
            StudentUseMachinesInProject S
        NATURAL JOIN
            Courses C
        GROUP BY
            C.CourseID, C.Title
    """

    """given a SoftwareID 8, list all machines (MachineID and IPAddress) that have this software installed."""
    query4 = """
        SELECT 
            MachineID,
            IPAddress
        FROM
            Machines
        NATURAL JOIN
            SoftwareOfProjectInstallOnMachine
        WHERE SoftwareID = 8;
    """

    """calculate the average duration of maintenance for each machine, return (MachineID, Average duration), sorted from highest to lowest"""
    query5 = """
        SELECT
            MachineID,
            AVG(Duration) AS AverageDuration
        FROM
            MaintenanceRecords
        GROUP BY
            MachineID
        ORDER BY
            AVG(Duration) DESC;
    """

    """find the course(s) (CourseID and Title) that has(have) the highest number of associated projects."""
    query6 = """
        SELECT
            CourseID, Title
        FROM
            Courses C
        NATURAL JOIN
            Projects P
        GROUP BY
            C.CourseID
        HAVING 
            COUNT( C.CourseID) >= ALL  ( SELECT
                                            COUNT(C2.CourseID)
                                        FROM
                                            Courses C2
                                        NATURAL JOIN
                                            Projects
                                        GROUP BY
                                            C2.CourseID);
    """

    """Identify students(StudentIDs) who have used machines with "busy" status and "idle" status at least once"""
    query7 = """
        SELECT
            S.UCINetID
        FROM
            Students S
        WHERE
            UCINetID IN (
                SELECT
                    B.StudentUCINetID
                FROM
                    StudentUseMachinesInProject B
                NATURAL JOIN
                    Machines
                WHERE
                    OperationalStatus = 'busy'
            ) AND UCINetID IN (
                SELECT
                    I.StudentUCINetID
                FROM
                    StudentUseMachinesInProject I
                NATURAL JOIN
                    Machines
                WHERE
                    OperationalStatus = 'idle');
    """