package com.example.zero.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "t_ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 老师
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "start_week")
    private Integer startWeek;

    @Column(name = "end_week")
    private Integer endWeek;

    /**
     *  哪一节
     */
    @ApiModelProperty(value = "哪一节")
    private Integer section;

    private String address;

    /**
     * 星期几
     */
    @ApiModelProperty(value = "星期几")
    private Short weekday;
    @ApiModelProperty(value = "带的东西")
    private String tool;

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
     * 获取老师
     *
     * @return user_id - 老师
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置老师
     *
     * @param userId 老师
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

    /**
     * @return course_id
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * @param courseId
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * @return start_week
     */
    public Integer getStartWeek() {
        return startWeek;
    }

    /**
     * @param startWeek
     */
    public void setStartWeek(Integer startWeek) {
        this.startWeek = startWeek;
    }

    /**
     * @return end_week
     */
    public Integer getEndWeek() {
        return endWeek;
    }

    /**
     * @param endWeek
     */
    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    /**
     * 获取 哪一节
     *
     * @return section -  哪一节
     */
    public Integer getSection() {
        return section;
    }

    /**
     * 设置 哪一节
     *
     * @param section  哪一节
     */
    public void setSection(Integer section) {
        this.section = section;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取星期几
     *
     * @return weekday - 星期几
     */
    public Short getWeekday() {
        return weekday;
    }

    /**
     * 设置星期几
     *
     * @param weekday 星期几
     */
    public void setWeekday(Short weekday) {
        this.weekday = weekday;
    }
}