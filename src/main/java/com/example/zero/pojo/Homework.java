package com.example.zero.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;
@Data
@ToString
@Table(name = "t_homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学生上传者的id
     */
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "publish_id")
    private Long publishId;

    @Column(name = "homework_file_name")
    private String homeworkFileName;

    @Column(name = "homework_url")
    private String homeworkUrl;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取上传者的id
     *
     * @return user_id - 上传者的id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置上传者的id
     *
     * @param userId 上传者的id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }


    /**
     * @return homework_url
     */
    public String getHomeworkUrl() {
        return homeworkUrl;
    }

    /**
     * @param homeworkUrl
     */
    public void setHomeworkUrl(String homeworkUrl) {
        this.homeworkUrl = homeworkUrl == null ? null : homeworkUrl.trim();
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

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}