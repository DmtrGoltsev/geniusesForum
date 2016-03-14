package DAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import logic.Topic;

public interface TopicsDAO {
    public void addTopic(Topic topic) throws SQLException;   //добавить 
    //public void updateUser(Users user) throws SQLException;//обновить 
    public Topic getTopicById(long id) throws SQLException;    //получить по id
    public List getAllTopics() throws SQLException;              //получить всех
    public void deleteTopic(Topic topic) throws SQLException;//удалить 
    public List getTopicByWords (String name) throws SQLException;// поиск по имени юзера 
    public List getTopicByDate (Date date) throws SQLException;
    public void ChangeTopic (long id) throws SQLException;
    public List SearchByTopic (String user) throws SQLException;
}
