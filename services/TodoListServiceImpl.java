package services;

import entities.TodoList;
import repositories.TodolListRepository;

public class TodoListServiceImpl implements TodoListService{
    private final TodolListRepository TodolListRepository;

    public TodoListServiceImpl( final TodolListRepository todolListRepository) {
        this.TodolListRepository = todolListRepository;
    }

    @Override
    public TodoList[] getTodoList() {
        return TodolListRepository.getAll();
    }

    @Override
    public void addTodoList(final String todo) {
        if (todo.isEmpty() || todo.isBlank()) {
            System.out.println("Masukkan todo dengan benar");
        }
        TodoList todoList= new TodoList();
        todoList.setTodo(todo);
        todolListRepository.add(todoList);
    }

    @Override
    public Boolean removeTodoList(final Integer number) {
        return todolListRepository.remove(number);
    }

    @Override
    public Boolean editTodoList(final Integer number, final String todo) {
        TodoList todoList = new TodoList();
        todoList.setId(number);
        todoList.setTodo(todo);
        return todolListRepository.edit(todoList);
    }
}
