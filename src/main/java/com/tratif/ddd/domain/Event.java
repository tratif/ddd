package com.tratif.ddd.domain;

import java.io.Serializable;
import java.util.UUID;

public interface Event extends Serializable {

	UUID getId();

}
