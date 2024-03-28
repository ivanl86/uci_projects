import csv
import mysql.connector

from db_config import DB


def import_data(db: mysql.connector.connection_cext, folder_name: str) -> str:
    with db.cursor() as cursor:
        cursor.execute("""
            CREATE DATABASE IF NOT EXISTS %s;
        """ % (DB.config.get('database')))  # Create database

        cursor.execute("""
            USE %s;
        """ % (DB.config.get('database')))

        cursor.execute("SET FOREIGN_KEY_CHECKS = 0;")

        for name in DB.TABLES:  # Drop all tables
            cursor.execute("DROP TABLE IF EXISTS %s" % name)

        cursor.execute("SET FOREIGN_KEY_CHECKS = 0")

        for table in DB.TABLES.values():  # Create tables
            cursor.execute(table)

        counts: list[str] = []

        # Insert data into user table from csv file
        cursor.executemany("""
            INSERT INTO
            users (UCINetID, first_name, middle_name, last_name)
            VALUES(%s, %s, %s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='users.csv'))

        counts.append(str(cursor.rowcount))  # Counts the number of rows in users

        # # Insert data into emails table from csv file
        cursor.executemany("""
            INSERT INTO
            emails (UCINetID, email)
            VALUES(%s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='emails.csv'))

        # Insert data into students table from csv file
        cursor.executemany("""
            INSERT INTO
            students (UCINetID)
            VALUES(%s);
        """, get_csv_data(folder_name=folder_name, csv_name='students.csv'))

        # Insert data into admins table from csv file
        cursor.executemany("""
            INSERT INTO
            admins (UCINetID)
            VALUES(%s);
        """, get_csv_data(folder_name=folder_name, csv_name='admins.csv'))

        # Insert data into courses table from csv file
        cursor.executemany("""
            INSERT INTO
            courses (course_id, title, quarter)
            VALUES(%s, %s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='courses.csv'))

        counts.append(str(cursor.rowcount))  # counts the number of rows in courses

        # Insert data into projects table from csv file
        cursor.executemany("""
            INSERT INTO
            projects (project_id, name, description, course_id)
            VALUES(%s, %s, %s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='projects.csv'))

        # Insert data into machines table from csv file
        cursor.executemany("""
            INSERT INTO
            machines (machine_id, hostname, ip_address, operation_status, location)
            VALUES(%s, %s, %s, %s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='machines.csv'))

        counts.insert(1, str(cursor.rowcount))  # counts the number of rows in machines

        # Insert data into uses table from csv file
        cursor.executemany("""
            INSERT INTO
                uses (project_id, UCINetID, machine_id, start_date, end_date)
                VALUES (%s, %s, %s, DATE(%s), DATE(%s));
        """, get_csv_data(folder_name=folder_name, csv_name='use.csv'))

        # Insert data into manage table from csv file
        cursor.executemany("""
            INSERT INTO
            manage (UCINetID, machine_id)
            VALUES(%s, %s);
        """, get_csv_data(folder_name=folder_name, csv_name='manage.csv'))

        db.commit()

    return ",".join(map(str, counts[:]))


# Read csv file
def get_csv_data(folder_name: str, csv_name: str) -> list[list[str]]:
    csv_data: list[list[str]] = []
    try:
        with open(f"./{folder_name}/{csv_name}") as f_csv:
            f_csv = csv.reader(f_csv, delimiter=',')
            for row in f_csv:
                for i in range(0, len(row)):
                    if row[i] == 'NULL':
                        row[i] = None
                csv_data.append(row)
    except FileNotFoundError:
        print(f"File: {csv_name} not found")

    return csv_data


def insert_student(db: mysql.connector.connection_cext, student_data: list[str]) -> bool:
    try:
        with db.cursor() as cursor:
            if student_data[3] == 'NULL':
                user_data = (student_data[0], student_data[2], None, student_data[4])
            else:
                user_data = (student_data[0], student_data[2], student_data[3], student_data[4])
            
            email_data = (student_data[0], student_data[1])

            cursor.execute("""
                INSERT INTO
                    users (UCINetID, first_name, middle_name, last_name)
                    VALUES (%s, %s, %s, %s);
            """, user_data)

            cursor.execute("""
                INSERT INTO
                    emails (UCINetID, email)
                    VALUES (%s, %s);
            """, email_data)

            cursor.execute("""
                INSERT INTO
                    students (UCINetID)
                    VALUES (%s);
            """, (student_data[0], ))

            db.commit()
    except mysql.connector.Error:
        db.rollback()
        return False

    return True


def add_email(db: mysql.connector.connection_cext, user_data: list[str]) -> bool:
    try:
        with db.cursor() as cursor:
            cursor.execute("""
                INSERT INTO
                    emails (UCINetID, email)
                    VALUES (%s, %s);
            """, user_data)

            db.commit()
    except mysql.connector.Error:
        db.rollback()
        return False

    return True


def delete_student(db: mysql.connector.connection_cext, UCINetID: list[str]) -> bool:
    try:
        with db.cursor() as cursor:
            cursor.execute("""
                DELETE users
                FROM users
                NATURAL JOIN students
                WHERE UCINetID = %s;
            """, UCINetID)

            db.commit()

        if cursor.rowcount < 1:  # if zero row is deleted, return false
            return False
    except mysql.connector.Error:
        db.rollback()
        return False

    return True


def insert_machine(db: mysql.connector.connection_cext, machine_data: list[str]) -> bool:
    try:
        with db.cursor() as cursor:            
            machine_data: tuple[str, ...] = tuple(machine_data[:4]) + (' '.join(map(str, machine_data[4:])), )

            cursor.execute("""
                INSERT INTO
                    machines (machine_id, hostname, ip_address, operation_status, location)
                    VALUES (%s, %s, %s, %s, %s);
            """, machine_data)

            db.commit()
    except mysql.connector.Error:
        db.rollback()
        return False
    
    return True


def insert_use(db: mysql.connector.connection_cext, use_data: list[str]) -> bool:
    try:    
        with db.cursor() as cursor:
            cursor.execute("""
                INSERT INTO
                    uses (project_id, UCINetID, machine_id, start_date, end_date)
                    VALUES (%s, %s, %s, DATE(%s), DATE(%s))
            """, use_data)

            db.commit()
    except mysql.connector.Error:
        db.rollback()
        return False
    
    return True


def update_course(db: mysql.connector.connection_cext, course_data: list[str]) -> bool:
    try:
        with db.cursor() as cursor:
            course_data: tuple = (' '.join(map(str, course_data[1:])), course_data[0])

            cursor.execute("""
                UPDATE courses
                SET title = %s
                WHERE course_id = %s;
            """, course_data)

            db.commit()

            if cursor.rowcount < 1:  # if no course updated, return false
                return False

    except mysql.connector.Error:
        db.rollback()
        return False

    return True


def list_courses(db: mysql.connector.connection_cext, UCINetID: list[str]) -> str:
    try:
        with db.cursor() as cursor:
            cursor.execute("""
                SELECT DISTINCT course_id, title, quarter
                FROM courses
                NATURAL JOIN projects
                NATURAL JOIN uses
                NATURAL JOIN students
                WHERE UCINetID = %s
                ORDER BY course_id ASC;
            """, UCINetID)

            fetched_courses = cursor.fetchall()
            course_list: list[str] = []

            for row in fetched_courses:
                course_list.append(','.join(map(str, row[:])))

            course_str: str = '\n'.join(course_list)

            return course_str
    except mysql.connector.Error:
        return ""


def popular_course(db: mysql.connector.connection_cext, N: list[int]) -> str:
    try:
        with db.cursor() as cursor:
            for i in range(0, len(N)):
                N[i] = int(N[i])
            cursor.execute("""
                SELECT courses.course_id, courses.title, COUNT(DISTINCT students.UCINetID) AS studentCount
                FROM courses
                JOIN projects ON courses.course_id = projects.course_id
                JOIN uses ON projects.project_id = uses.project_id
                JOIN students ON uses.UCINetID = students.UCINetID
                GROUP BY courses.course_id
                ORDER BY studentCount DESC, courses.course_id DESC
                LIMIT %s;
            """, N)

            fetched_courses = cursor.fetchall()
            course_list: list[str] = []

            for row in fetched_courses:
                course_list.append(','.join(map(str, row[:])))

            course_str: str = '\n'.join(course_list)

            return course_str
    except mysql.connector.Error:
        return ""


def admin_emails(db: mysql.connector.connection_cext, machineId: list[int]) -> str:
    try:
        with db.cursor() as cursor:
            cursor.execute("""
                SELECT users.UCINetID, users.first_name, IFNULL(users.middle_name, 'NULL') AS middle_name, users.last_name, GROUP_CONCAT(emails.email SEPARATOR ';') AS emaillist
                FROM admins
                JOIN manage ON admins.UCINetID = manage.UCINetID
                JOIN users ON admins.UCINetID = users.UCINetID
                JOIN emails ON admins.UCINetID = emails.UCINetID
                WHERE manage.machine_id = %s
                GROUP BY users.UCINetID, users.first_name, users.middle_name, users.last_name
                ORDER BY users.UCINetID ASC;
            """, machineId)

            fetched_courses = cursor.fetchall()
            admin_list: list[str] = []

            for row in fetched_courses:
                admin_list.append(','.join(map(str, row[:])))

            admin_str: str = '\n'.join(admin_list)

            return admin_str
    except mysql.connector.Error:
        return ""


def active_students(db: mysql.connector.connection_cext, data: list[str]):
    try:
        with db.cursor() as cursor:
            machineId = int(data[0])
            N = int(data[1])
            start_date = data[2]
            end_date = data[3]
            query = """
                SELECT u.UCINetID, u.first_name, IFNULL(u.middle_name, 'NULL') AS middle_name, u.last_name
                FROM users AS u
                JOIN (
                    SELECT UCINetID
                    FROM uses
                    WHERE machine_id = %s
                    AND ((start_date BETWEEN %s AND %s) OR (end_date BETWEEN %s AND %s))
                    GROUP BY UCINetID
                    HAVING COUNT(*) >= %s
                ) AS active_usage ON u.UCINetID = active_usage.UCINetID
                ORDER BY u.UCINetID ASC;
            """
            cursor.execute(query, (machineId, start_date, end_date, start_date, end_date, N))
            active_students = cursor.fetchall()
            if active_students:
                return '\n'.join([','.join(map(str, row)) for row in active_students])
            else:
                return ""
    except mysql.connector.Error as e:
        return ""


def get_machine_number(db: mysql.connector.connection_cext, courseID: list[str]):
    try:
        with db.cursor() as cursor:
            query = """
                SELECT m.machine_id, m.hostname, m.ip_address, COALESCE(usage_count.count, 0) AS count
                FROM machines m
                LEFT JOIN (
                    SELECT uses.machine_id, COUNT(*) AS count
                    FROM uses
                    JOIN projects ON uses.project_id = projects.project_id
                    WHERE projects.course_id = %s
                    GROUP BY uses.machine_id
                ) AS usage_count ON m.machine_id = usage_count.machine_id
                ORDER BY m.machine_id DESC;
            """
            cursor.execute(query, courseID)
            machine_usage = cursor.fetchall()
            return '\n'.join([','.join(map(str, row)) for row in machine_usage])
    except mysql.connector.Error as e:
        return ""




