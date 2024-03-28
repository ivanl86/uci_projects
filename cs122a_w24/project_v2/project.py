import mysql.connector
import sys

from db_config import DB
import sql_func


def main():
    # Establish database connection
    with mysql.connector.connect(**DB.config) as db:
        func_name: str = sys.argv[1]
        args: list = sys.argv[2:]

        match func_name:
            case "import":
                print(sql_func.import_data(db=db, folder_name=args[0]))
            case "insertStudent":
                print("Success" if sql_func.insert_student(db=db, student_data=args) else "Fail")
            case "addEmail":
                print("Success" if sql_func.add_email(db=db, user_data=args) else "Fail")
            case "deleteStudent":
                print("Success" if sql_func.delete_student(db=db, UCINetID=args) else "Fail")
            case "insertMachine":
                print("Success" if sql_func.insert_machine(db=db, machine_data=args) else "Fail")
            case "insertUse":
                print("Success" if sql_func.insert_use(db=db, use_data=args) else "Fail")
            case "updateCourse":
                print("Success" if sql_func.update_course(db=db, course_data=args) else "Fail")
            case "listCourse":
                print(sql_func.list_courses(db=db, UCINetID=args))
            case "popularCourse":
                print(sql_func.popular_course(db=db, N=args))
            case "adminEmails":
                print(sql_func.admin_emails(db=db, machineId=args))
            case "activeStudent":
                print(sql_func.active_students(db, args))
            case "machineUsage":
                print(sql_func.get_machine_number(db, args))



if __name__ == "__main__":
    main()
