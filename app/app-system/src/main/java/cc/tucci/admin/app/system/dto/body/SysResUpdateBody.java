package cc.tucci.admin.app.system.dto.body;


import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author tucci
 */
@Data
public class SysResUpdateBody {

    @NotNull
    private Long id;
    private Long pid;
    @NotBlank
    @Size(max = 20)
    private String name;
    @Size(max = 100)
    private String url;
    @Size(max = 100)
    private String resChar;
    @Range(max = 999)
    private Integer seq;
    @Size(max = 100)
    private String icon;
}
