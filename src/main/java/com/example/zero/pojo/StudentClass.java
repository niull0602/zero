package com.example.zero.pojo;

import javax.persistence.*;

@Table(name = "t_student_class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学生id
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "class_id")
    private Long classId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取学生id
     *
     * @return user_id - 学生id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置学生id
     *
     * @param userId 学生id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return class_id
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }
}