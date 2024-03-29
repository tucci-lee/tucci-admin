package cc.tucci.admin.domain.core.exception;

/**
 * @author tucci
 */
public class BizException extends RuntimeException{

    private final int code;

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(BizCode bizCode){
        this(bizCode.getCode(), bizCode.getMessage());
    }

    public int getCode() {
        return code;
    }
}
