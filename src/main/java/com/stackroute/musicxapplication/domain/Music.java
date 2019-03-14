package com.stackroute.musicxapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value="Music")
public class Music {
    @Id
    @NotNull(message = "Music trackId not be Null")
    private int trackId;
    @NotNull(message = "Music trackName not be Null")
    @Size(min = 1,max = 120, message = "size should be between 1-120")
    private String trackName;
    @NotNull(message = "Music trackComments not be Null")
    @Size(min=3,max = 140)
    private String trackComments;
}
