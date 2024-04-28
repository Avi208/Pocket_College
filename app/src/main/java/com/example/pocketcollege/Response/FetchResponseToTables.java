package com.example.pocketcollege.Response;

import com.example.pocketcollege.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mahiti on 26/01/17.
 */
public class FetchResponseToTables {

    public  static String loginResponse="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"user\": {\n" +
            "    \"id\": \"902\",\n" +
            "    \"name\": \"Chethan K S\",\n" +
            "    \"photo\": \"http://www.pocketcollege.in/pvkk/upload-student-pic/06-07-2016-1467802367-rajesh.jpg\",\n" +
            "    \"email\": \"chetu.lir@gmail.com\",\n" +
            "    \"mobile\": \"8123008892\",\n" +
            "    \"count\": 9\n" +
            "  },\n" +
            "  \"subject_id\": [\n" +
            "    \"203\",\n" +
            "    \"204\",\n" +
            "    \"205\",\n" +
            "    \"206\",\n" +
            "    \"207\",\n" +
            "    \"209\",\n" +
            "    \"210\",\n" +
            "    \"211\",\n" +
            "    \"570\"\n" +
            "  ],\n" +
            "  \"subject\": [\n" +
            "    \"Database Management Systems\",\n" +
            "    \"Java Programming\",\n" +
            "    \"Formal Languages & Automata Theory.\",\n" +
            "    \"Computer Organization &  Architecture.  \",\n" +
            "    \"Principles of Programming Languages.\",\n" +
            "    \"Database Management Systems Lab\",\n" +
            "    \"Java Programming Lab\",\n" +
            "    \"Human Values & Professional Ethics (Audit Course) \",\n" +
            "    \"Design And Analysis of Algorithms\"\n" +
            "  ]\n" +
            "}";

    public static String studenttimeTable ="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Student_TimeTable\",\n" +
            "  \"time_table\": [\n" +
            "    {\n" +
            "      \"time\": \"9:30AM-10:20AM\",\n" +
            "      \"subject_name\": \"Java Programming\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"10:21AM-11:10AM\",\n" +
            "      \"subject_name\": \"Database Management Systems\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"11:11AM-11:25AM\",\n" +
            "      \"subject_name\": \"Break\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"11:26AM-12:15PM\",\n" +
            "      \"subject_name\": \"Computer Organization &  Architecture.  \"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"12:16PM-1:05AM\",\n" +
            "      \"subject_name\": \"Principles of Programming Languages.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"1:06AM-1:55AM\",\n" +
            "      \"subject_name\": \"Break\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String studentAttedence="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"attandence\": [\n" +
            "    {\n" +
            "      \"subject_name\": \"Database Management Systems\",\n" +
            "      \"subject_code\": \"13A05402\",\n" +
            "      \"date\": \"04/05/2016\",\n" +
            "      \"present\": \"4\",\n" +
            "      \"total_class\": \"6\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"subject_name\": \"java Lab\",\n" +
            "      \"subject_code\": \"13A05402\",\n" +
            "      \"date\": \"04/05/2016\",\n" +
            "      \"present\": \"2\",\n" +
            "      \"total_class\": \"6\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static String studentInternalMarks="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"IA Marks Fetched Successfully!\",\n" +
            "  \"ia_marks\": [\n" +
            "    {\n" +
            "      \"firstmid\": 26,\n" +
            "      \"secondmid\": 27,\n" +
            "      \"average\": 27\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static String studentNotification="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Notice\",\n" +
            "  \"notice\": [\n" +
            "    {\n" +
            "      \"title\": \"Prepare Late Comers List.\",\n" +
            "      \"content\": \"Madhu,\\r\\n\\r\\n\\r\\nSend the Late Comers List of Boys and Girls Who stays in Hostel Block Wise. The Management is taking the Disciplinary action who ever coming the Hostel late in the night . All the Students should be present in side the Hostel Before 9:15 Pm all the Days. \",\n" +
            "      \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
            "      \"issued_on\": \"07/29/2016\",\n" +
            "      \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"List of Students Details.\",\n" +
            "      \"content\": \"Rajgopal,\\r\\n\\r\\n\\r\\nSend the Boys and Girls Details of each Hostel in the Campus.\\r\\n\\r\\n\\r\\n\\r\\nYours,\\r\\n\\r\\nPrincipal.\",\n" +
            "      \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
            "      \"issued_on\": \"07/29/2016\",\n" +
            "      \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Appointment schedule\",\n" +
            "      \"content\": \"HI,\\r\\n\\r\\nToday i will allow visitors only between 10:30am to 12:30pm. \",\n" +
            "      \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
            "      \"issued_on\": \"07/25/2016\",\n" +
            "      \"path\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Greetings\",\n" +
            "      \"content\": \"CONGRATULATIONS\\n\\nManagement, Principal and Staff of PVKKIT congratulates the 23 Students who got selected in the Off campus drive by TECH MAHINDRA on 09-05-2016\\n\\n\\nCONGRATULATIONS\\n14 Students got selected in the Off Campus RECRUITMENT drive conducted by \\\"INSPIREDGE IT SOLUTIONS\\\" on 14-May-2016\\\".\",\n" +
            "      \"owner\": \"Dr P.Mallikarjuna Reddy\",\n" +
            "      \"issued_on\": \"05/31/2016\",\n" +
            "      \"path\": \"http://www.pocketcollege.in/pvkk/notice/notice13315460_1003230216398072_1577787957195727420_n.jpg\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String studentPersonalDetail="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"events\": [\n" +
            "    {\n" +
            "      \"clg_joined_date\": \"10/06/2013\",\n" +
            "      \"usn\": \"BC141302\",\n" +
            "      \"email\": \"chetu.lir@gmail.com\",\n" +
            "      \"date_of_birth\": \"10/02/1992\",\n" +
            "      \"student_name\": \"CHETHAN K S\",\n" +
            "      \"father_name\": \"Shankarappa K\",\n" +
            "      \"home_number\": \"9449701639\",\n" +
            "      \"blood_group\": \"b+ve\",\n" +
            "      \"native_address\": \"Jyothinagar Chickmagalur\",\n" +
            "      \"photo\": \"\",\n" +
            "      \"user_id\": \"902\"\n" +
            "    }\n" +
            "  ]\n" +
            "}"+
            "}";
    public static String studentMyinstituteDetail="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"my_institute_details\": [\n" +
            "    {\n" +
            "      \"college_name\": \"Mountain View College\",\n" +
            "      \"college_code\": \"141\",\n" +
            "      \"email\": \"mountainviewedu.trust.education\",\n" +
            "      \"phone_number\": \"100\",\n" +
            "      \"profile_pdf\": \"http://pocketcollege.in/pvkk/clg-profile/brochure.pdf\",\n" +
            "      \"profile_photo\": \"http://pocketcollege.in/pvkk/clg-logo/pvkk.jpe\",\n" +
            "      \"address\": \"VidhyaNagar,Chickmagalur 577101\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public  static String ParentLoginResponse="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"parent_after_details\": [\n" +
            "    {\n" +
            "      \"student_id\": \"902\",\n" +
            "      \"parent_number\": \"9449401639\",\n" +
            "      \"parent_id\": \"765\",\n" +
            "      \"parent_name\": \"Shankarappa K\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/upload-student-pic/06-07-2016-1467802367-rajesh.jpg\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"subject_id\": [\n" +
            "    \"203\",\n" +
            "    \"204\",\n" +
            "    \"205\",\n" +
            "    \"206\",\n" +
            "    \"207\",\n" +
            "    \"209\",\n" +
            "    \"210\",\n" +
            "    \"211\",\n" +
            "    \"570\"\n" +
            "  ],\n" +
            "  \"subject_name\": [\n" +
            "    \"Database Management Systems\",\n" +
            "    \"Java Programming\",\n" +
            "    \"Formal Languages & Automata Theory.\",\n" +
            "    \"Computer Organization &  Architecture.  \",\n" +
            "    \"Principles of Programming Languages.\",\n" +
            "    \"Database Management Systems Lab\",\n" +
            "    \"Java Programming Lab\",\n" +
            "    \"Human Values & Professional Ethics (Audit Course) \",\n" +
            "    \"Design And Analysis of Algorithms\"\n" +
            "  ]\n" +
            "}";


    public static String parenttimeTable ="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Student_TimeTable\",\n" +
            "  \"time_table\": [\n" +
            "    {\n" +
            "      \"time\": \"9:30AM-10:20AM\",\n" +
            "      \"subject_name\": \"Java Programming\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"10:21AM-11:10AM\",\n" +
            "      \"subject_name\": \"Database Management Systems\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"11:11AM-11:25AM\",\n" +
            "      \"subject_name\": \"Break\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"11:26AM-12:15PM\",\n" +
            "      \"subject_name\": \"Computer Organization &  Architecture.  \"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"12:16PM-1:05AM\",\n" +
            "      \"subject_name\": \"Principles of Programming Languages.\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"time\": \"1:06AM-1:55AM\",\n" +
            "      \"subject_name\": \"Break\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static String parentAttedence="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"attandence\": [\n" +
            "    {\n" +
            "      \"subject_name\": \"Database Management Systems\",\n" +
            "      \"subject_code\": \"13A05402\",\n" +
            "      \"date\": \"04/05/2016\",\n" +
            "      \"present\": \"4\",\n" +
            "      \"total_class\": \"6\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"subject_name\": \"java Lab\",\n" +
            "      \"subject_code\": \"13A05402\",\n" +
            "      \"date\": \"04/05/2016\",\n" +
            "      \"present\": \"2\",\n" +
            "      \"total_class\": \"6\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static String parentInternalMarks="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"IA Marks Fetched Successfully!\",\n" +
            "  \"ia_marks\": [\n" +
            "    {\n" +
            "      \"firstmid\": 20,\n" +
            "      \"secondmid\": 20,\n" +
            "      \"average\": 20\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String parent_eventResonse="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"events\": [\n" +
            "    {\n" +
            "      \"event_id\": \"12\",\n" +
            "      \"title\": \"Dancing & Music Fest\",\n" +
            "      \"content\": \"\",\n" +
            "      \"issued_on\": \"06/27/2016\",\n" +
            "      \"owner\": \"admin\",\n" +
            "      \"college_id\": \"24\",\n" +
            "      \"branch_id\": \"\",\n" +
            "      \"event_path\": \"\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"event_id\": \"11\",\n" +
            "      \"title\": \"ANNUAL DAY\",\n" +
            "      \"content\": \"  It is hereby informed that the 48th Annual Day is scheduled on 24th April 2016 at 10AM  in Auditorium.All the students are hereby cordially invited to attend the Annual Day.\\r\\n\\r\\nPlease note the following instuctions :\\r\\n1. Be present in the Auditorium with neat dress only.\\r\\n2. Occupy the seats in the Auditorium at least half an hour earlier i.e. at 9:30AM.\\r\\n3. Stand up when Chief Guest enters the hall and occupy the chair.\\r\\n4. Maintain silence and discipline throughout the function.\\r\\n5. Switch off mobile phone in the premises.\\r\\n6. Not to leave the position till Chief Guest leaves the hall after the function is over.\",\n" +
            "      \"issued_on\": \"02/12/2016\",\n" +
            "      \"owner\": \"admin\",\n" +
            "      \"college_id\": \"24\",\n" +
            "      \"branch_id\": \"\",\n" +
            "      \"event_path\": \"\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String parent_PersonalDetailResponse="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"events\": [\n" +
            "    {\n" +
            "      \"clg_joined_date\": \"02/25/2015\",\n" +
            "      \"usn\": \"153n5a0501\",\n" +
            "      \"email\": \"chetu.lir@gmail.com\",\n" +
            "      \"date_of_birth\": \"20/02/1994\",\n" +
            "      \"student_name\": \"Chetham K S\",\n" +
            "      \"father_name\": \"Shankarappa K\",\n" +
            "      \"home_number\": \"9449701639\",\n" +
            "      \"blood_group\": \"b+ve\",\n" +
            "      \"native_address\": \"Jyothinagar Chickmagalur\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/upload-student-pic/06-07-2016-1467802367-rajesh.jpg\",\n" +
            "      \"user_id\": \"902\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String parent_teacherPersonalDetailResponse="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"Faculty_personal_details\": [\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE008\",\n" +
            "      \"teacher_name\": \"MUKARRAM ALI\",\n" +
            "      \"teacher_email\": \"MUKARAM@GMAIL.COM\",\n" +
            "      \"teacher_mobile\": \"8523020930\",\n" +
            "      \"education\": \"M.SC\",\n" +
            "      \"teacher_branch\": \"Computer Science\",\n" +
            "      \"work_experience\": \"3\",\n" +
            "      \"position\": \"HEAD OF THE DEPARTMENT\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486121866668CSE008photoEranna.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE002\",\n" +
            "      \"teacher_name\": \"ULLASA\",\n" +
            "      \"teacher_email\": \"ULLASA@gmail.com\",\n" +
            "      \"teacher_mobile\": \"9908296777\",\n" +
            "      \"education\": \"MCA\",\n" +
            "      \"teacher_branch\": \"Computer Science\",\n" +
            "      \"work_experience\": \"4\",\n" +
            "      \"position\": \"Assistant Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486064831329CSE002photojyothi.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE005\",\n" +
            "      \"teacher_name\": \"C ISHAQ SHAREEF\",\n" +
            "      \"teacher_email\": \"shareef_soft@yahoo.co.in\",\n" +
            "      \"teacher_mobile\": \"9148348943\",\n" +
            "      \"education\": \"M.Tech\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"10\",\n" +
            "      \"position\": \"Assistant Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486155599308CSE005photoISHAQ-PHOTO.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE008\",\n" +
            "      \"teacher_name\": \"ERANNA M\",\n" +
            "      \"teacher_email\": \"ERU.CSE@GMAIL.COM\",\n" +
            "      \"teacher_mobile\": \"8523020930\",\n" +
            "      \"education\": \"M.Tech\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"3\",\n" +
            "      \"position\": \"Assistant Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486121866668CSE008photoEranna.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE004\",\n" +
            "      \"teacher_name\": \"BOYA SAROJA\",\n" +
            "      \"teacher_email\": \"saroja.boya@gmail.com\",\n" +
            "      \"teacher_mobile\": \"7396486854\",\n" +
            "      \"education\": \"M.TECH\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"3\",\n" +
            "      \"position\": \"Assistant Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486156787332CSE004photoPHOTO.JPG\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE001\",\n" +
            "      \"teacher_name\": \"Dilip Venkata Kumar Vengala\",\n" +
            "      \"teacher_email\": \"dilipvenkatakumar@gmail.com\",\n" +
            "      \"teacher_mobile\": \"8886630027\",\n" +
            "      \"education\": \"M.Tech\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"10\",\n" +
            "      \"position\": \"Associate Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486058319538CSE001photodillip-PP.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/faculty_ach/achconvert-jpg-to-pdf.net_2016-05-06_11-29-44.pdf\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE001\",\n" +
            "      \"teacher_name\": \"Dilip Venkata Kumar Vengala\",\n" +
            "      \"teacher_email\": \"dilipvenkatakumar@gmail.com\",\n" +
            "      \"teacher_mobile\": \"8886630027\",\n" +
            "      \"education\": \"M.Tech\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"10\",\n" +
            "      \"position\": \"Associate Professor\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486058319538CSE001photodillip-PP.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/faculty_ach/achconvert-jpg-to-pdf.net_2016-05-06_11-29-44.pdf\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE012\",\n" +
            "      \"teacher_name\": \"P ANANDU\",\n" +
            "      \"teacher_email\": \"ananduanandu7@gmail.com\",\n" +
            "      \"teacher_mobile\": \"8143333014\",\n" +
            "      \"education\": \"B.Tech\",\n" +
            "      \"teacher_branch\": \"Computer Science & Engineering\",\n" +
            "      \"work_experience\": \"4\",\n" +
            "      \"position\": \"Teaching Assistant\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486094898639CSE012photoAnand.jpg\",\n" +
            "      \"achieve\": \"http://pocketcollege.in/pvkk/\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public static String hodloginResponseAPI="{\n"+
            "  \"status\": \"ok\",\n"+
            "  \"response\": \"Fetched Successfully!\",\n"+
            "  \"teacher\": {\n"+
            "    \"id\": \"86\",\n"+
            "    \"name\": \"MUKARRAM ALI\",\n"+
            "    \"empid\": \"CSE001\",\n"+
            "    \"branch_id\": \"5\",\n"+
            "    \"college_id\": \"24\",\n"+
            "    \"photo\": \"http://www.pocketcollege.in/pvkk/employee_doc/14486058319538CSE001photodillip-PP.jpg\",\n"+
            "    \"email\": \"mukaram@gmail.com\",\n"+
            "    \"mobile\": \"9945151461\"\n"+
            "  }\n"+
            "}";
    public static String hodNoticboardResponseAPI="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Notice\",\n" +
            "  \"notice\": [\n" +
            "    {\n" +
            "      \"title\": \"General checkup\",\n" +
            "      \"owner\": \"infirmary\",\n" +
            "      \"content\": \"General checkup\",\n" +
            "      \"issued_on\": \"06-Jul-2016\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"Greetings\",\n" +
            "      \"owner\": \"principal\",\n" +
            "      \"content\": \"CONGRATULATIONS\\n\\nManagement, Principal and Staff of PVKKIT congratulates the 23 Students who got selected in the Off campus drive by TECH MAHINDRA on 09-05-2016\\n\\n\\nCONGRATULATIONS\\n14 Students got selected in the Off Campus RECRUITMENT drive conducted by \\\"INSPIREDGE IT SOLUTIONS\\\" on 14-May-2016\\\".\",\n" +
            "      \"issued_on\": \"31-May-2016\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \" Faculty Development Training Program\",\n" +
            "      \"owner\": \"principal\",\n" +
            "      \"content\": \"On March 2nd all Faculties have to attend Faculty Development Training Program in college Auditorium.\",\n" +
            "      \"issued_on\": \"12-Feb-2016\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String hodTimetableResponseApi="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Student_TimeTable\",\n" +
            "  \"time\": [\n" +
            "    \"9:30AM - 10:20AM\",\n" +
            "    \"10:21AM - 11:10AM\",\n" +
            "    \"11:11AM - 11:25AM\",\n" +
            "    \"11:26AM - 12:15PM\",\n" +
            "    \"12:16PM - 1:05AM\",\n" +
            "    \"1:06AM - 1:55AM\",\n" +
            "    \"1:56AM - 2:45AM\",\n" +
            "    \"2:46AM - 3:35AM\",\n" +
            "    \"3:36AM - 4:25AM\"\n" +
            "  ],\n" +
            "  \"days\": \"Friday\",\n" +
            "  \"subject_name\": [\n" +
            "    \"Database Management Systems\",\n" +
            "    \"null\",\n" +
            "    \"Break Time\",\n" +
            "    \"null\",\n" +
            "    \"null\",\n" +
            "    \"Break Time\",\n" +
            "    \"null\",\n" +
            "    \"null\",\n" +
            "    \"null\"\n" +
            "  ]\n" +
            "}";

    public  static  String hodPersonalDetails="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"personal_details\": [\n" +
            "    {\n" +
            "      \"emp_id\": \"CSE001\",\n" +
            "      \"name\": \"MUKARRAM ALI\",\n" +
            "      \"email\": \"mukaram@gmail.com\",\n" +
            "      \"phone_number\": \"9945151461\",\n" +
            "      \"education\": \"M.Sc\",\n" +
            "      \"dept_name\": \"Computer Science\",\n" +
            "      \"emp_pos\": \"Head Of the Department\",\n" +
            "      \"dob\": \"10/12/1981\",\n" +
            "      \"gender\": \"Male\",\n" +
            "      \"blood_group\": \"B+\",\n" +
            "      \"work_experience\": \"15\",\n" +
            "      \"photo\": \"http://pocketcollege.in/pvkk/employee_doc/14486058319538CSE001photodillip-PP.jpg\",\n" +
            "      \"address\": \"LIG-282\\r\\VidhyaNagar\\r\\nATP 1 \"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public  static  String hodAttendenceSubject="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"handel_subject_details\": [\n" +
            "    {\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"regulation_no\": \"R13\",\n" +
            "      \"section_name\": \"A\",\n" +
            "      \"regulationwise_sem\": \"II-II\",\n" +
            "      \"subject_name\": \"Database Management Systems\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"subject_id\": \"209\",\n" +
            "      \"regulation_no\": \"R13\",\n" +
            "      \"section_name\": \"A\",\n" +
            "      \"regulationwise_sem\": \"II-II\",\n" +
            "      \"subject_name\": \"Database Management Systems Lab\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    public  static  String hodAttendenceSubjectTime="{\"status\":\"ok\",\"response\":\"Data Added Successfully!\",\"period\":[{\"from\":\"09:30:00\",\"to\":\"10:20:00\"},{\"from\":\"10:21:00\",\"to\":\"11:10:00\"},{\"from\":\"11:26:00\",\"to\":\"12:15:00\"},{\"from\":\"12:16:00\",\"to\":\"01:05:00\"},{\"from\":\"01:56:00\",\"to\":\"02:45:00\"},{\"from\":\"02:46:00\",\"to\":\"03:35:00\"},{\"from\":\"03:36:00\",\"to\":\"04:25:00\"}]}";
    public static String hodAttendenseStudentList="{\n" +
            "  \"status\": \"ok\",\n" +
            "  \"response\": \"Fetched Successfully!\",\n" +
            "  \"student_details\": [\n" +
            "    {\n" +
            "      \"student_id\": \"902\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"Chethan KS\",\n" +
            "      \"student_regno\": \"bc141302\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/upload-student-pic/06-07-2016-1467802367-rajesh.jpg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"903\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"Sahil\",\n" +
            "      \"student_regno\": \"143N1A0509\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"904\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"AKHIL\",\n" +
            "      \"student_regno\": \"143N1A0538\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"905\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"VENKATESH NAIK\",\n" +
            "      \"student_regno\": \"143N1A0521\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"906\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"DUDEKULA RAMEEZA\",\n" +
            "      \"student_regno\": \"143N1A0508\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"907\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"JOGANNAGARI LAVANYA\",\n" +
            "      \"student_regno\": \"143N1A0516\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"908\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"PALLE GNANAKEERTHI\",\n" +
            "      \"student_regno\": \"143N1A0535\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"909\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"SINGETI MOUNIKA\",\n" +
            "      \"student_regno\": \"143N1A0547\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"910\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"SHAIK ZAREENA BEE\",\n" +
            "      \"student_regno\": \"143N1A0544\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"student_id\": \"911\",\n" +
            "      \"section_id\": \"207\",\n" +
            "      \"student_name\": \"B. SOWMYA\",\n" +
            "      \"student_regno\": \"143N1A0503\",\n" +
            "      \"teacher_id\": \"86\",\n" +
            "      \"subject_id\": \"203\",\n" +
            "      \"photo\": \"http://www.pocketcollege.in/pvkk/\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Harsha", R.drawable.profile_new, "1aw12BCA53", "Computer Science"));
        students.add(new Student("Ram Kumar Varma ", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Divya Valsane", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Priyanka kulkarni", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Bob", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Raj", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Ravi", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        students.add(new Student("Abhishek", R.drawable.profile_new, "54321", "Mechanical Engineering"));
        // Add 8 more students with different names, photos (replace drawables), register numbers, and branches
        // ...

        return students;
    }
}
