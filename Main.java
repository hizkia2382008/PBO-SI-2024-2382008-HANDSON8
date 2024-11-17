import config.Database;
import repositories.TodoListRepositoryDbImpl;
import repositories.TodoListRepositoryImpl;
import repositories.TodolListRepository;
import services.TodoListService;
import services.TodoListServiceImpl;
import views.TodoListTerminalView;
import views.TodoListView;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args) {
        Database database = new Database("db_hizkia", "root","", "localhost", "3306");
        database.setup();

        TodolListRepository todolListRepository= new TodoListRepositoryDbImpl(database);
        TodoListService todoListService = new TodoListServiceImpl(todolListRepository);
        TodoListView todoListView = new TodoListTerminalView(todoListService);
        todoListView.run();
    }
}
