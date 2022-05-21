package com.example.learningcenter.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data<T> implements Serializable {

    T body;

    Boolean success;

    Integer total;

    AppErrorDTO error;

    @Builder(builderMethodName = "builderSuccess")
    public Data(T body) {
        this.body = body;
        this.success = true;
    }

    public Data(T body, Integer total) {
        this(body);
        this.total = total;
    }

    @Builder(builderMethodName = "builderError")
    public Data(AppErrorDTO error) {
        this.error = error;
        this.success = false;
    }


}
