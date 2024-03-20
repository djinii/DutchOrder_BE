package com.dutchOrder.server.model;


import java.security.Timestamp;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MwOrdering {

	private int mnum;
    private String sname;
    private int onum;
    private String omsg;
    private LocalDateTime odate;
    private String keyvalue;
	
}
