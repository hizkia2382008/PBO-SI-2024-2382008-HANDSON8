package repositories;

import config.Database;
import entities.TodoList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryDbImpl implements TodolListRepository {
    private final Database database;

    public TodoListRepositoryDbImpl(final Database database) {
        this.database = database;
    }

    @Override
    public TodoList[] getAll() {
        List<TodoList> todoLists = new ArrayList<>();
        Connection connection = database.getConnection();
        String sqlStatement = "Select * From todos";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            ResultSet  resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                TodoList todoList = new TodoList();
                int id = resultSet.getInt(1);
                String todo = resultSet.getString(2);
                todoList.setId(id);
                todoList.setTodo(todo);
                todoLists.add(todoList);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  todoLists.toArray(TodoList[]::new);
    }

    @Override
    public void add(final TodoList todoList) {

    }

    @Override
    public Boolean remove(final Integer id) {
        return null;
    }

    @Override
    public Boolean edit(final TodoList todoList) {
        return null;
    }
}
