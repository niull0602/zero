package com.example.zero.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_publish_homework")
public class PublishHomework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 教师id
     */
    @Column(name = "user_id")
    private Long userId;


    @Column(name = "class_id")
    private Long classId;

    @Column(name = "homework_name")
    private String homeworkName;

    private String content;
    @Column(name = "teacher_file_name")
    private String teacherFileName;
    @Column(name = "teacher_file_url")
    private String teacherFileUrl;

    @Column(name = "create_time")
    private Date createTime;

    private Short mark;

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
     * 获取教师id
     *
     * @return user_id - 教师id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置教师id
     *
     * @param userId 教师id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return homework_name
     */
    public String getHomeworkName() {
        return homeworkName;
    }

    /**
     * @param homeworkName
     */
    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName == null ? null : homeworkName.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}