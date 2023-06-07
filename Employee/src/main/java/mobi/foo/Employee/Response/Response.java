package mobi.foo.Employee.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private Object data;
    private boolean status;
    private  String message;
}
