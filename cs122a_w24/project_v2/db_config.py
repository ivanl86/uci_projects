class DB:
    config = {
        'user': 'test',
        'password': 'password',
        'host': 'localhost',
        'database': 'cs122a',
        'autocommit': False
    }

    TABLES: dict[str, str] = {
        'users': """
                    CREATE TABLE users (
                        UCINetID VARCHAR(50) PRIMARY KEY,
                        first_name VARCHAR(50),
                        middle_name VARCHAR(50),
                        last_name VARCHAR(50)
                    );""",
        'emails': """
                    CREATE TABLE emails (
                        UCINetID VARCHAR(50),
                        email VARCHAR(50),
                        PRIMARY KEY(UCINetID, email),
                        FOREIGN KEY(UCINetID) REFERENCES users(UCINetID) ON DELETE CASCADE
                    );""",
        'students': """
                    CREATE TABLE students (
                        UCINetID VARCHAR(50) PRIMARY KEY,
                        FOREIGN KEY(UCINetID) REFERENCES users(UCINetID) ON DELETE CASCADE
                    );""",
        'admins': """
                    CREATE TABLE admins (
                    UCINetID VARCHAR(50) PRIMARY KEY,
                    FOREIGN KEY(UCINetID) REFERENCES users(UCINetID) ON DELETE CASCADE
                    );""",
        'courses': """
                    CREATE TABLE courses (
                        course_id INT PRIMARY KEY,
                        title VARCHAR(100),
                        quarter VARCHAR(10)
                    );""",
        'projects': """
                    CREATE TABLE projects (
                        project_id INT PRIMARY KEY,
                        name VARCHAR(100),
                        description VARCHAR(100),
                        course_id INT NOT NULL,
                        FOREIGN KEY(course_id) REFERENCES courses(course_id)
                    );""",
        'machines': """
                    CREATE TABLE machines (
                    machine_id INT PRIMARY KEY,
                    hostname VARCHAR(50),
                    ip_address VARCHAR(15),
                    operation_status ENUM("Active", "Down"),
                    location VARCHAR(50)
                    );""",
        'uses': """
                    CREATE TABLE uses (
                        project_id INT,
                        UCINetID VARCHAR(50),
                        machine_id INT,
                        start_date DATE,
                        end_date DATE,
                        PRIMARY KEY(project_id, UCINetID, machine_id),
                        FOREIGN KEY(project_id) REFERENCES projects(project_id),
                        FOREIGN KEY(UCINetID) REFERENCES students(UCINetID),
                        FOREIGN KEY(machine_id) REFERENCES machines(machine_id)
                    );""",
        'manage': """
                        CREATE TABLE manage (
                        UCINetID VARCHAR(50),
                        machine_id INT,
                        PRIMARY KEY(UCINetID, machine_id),
                        FOREIGN KEY(UCINetID) REFERENCES admins(UCINetID),
                        FOREIGN KEY(machine_id) REFERENCES machines(machine_id)
                    );"""
    }
