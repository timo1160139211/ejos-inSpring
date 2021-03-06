package site.gaoyisheng.dao;

import java.util.List;

import site.gaoyisheng.pojo.Team;

public interface TeamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    int insert(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    int insertSelective(Team record);
    
    /**
     * .
     * TODO
     * @param record
     * @return
     */
    int insertCacheId(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    Team selectByPrimaryKey(Integer id);
    
    /**
     * 查询该老师的班级.
     * TODO
     * @param teacherId
     * @return List<Team> for teacher
     */
    List<Team> selectByTeacherId(Integer teacherId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table team
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Team record);
}