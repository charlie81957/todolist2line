import java.security.Timestamp;

@Data
class TodoDto{
    private String usreId;
    private String todoId;
    private String todoTitle;
    private String todoContent;
    private boolean isDone;
    Timestamp limitDateTime;
}