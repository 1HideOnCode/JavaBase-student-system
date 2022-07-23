package com.HZ_A9.mysql.teacher.teacherDao;

import com.HZ_A9.entities.Teacher;

public interface teacherDao {
    abstract void showTeacherInfo(Teacher teacher);
    abstract void showCourseInfo(Teacher teacher);
    abstract boolean addCourse(Teacher teacher);
    abstract boolean updateTeacherPassword(Teacher teacher);
}
