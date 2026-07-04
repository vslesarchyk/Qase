package models.cases;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseRq {
    @Expose
    private String description;
    @Expose
    private String preconditions;
    @Expose
    private String postconditions;
    @Expose
    private String title;
    @Expose
    private int severity;
    @Expose
    private int priority;
    @Expose
    private int behavior;
    @Expose
    private int type;
    @Expose
    private int layer;
    @Expose
    private int is_flaky;
}
